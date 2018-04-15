export function parseMedia(media) {
    if (media == "" || media == null) return "";
    if (media.includes("https"))
        return "../" + media.substring(8);
    if (media.includes("http"))
        return "../" + media.substring(7);
    return media;
}

export function parseDate(date) {
    if (date == "") return "";
    var d = new Date(date);
    return d.getMonth()+1 + '-' + d.getUTCDate() + '-' + d.getFullYear();
}

