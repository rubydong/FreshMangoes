import { Media } from './media';

export enum CelebrityType {
    ACTOR,
    DIRECTOR,
    PRODUCER, 
    WRITER
}

export class Metadata {
    name: string;
    mangoScore: number;

    constructor() {
        this.name = "";
        this.mangoScore = 0;
    }
}

export class Rated {
    id: number;
    metadata: Metadata;
    constructor() {
        this.id = 0;
        this.metadata = new Metadata();
    }
}


export class Celebrity {
    name: string;
    profilePicture: Media;
    birthday: Date;
    birthplace: string;
    biography: string;
    media: Media[];
    highestRated: Rated;
    lowestRated: Rated;
    role: string;
  
    constructor() {
        this.name = "";
        this.profilePicture = new Media();
        this.birthday = new Date();
        this.birthplace = "";
        this.biography = "";
        this.media = [];
        this.highestRated = new Rated();
        this.lowestRated = new Rated();
        this.role = "";
    }
}
