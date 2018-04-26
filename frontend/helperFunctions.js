import { NO_CONTENT_PHOTO } from "./GlobalVariables";

export function parseMedia(media) {
    return (media && media.path != "") ? media.path : NO_CONTENT_PHOTO;
}

export function parseMoreMedia(media, list) {
    if (media && media.path != "") {
        return media.path;
    } else {
        if (list && list.length != 0 && list[0].path != "") return list[0].path;
        return NO_CONTENT_PHOTO;
    }
}

export function parseDate(date) {
    if (date == "") return "";
    var d = new Date(date);
    return d.getMonth()+1 + '-' + d.getUTCDate() + '-' + d.getFullYear();
}

