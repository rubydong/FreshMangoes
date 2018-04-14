import { Celebrity } from './celebrity';
import { Media } from './media';
import { Rating } from './rating';

export enum ContentType {
  MOVIE,
  SHOW,
  SEASON,
  EPISODE
}

export class ContentMetadata {
  name: string;
  mangoScore : number;
  audienceScore : number;
  maturityRating : string;
  genres: string[];
  runTime: number;
  summary: string;
  cast: Celebrity[];
  releaseDate: Date;
  studio: String;

  constructor() {
    this.name = "";
    this.mangoScore = 0;
    this.audienceScore = 0;
    this.maturityRating = "";
    this.genres = [];
    this.runTime = 0;
    this.summary = "";
    this.cast = [];
    this.releaseDate = null;
    this.studio = null;
  }
}

export class Content {
  id: number;
  type: ContentType;
  media: Media;
  metadata: ContentMetadata;
  summaryPhoto : URL;
  ratings: Rating[];

  constructor() {
    this.id = 0;
    this.type = null;
    this.media = new Media();
    this.metadata = new ContentMetadata();
    this.summaryPhoto = null;
    this.ratings = [];
  }
}

export class Movie extends Content {
}

export class Episode extends Content {
}

export class Season extends Content {
  episodes: Episode[];
}

export class Show extends Content {
  seasons: Season[];

  constructor() {
    super();
    this.seasons = [];
  }
}
