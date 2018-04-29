import json
import requests
import time


def load_json(filename):
    with open(filename) as data_file:
        data = json.load(data_file)
    return data


def download_file(url, local_filename):
    r = requests.get(url, stream=True)
    with open(local_filename, 'wb') as f:
        for chunk in r.iter_content(chunk_size=1024):
            if chunk:
                f.write(chunk)
    return local_filename


def download_json(url, params):
    print(url)
    while True:
        try:
            res = requests.get(url, params)
            if res.status_code != 200:
                print('small sleep')
                time.sleep(10)
            else:
                break
        except Exception:
            print('big sleep')
            time.sleep(60)

    return res.json()


def save_json(filename, data):
    with open(filename, 'w') as fp:
        json.dump(data, fp)