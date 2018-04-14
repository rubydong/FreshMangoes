export function parseMedia(media) {
    if (media == "" || media == null) return "";
    if (media.includes("https"))
        return "../" + media.substring(8);
    return media;
}

export function parseProfileMedia(media) {
    return "../" + media.substring(7);
}

export function parseIndexMedia(media) {
    if (media == "" || !media.includes("https")) return media;
    return media.substring(8);
}

export function parseDate(date) {
    if (date == "") return "";
    var d = new Date(date);
    return d.getMonth()+1 + '-' + d.getUTCDate() + '-' + d.getFullYear();
}

