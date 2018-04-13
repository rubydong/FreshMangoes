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
  runtime: number;
  summary: string;
  cast: Celebrity[];
  releaseDate: Date;
  studioNetwork: String;
}

export class Content {
  id: number;
  type: ContentType;
  media: Media;
  metadata: ContentMetadata;
  summaryPhoto : URL;
  ratings: Rating[];
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
}
