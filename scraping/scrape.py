import os
from helpers import *

tmdb_api_key = "b1e9f3b916bba0f268a7aa6793d6a240"
tmdb_url = "https://api.themoviedb.org/3"

omdb_api_key = "aebea659"
omdb_url = "http://www.omdbapi.com"

base_photo_url = 'https://image.tmdb.org/t/p/original'


def scrape(base_url, params, content_id, location):
    for file in ["credits", "images", "videos"]:
        temp = download_json(f"{base_url}/{file}", params)
        save_json(f"{location}/{file}/{content_id}.json", temp)

    details = download_json(f"{base_url}", params)
    save_json(f"{location}/details/{content_id}.json", details)

    if "imdb_id" in details:
        more_details = download_json(f"{omdb_url}", {"apikey": omdb_api_key, "i": details["imdb_id"]})
        save_json(f"{location}/moredetails/{content_id}.json", more_details)

    return details


def scrape_images():
    for type in ["movies", "shows", "seasons", "episodes", "celebrities"]:
        for images_file in os.listdir(f"{type}/images"):
            images = load_json(os.path.join(f"{type}/images", images_file))
            for image in images.get("backdrops", []) + images.get("posters", []) + images.get("results", []):
                file_path = image["file_path"].strip("/")
                fs_file_path = f"scraped_media/{file_path[:2]}/{file_path[2:4]}/{file_path[4:]}"

                if os.path.exists(fs_file_path):
                    continue

                assure_path_exists(f"scraped_media/{file_path[:2]}/{file_path[2:4]}/")
                download_file(base_photo_url + image["file_path"], fs_file_path)


def scrape_videos():
    pass


def scrape_celebrities():
    params = {"api_key": tmdb_api_key}
    for type in ["movies", "shows", "seasons", "episodes"]:
        for credits_file in os.listdir(f"{type}/credits"):
            credits = load_json(os.path.join(f"{type}/credits", credits_file))
            for member in credits.get("cast", []) + credits.get("crew", []) + credits.get("guest_stars", []):
                if not os.path.isfile(f"celebrities/{member['id']}.json"):
                    person = download_json(f"{tmdb_url}/person/{member['id']}", params)
                    save_json(f"celebrities/{member['id']}.json", person)

                    person_images = download_json(f"{tmdb_url}/person/{member['id']}/tagged_images", params)
                    save_json(f"celebrities/images/{member['id']}.json", person_images)


def scrape_show_moredetails():
    params = {"api_key": tmdb_api_key}
    shows_dir = os.listdir("shows/details")
    for filename in shows_dir:
        show_id = os.path.splitext(filename)[0]
        external_ids = download_json(f"{tmdb_url}/tv/{show_id}/external_ids", params)
        if "imdb_id" in external_ids:
            more_details = download_json(f"{omdb_url}", {"apikey": omdb_api_key, "i": external_ids["imdb_id"]})
            save_json(f"shows/moredetails/{show_id}.json", more_details)


def scrape_shows(num_shows):
    page = 1
    while num_shows > 0:
        print(f"{num_shows} shows left")
        discoveries = download_json(f"{tmdb_url}/discover/tv", {"api_key": tmdb_api_key, "page": page})
        count = len(discoveries)

        for discovered in discoveries["results"]:
            base_url = f"{tmdb_url}/tv/{discovered['id']}"
            params = {"api_key": tmdb_api_key}
            details = scrape(base_url, params, discovered['id'], "shows")

            if details['number_of_episodes'] > 200:
                count -= 1
                continue

            for season in range(details["number_of_seasons"]):
                season_base_url = f"{base_url}/season/{season}"
                season_details = scrape(season_base_url, params, f"{details['id']}_{season}", "seasons")

                for episode in season_details["episodes"]:
                    episode_base_url = f"{season_base_url}/episode/{episode['episode_number']}"
                    scrape(episode_base_url, params, f"{details['id']}_{season}_{episode['episode_number']}", "episodes")
        page += 1
        num_shows -= count


def scrape_movies(num_movies):
    page = 1
    while num_movies > 0:
        print(f"{num_movies} movies left")
        discoveries = download_json(f"{tmdb_url}/discover/movie", {"api_key": tmdb_api_key, "page": page})

        for discovered in discoveries["results"]:
            base_url = f"{tmdb_url}/movie/{discovered['id']}"
            params = {"api_key": tmdb_api_key}

            scrape(base_url, params, discovered['id'], "movies")

        page += 1
        num_movies -= len(discoveries["results"])


def assure_path_exists(path):
    if not os.path.exists(path):
        os.makedirs(path)


def main():
    for type in ['movies', 'shows', 'seasons', 'episodes']:
        assure_path_exists(type)
        assure_path_exists(f'{type}/details')
        assure_path_exists(f'{type}/moredetails')
        assure_path_exists(f'{type}/credits')
        assure_path_exists(f'{type}/images')
        assure_path_exists(f'{type}/videos')

    assure_path_exists('celebrities')
    assure_path_exists('celebrities/images')
    assure_path_exists('scraped_media')

    #scrape_movies(2000)
    #scrape_shows(2000)
    #scrape_show_moredetails()
    #scrape_celebrities()
    scrape_images()


if __name__ == "__main__":
    main()
