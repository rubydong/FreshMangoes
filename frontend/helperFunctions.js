import { NO_USER } from "./GlobalVariables";

export function parseMedia(media) {
    return media ? media.path : NO_USER;
}

export function parseDate(date) {
    if (date == "") return "";
    var d = new Date(date);
    return d.getMonth()+1 + '-' + d.getUTCDate() + '-' + d.getFullYear();
}

