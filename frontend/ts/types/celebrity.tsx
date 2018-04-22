import { Media } from './media';
import { Content } from './content';

export enum CrewType {
    ACTOR,
    DIRECTOR,
    PRODUCER, 
    WRITER
}

export class FilmRating {
    highestRatedName: string;
    highestRatedScore: number;
    lowestRatedName: string;
    lowestRatedScore: number;

    constructor() {
        this.highestRatedName = "";
        this.highestRatedScore = 0;
        this.lowestRatedName = "";
        this.lowestRatedScore = 0;
    }
}

export class Celebrity {
    name: string;
    profilePicture: Media;
    birthday: Date;
    birthplace: string;
    biography: string;
    media: Media[];
    roles: Role[];
    job: string;
    
  
    constructor() {
        this.name = "";
        this.profilePicture = new Media();
        this.birthday = new Date();
        this.birthplace = "";
        this.biography = "";
        this.media = [];
        this.roles = [];
        this.job = "";
    }
}

export class Role {
    content: Content;
    role: string;

    constructor() {
        this.content = null;
        this.role = "";
    }
}