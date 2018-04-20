import os
import pymysql
from helpers import *

MOVIE_CREDITS = 'movies/credits'
MOVIE_DETAILS = 'movies/details'
MOVIE_MORE_DETAILS = 'movies/moredetails'
MOVIE_PHOTOS = 'movies/images'
MOVIE_VIDEO = 'movies/videos'

BASE_PHOTO_URL = 'https://image.tmdb.org/t/p/original'
BASE_VIDEO_URL = 'https://www.youtube.com/embed/'

CELEBRITIES = 'celebrities'

INSERT_CAST = 'insert into `Casted` (celebrity_id, content_id, character_name) values(%s, %s, %s)'
INSERT_CREW = 'insert into `Crew` (celebrity_id, content_id, job) values(%s, %s, %s)'
INSERT_CELEBRITY = 'insert into `Celebrities` (birthday, birthplace, biography, celebrity_name, id, ' \
                   'profile_picture) values(%s, %s, %s, %s, %s, %s)'
INSERT_CONTENT = 'insert into `Content` (content_type, metadata_id, summary_photo) values(%s, %s, %s)'
INSERT_CONTENT_MEDIA = 'insert into `Content_Media` (content_id, media_id) values(%s, %s)'
INSERT_MEDIA = 'insert into `Media` (path, media_type) values(%s, %s)'
INSERT_METADATA = 'insert into `Content_Metadata` (audience_score, content_name, mango_score, maturity_rating, ' \
                  'release_date, runtime, studio_network, summary) values(%s, %s, %s, %s, %s, %s, %s, %s)'
INSERT_SEASON = 'insert into `Seasons` (show_id, season_id) values(%s, %s)'
INSERT_EPISODE = 'insert into `Episodes` (season_id, episode_id) values(%s, %s)'

connection = pymysql.connect(host='localhost',
                             user='root',
                             db='cse308',
                             charset='utf8mb4',
                             autocommit=True,
                             cursorclass=pymysql.cursors.DictCursor)

cursor = connection.cursor()


def insert_celebrities():
    celebrities_dir = os.listdir(CELEBRITIES)
    for filename in celebrities_dir:
        celebrity_details = load_json(os.path.join(CELEBRITIES, filename))
        print(celebrity_details)
        profile_photo_id = None
        if celebrity_details.get("profile_path", None) is not None:
            cursor.execute(INSERT_MEDIA, (BASE_PHOTO_URL + celebrity_details["profile_path"], 0))
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


def insert_movies():
    movies_dir = os.listdir(MOVIE_DETAILS)
    for filename in movies_dir:
        movie_details = load_json(os.path.join(MOVIE_DETAILS, filename))
        movie_more_details = load_json(os.path.join(MOVIE_MORE_DETAILS, filename))
        movie_photos = load_json(os.path.join(MOVIE_PHOTOS, filename))
        movie_videos = load_json(os.path.join(MOVIE_VIDEO, filename))
        movie_credits = load_json(os.path.join(MOVIE_CREDITS, filename))

        audience_score = 0
        content_name = movie_details["title"]
        mango_score = 0
        maturity_rating = movie_more_details.get("Rated", "NOT RATED")
        release_date = movie_details["release_date"]
        runtime = movie_details.get("runtime", -1)
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

        content_photos = []
        content_photos += [BASE_PHOTO_URL + backdrop["file_path"] for backdrop in movie_photos.get("backdrop", [])]
        content_photos += [BASE_PHOTO_URL + poster["file_path"] for poster in movie_photos.get("posters", [])]

        content_videos = []
        content_videos += [BASE_VIDEO_URL + result["key"] for result in movie_videos["results"]]

        cursor.execute(INSERT_METADATA, (audience_score,
                                         content_name,
                                         mango_score,
                                         maturity_rating,
                                         release_date,
                                         runtime,
                                         studio_network,
                                         summary))
        content_metadata_id = cursor.lastrowid

        cursor.execute(INSERT_MEDIA, (movie_more_details.get("Poster", "N/A"), 0))
        summary_photo_id = cursor.lastrowid

        cursor.execute(INSERT_CONTENT, (0,
                                        content_metadata_id,
                                        summary_photo_id))
        content_id = cursor.lastrowid

        for photo in content_photos:
            cursor.execute(INSERT_MEDIA, (photo, 0))
            cursor.execute(INSERT_CONTENT_MEDIA, (content_id, cursor.lastrowid))

        for video in content_videos:
            cursor.execute(INSERT_MEDIA, (video, 1))
            cursor.execute(INSERT_CONTENT_MEDIA, (content_id, cursor.lastrowid))

        for cast_member in movie_credits["cast"]:
            cursor.execute(INSERT_CAST, (cast_member["id"], content_id, cast_member["character"]))

        for crew_member in movie_credits["crew"]:
            cursor.execute(INSERT_CREW, (crew_member["id"], content_id, crew_member["job"]))


def main():
    insert_celebrities()
    insert_movies()


if __name__ == "__main__":
    main()