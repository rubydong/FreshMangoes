import os
import pymysql
from helpers import *

CELEBRITIES_DETAILS = 'celebrities/details'
CELEBRITIES_IMAGES = 'celebrities/images'

MOVIE_CREDITS = 'movies/credits'
MOVIE_DETAILS = 'movies/details'
MOVIE_MORE_DETAILS = 'movies/moredetails'
MOVIE_PHOTOS = 'movies/images'
MOVIE_VIDEOS = 'movies/videos'

SHOWS_CREDITS = 'shows/credits'
SHOWS_DETAILS = 'shows/details'
SHOWS_MORE_DETAILS = 'shows/moredetails'
SHOWS_PHOTOS = 'shows/images'
SHOWS_VIDEOS = 'shows/videos'

SEASONS_CREDITS = 'seasons/credits'
SEASONS_DETAILS = 'seasons/details'
SEASONS_PHOTOS = 'seasons/images'
SEASONS_VIDEOS = 'seasons/videos'

EPISODES_CREDITS = 'episodes/credits'
EPISODES_DETAILS = 'episodes/details'
EPISODES_PHOTOS = 'episodes/images'
EPISODES_VIDEOS = 'episodes/videos'

BASE_PHOTO_URL = 'https://image.tmdb.org/t/p/original'
BASE_VIDEO_URL = 'https://www.youtube.com/embed/'

INSERT_CAST = 'insert into `casted` (celebrity_id, content_id, role) values(%s, %s, %s)'
INSERT_CREW = 'insert into `crew` (celebrity_id, content_id, job) values(%s, %s, %s)'
INSERT_CELEBRITY = 'insert into `celebrities` (birthday, birthplace, biography, celebrity_name, id, ' \
                   'profile_picture) values(%s, %s, %s, %s, %s, %s)'
INSERT_CELEBRTY_MEDIA = 'insert into `celebrity_media` (celebrity_id, media_id) values(%s, %s)'
INSERT_CONTENT = 'insert into `content` (content_type, metadata_id, summary_photo, revenue, views) values(%s, %s, %s, %s, %s)'
INSERT_CONTENT_MEDIA = 'insert into `content_media` (content_id, media_id) values(%s, %s)'
INSERT_GENRE = 'insert into `content_genre` (genre, metadata_id) values(%s, %s)'
INSERT_MEDIA = 'insert into `media` (path, media_type) values(%s, %s)'
INSERT_METADATA = 'insert into `content_metadata` (audience_score, content_name, mango_score, maturity_rating, ' \
                  'release_date, runtime, studio_network, summary) values(%s, %s, %s, %s, %s, %s, %s, %s)'
INSERT_SHOW_SEASON = 'insert into `show_seasons` (show_id, season_id) values(%s, %s)'
INSERT_SEASON_EPISODE = 'insert into `season_episodes` (season_id, episode_id) values(%s, %s)'

connection = pymysql.connect(host='localhost',
                             user='root',
                             password='password',
                             db='cse308',
                             charset='utf8mb4',
                             autocommit=True,
                             cursorclass=pymysql.cursors.DictCursor)

cursor = connection.cursor()


def insert_celebrities():
    celebrities_dir = os.listdir(CELEBRITIES_DETAILS)
    for filename in celebrities_dir:
        celebrity_details = load_json(os.path.join(CELEBRITIES_DETAILS, filename))
        celebrity_images = load_json(os.path.join(CELEBRITIES_IMAGES, filename))
        profile_photo_id = None

        if celebrity_details is None or celebrity_details.get("name", None) is None:
            continue

        if celebrity_details.get("profile_path", None) is not None:
            cursor.execute(INSERT_MEDIA, (celebrity_details["profile_path"], 0))
            profile_photo_id = cursor.lastrowid

        birthday = celebrity_details.get("birthday", None)
        if birthday is not None:
            if len(birthday) < 10:
                birthday = None

        cursor.execute(INSERT_CELEBRITY, (birthday,
                                          celebrity_details.get("place_of_birth", "Unknown"),
                                          celebrity_details.get("biography", ""),
                                          celebrity_details["name"],
                                          celebrity_details["id"],
                                          profile_photo_id))
        if celebrity_images is not None:
            for image in celebrity_images.get("results", []):
                if "file_path" not in image or image["file_path"] is None:
                    continue
                cursor.execute(INSERT_MEDIA, (image["file_path"], 0))
                cursor.execute(INSERT_CELEBRTY_MEDIA, (celebrity_details["id"], cursor.lastrowid))


