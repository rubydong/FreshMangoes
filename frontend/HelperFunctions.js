import { MEDIA_FULL_PATH, NO_CONTENT_PHOTO, NO_USER_PHOTO } from "./GlobalVariables";

function getMediaUrl(path) {
  return window.location.origin + MEDIA_FULL_PATH + path;
}

export function parseMedia(media) {
    return (media && media.path != "") ? getMediaUrl(media.path) : NO_CONTENT_PHOTO;
}

export function parseUserMedia(media) {
    return (media && media.path != "") ? getMediaUrl(media.path) : NO_USER_PHOTO;
}
export function parseMoreMedia(media, list) {
    if (media && media.path != "") {
        return getMediaUrl(media.path);
    } else {
        if (list && list.length != 0 && list[0].path != "") return getMediaUr(list[0].path);
        return NO_CONTENT_PHOTO;
    }
}

export function parseDate(date) {
    if (date == "") return "";
    var d = new Date(date);
    return d.getMonth() + 1 + '-' + d.getDate() + '-' + d.getFullYear();
}

export function getUrlID() {
    return window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1);
}
