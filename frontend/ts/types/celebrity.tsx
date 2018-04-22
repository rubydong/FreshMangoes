import { Media } from './media';
import { Content } from './content';

export enum CrewType {
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
    roles: Role[];
    job: string;
  
    constructor() {
        this.name = "";
        this.profilePicture = new Media();
        this.birthday = new Date();
        this.birthplace = "";
        this.biography = "";
        this.media = [];
        this.highestRated = new Rated();
        this.lowestRated = new Rated();
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