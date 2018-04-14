import { Content } from './content';

export class User {
    id: number;
    displayName: string;
    profilePicture: string;
    numFollowers: number;
    numFollowing: number;
    interestedList: Content[];
    disinterestedList: Content[];
    currentUser: number;

    constructor() {
        this.id = 0;
        this.displayName = "";
        this.profilePicture = "";
        this.numFollowers = 0;
        this.numFollowing = 0;
        this.interestedList = [];
        this.disinterestedList = [];
        this.currentUser = -1;
    }
  }
  