import { Content } from './content';

export class Rating {
    id: number;
    score: number;
    body: string;
    content: Content;
}

export class User {
    id: number;
    displayName: string;
    profilePicture: string;
    numFollowers: number;
    numFollowing: number;
    followers: User [];
    following: User [];
    interestedList: Content[];
    disinterestedList: Content[];
    currentUser: number;
    ratings: Rating[];

    constructor() {
        this.id = 0;
        this.displayName = "";
        this.profilePicture = "";
        this.numFollowers = 0;
        this.numFollowing = 0;
        this.followers = [];
        this.following = [];
        this.interestedList = [];
        this.disinterestedList = [];
        this.currentUser = -1;
        this.ratings = [];
    }
}

export class Critics {
    critics: User [];
    applicationName: string;
    applicationProfile: string;

    constructor() {
        this.critics = [];
        this.applicationName = "";
        this.applicationProfile = "";
    }
}