def insert_content(content_metadata, content_type, content_credits, content_details, content_more_details, content_photos,
                   content_videos):

    photos = []
    photos += [backdrop["file_path"] for backdrop in content_photos.get("backdrops", [])]
    photos += [still["file_path"] for still in content_photos.get("stills", [])]

    videos = []
    videos += [BASE_VIDEO_URL + result["key"] for result in content_videos["results"]]

    cursor.execute(INSERT_METADATA, content_metadata)
    content_metadata_id = cursor.lastrowid

    summary_photo_id = None
    if "Poster" in content_more_details:
        cursor.execute(INSERT_MEDIA, (content_more_details["Poster"], 0))
        summary_photo_id = cursor.lastrowid
    elif content_photos.get("posters"):
        cursor.execute(INSERT_MEDIA, (content_photos.get("posters")[0]["file_path"], 0))
        summary_photo_id = cursor.lastrowid

    cursor.execute(INSERT_CONTENT, (content_type, content_metadata_id, summary_photo_id, content_details.get("revenue", None), 0))

    content_id = cursor.lastrowid

    for genre in content_details.get("genres", []):
        cursor.execute(INSERT_GENRE, (genre["id"], content_metadata_id))

    for photo in photos:
        cursor.execute(INSERT_MEDIA, (photo, 0))
        cursor.execute(INSERT_CONTENT_MEDIA, (content_id, cursor.lastrowid))

    for video in videos:
        cursor.execute(INSERT_MEDIA, (video, 1))
        cursor.execute(INSERT_CONTENT_MEDIA, (content_id, cursor.lastrowid))

    for cast_member in content_credits.get("cast", []) + content_credits.get("guest_stars", []):
        cursor.execute(INSERT_CAST, (cast_member["id"], content_id, cast_member["character"]))

    for crew_member in content_credits.get("crew", []):
        cursor.execute(INSERT_CREW, (crew_member["id"], content_id, crew_member["job"]))

    return content_id


