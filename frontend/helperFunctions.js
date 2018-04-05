export function parseMedia(media) {
    if (media == "") return "";
    if (media.includes("https"))
        return "../" + media.substring(8);
    return media;
}

export function parseIndexMedia(media) {
    if (media == "" || !media.includes("https")) return media;
    // console.log(media.substring(8));
    return media.substring(8);
}

export function parseDate(date) {
    if (date == "") return "";
    return date.substring(0, 10);
}

