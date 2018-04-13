import { Celebrity } from './celebrity';
import { Media } from './media';
import { Rating } from './rating';

export enum ContentType {
  MOVIE,
  SHOW,
  SEASON,
  EPISODE
}

export interface ContentMetadata {
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

export interface Content {
  id: number;
  type: ContentType;
  media: Media;
  metadata: ContentMetadata;
  summaryPhoto : URL;
  ratings: Rating[];
}

export interface Movie extends Content {
}

export interface Episode extends Content {
}

export interface Season extends Content {
  episodes: Episode[];
}

export interface Show extends Content {
  seasons: Season[];
}
