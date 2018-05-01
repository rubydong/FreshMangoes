import { Content } from './content';

export enum UserType {
    AUDIENCE = "AUDIENCE",
    CRITIC = "CRITIC",
    ADMIN = "ADMIN"
}

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
    highestRatings: Rating[];
    lowestRatings: Rating[];

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
        this.highestRatings = [];
        this.lowestRatings = [];
    }
}

export class CurrentUser {
    interest: boolean;
    userId: number;
    userType: UserType;

    constructor() {
        this.interest = null;
        this.userId = -1;
        this.userType = null;
    }
}

export class Critics {
    critics: User [];
    applicationName: string;
    applicationProfile: string;
    applicationReason: string;

    constructor() {
        this.critics = []
        this.applicationName = "";
        this.applicationProfile = "";
        this.applicationReason = "";
    }
}

export class CriticsApplication {
    user: User;
    statement: string;

    constructor() {
        this.user = new User();
    }
}