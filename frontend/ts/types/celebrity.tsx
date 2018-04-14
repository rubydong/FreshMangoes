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
    profilePhoto: URL;
    birthday: Date;
    birthplace: string;
    biography: string;
    media: Media;
    highestRated: Rated;
    lowestRated: Rated;
    roles: {}
  
    constructor() {
        this.name = "";
        this.profilePhoto = null;
        this.birthday = null;
        this.birthplace = "";
        this.biography = "";
        this.media = new Media();
        this.highestRated = new Rated();
        this.lowestRated = new Rated();
        this.roles = {};
    }
  }
  