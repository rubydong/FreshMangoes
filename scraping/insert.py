import json
import os
import pymysql

DETAILS = 'movies/details'
MORE_DETAILS = 'movies/moredetails'
PHOTOS = 'movies/images'
VIDEO = 'movies/videos'
BASE_PHOTO_URL = 'https://image.tmdb.org/t/p/original'
BASE_VIDEO_URL = 'https://www.youtube.com/embed/'

INSERT_CAST = 'insert into `Casted` values(%s, %s, %s)'
INSERT_CELEBRITY = 'insert into `Celebrities` (birthday, birthplace, biography, celebrity_name, celebrity_type, ' \
                   'profile_picture) values(%s, %s, %s, %s, %s, %s)'
INSERT_CONTENT = 'insert into `Content` (content_type, metadata_id, summary_photo) values(%s, %s, %s)'
INSERT_CONTENT_MEDIA = 'insert into `ContentMedia` (content_id, media_id) values(%s, %s)'
INSERT_MEDIA = 'insert into `Media` (path, media_type) values(%s, %s)'
INSERT_METADATA = 'insert into `ContentMetadata` (audience_score, content_name, mango_score, maturity_rating, ' \
                  'release_date, runtime, studio_network, summary) values(%s, %s, %s, %s, %s, %s, %s, %s)'
INSERT_SEASON = 'insert into `Seasons` (show_id, season_id) values(%s, %s)'
INSERT_EPISODE = 'insert into `Episodes` (season_id, episode_id) values(%s, %s)'

connection = pymysql.connect(host='localhost',
                             user='root',
                             db='cse308',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)


def load_json(filename):
    with open(filename) as data_file:
        data = json.load(data_file)
    return data


def insert_movies():
    movies_dir = os.listdir(DETAILS)
    for filename in movies_dir:
        movie_details = load_json(os.path.join(DETAILS, filename))
        movie_more_details = load_json(os.path.join(MORE_DETAILS, filename))
        movie_photos = load_json(os.path.join(PHOTOS, filename))
        movie_videos = load_json(os.path.join(VIDEO, filename))

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

        with connection.cursor() as cursor:
            cursor.execute(INSERT_METADATA, (audience_score,
                                             content_name,
                                             mango_score,
                                             maturity_rating,
                                             release_date,
                                             runtime,
                                             studio_network,
                                             summary))
            connection.commit()
            content_metadata_id = cursor.lastrowid

            cursor.execute(INSERT_MEDIA, (movie_more_details.get("Poster", "N/A"), 0))
            connection.commit()
            summary_photo_id = cursor.lastrowid

            cursor.execute(INSERT_CONTENT, (0,
                                            content_metadata_id,
                                            summary_photo_id))
            connection.commit()
            content_id = cursor.lastrowid

            for photo in content_photos:
                cursor.execute(INSERT_MEDIA, (photo, 0))
                connection.commit()
                cursor.execute(INSERT_CONTENT_MEDIA, (content_id, cursor.lastrowid))
                connection.commit()

            for video in content_videos:
                cursor.execute(INSERT_MEDIA, (video, 1))
                connection.commit()
                cursor.execute(INSERT_CONTENT_MEDIA, (content_id, cursor.lastrowid))
                connection.commit()


def main():
    insert_movies()


if __name__ == "__main__":
    main()