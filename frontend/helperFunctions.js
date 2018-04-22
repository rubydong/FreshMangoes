import { NO_USER_PHOTO } from "./GlobalVariables";
import { isNullOrUndefined } from "util";

export function parseMedia(media) {
    return (media && media.path != "") ? media.path : NO_USER_PHOTO;
}

export function parseDate(date) {
    if (date == "") return "";
    var d = new Date(date);
    return d.getMonth()+1 + '-' + d.getUTCDate() + '-' + d.getFullYear();
}