def insert_shows():
    shows_dir = os.listdir(SHOWS_DETAILS)
    for filename in shows_dir:
        show_credits = load_json(os.path.join(SHOWS_CREDITS, filename))
        show_details = load_json(os.path.join(SHOWS_DETAILS, filename))
        show_more_details = load_json(os.path.join(SHOWS_MORE_DETAILS, filename))
        show_photos = load_json(os.path.join(SHOWS_PHOTOS, filename))
        show_videos = load_json(os.path.join(SHOWS_VIDEOS, filename))

        mango_score = 0
        maturity_rating = show_more_details.get("Rated", "NOT RATED")

        runtime = show_more_details.get("Runtime", 0)
        if runtime != 0:
            if runtime == "N/A":
                runtime = 0
            else:
                runtime = runtime.split()[0]

        studio_network = show_details["networks"][0]["name"] if len(show_details["networks"]) > 0 else "Unavailable"

        if "Error" not in show_more_details:
            for rating in show_more_details["Ratings"]:
                if rating["Source"] == "Rotten Tomatoes":
                    mango_score = float(rating["Value"].strip("%"))

        audience_score = show_more_details.get("Metascore", 0)
        if audience_score == "N/A":
            audience_score = 0
        else:
            audience_score = float(audience_score)

        show_id = insert_content((audience_score,
                                  show_details["name"],
                                  mango_score,
                                  maturity_rating,
                                  show_details["first_air_date"],
                                  runtime,
                                  studio_network,
                                  show_details["overview"]
                                  ), 1, show_credits, show_details, show_more_details, show_photos, show_videos)

        for season in range(1, show_details["number_of_seasons"] + 1):
            season_filename = f"{show_details['id']}_{season}.json"

            if not os.path.exists(os.path.join(SEASONS_DETAILS, season_filename)):
                continue

            season_credits = load_json(os.path.join(SEASONS_CREDITS, season_filename))
            season_details = load_json(os.path.join(SEASONS_DETAILS, season_filename))
            season_photos = load_json(os.path.join(SEASONS_PHOTOS, season_filename))
            season_videos = load_json(os.path.join(SEASONS_VIDEOS, season_filename))
            season_id = insert_content((
                                        audience_score,
                                        season_details["name"],
                                        mango_score,
                                        maturity_rating,
                                        season_details["air_date"],
                                        runtime,
                                        studio_network,
                                        season_details["overview"],
                                        ), 2, season_credits, season_details, {}, season_photos, season_videos)

            cursor.execute(INSERT_SHOW_SEASON, (show_id, season_id))

            for episode in range(1, len(season_details["episodes"]) + 1):
                episode_filename = f"{show_details['id']}_{season}_{episode}.json"

                if not os.path.exists(os.path.join(EPISODES_DETAILS, episode_filename)):
                    continue

                episode_credits = load_json(os.path.join(EPISODES_CREDITS, episode_filename))
                episode_details = load_json(os.path.join(EPISODES_DETAILS, episode_filename))
                episode_photos = load_json(os.path.join(EPISODES_PHOTOS, episode_filename))
                episode_videos = load_json(os.path.join(EPISODES_VIDEOS, episode_filename))
                episode_id = insert_content((
                                             audience_score,
                                             episode_details["name"],
                                             mango_score,
                                             maturity_rating,
                                             episode_details["air_date"],
                                             runtime,
                                             studio_network,
                                             episode_details["overview"],
                                             ), 3, episode_credits, episode_details, {}, episode_photos, episode_videos)

                cursor.execute(INSERT_SEASON_EPISODE, (season_id, episode_id))


def insert_movies():
    movies_dir = os.listdir(MOVIE_DETAILS)
    for filename in movies_dir:
        movie_credits = load_json(os.path.join(MOVIE_CREDITS, filename))
        movie_details = load_json(os.path.join(MOVIE_DETAILS, filename))
        movie_more_details = load_json(os.path.join(MOVIE_MORE_DETAILS, filename))
        movie_photos = load_json(os.path.join(MOVIE_PHOTOS, filename))
        movie_videos = load_json(os.path.join(MOVIE_VIDEOS, filename))

        movie_name = movie_details["title"]
        mango_score = 0
        maturity_rating = movie_more_details.get("Rated", "NOT RATED")
        release_date = movie_details["release_date"]
        runtime = movie_details.get("runtime", 0)
        studio_network = movie_more_details.get("Production", "Unavailable")
        summary = movie_details["overview"]

        if movie_details["imdb_id"] is not None and "Error" not in movie_more_details:
            for rating in movie_more_details["Ratings"]:
                if rating["Source"] == "Rotten Tomatoes":
                    mango_score = float(rating["Value"].strip("%"))

        audience_score = movie_more_details.get("Metascore", 0)
        if audience_score == "N/A":
            audience_score = 0
        else:
            audience_score = float(audience_score)

        if runtime is None:
            runtime = 0

        insert_content((audience_score,
                        movie_name,
                        mango_score,
                        maturity_rating,
                        release_date,
                        runtime,
                        studio_network,
                        summary
                        ), 0, movie_credits, movie_details, movie_more_details, movie_photos, movie_videos)


def main():
    insert_celebrities()
    insert_movies()
    insert_shows()


if __name__ == "__main__":
    main()
