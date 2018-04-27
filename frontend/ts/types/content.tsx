import { Celebrity } from './celebrity';
import { Media } from './media';
import { Rating } from './rating';

export enum ContentType {
  MOVIE = "MOVIE",
  SHOW = "SHOW",
  SEASON = "SEASON",
  EPISODE = "EPISODE"
}

export class ContentMetadata {
  name: string;
  mangoScore: number;
  audienceScore: number;
  maturityRating: string;
  genres: string[];
  runtime: number;
  summary: string;
  releaseDate: Date;
  studio: String;

  constructor() {
    this.name = "";
    this.mangoScore = 0;
    this.audienceScore = 0;
    this.maturityRating = "";
    this.genres = [];
    this.runtime = 0;
    this.summary = "";
    this.releaseDate = null;
    this.studio = null;
  }
}

export class Content {
  id: number;
  type: ContentType;
  media: Media[];
  metadata: ContentMetadata;
  summaryPhoto : Media;
  ratings: Rating[];
  cast: Celebrity[];
  crew: Celebrity[];

  constructor() {
    this.id = 0;
    this.type = null;
    this.media = [];
    this.metadata = new ContentMetadata();
    this.summaryPhoto = new Media();
    this.ratings = [];
    this.cast = [];
    this.crew = [];
  }
}

export class Movie extends Content {
}

export class Episode extends Content {
}

export class Season extends Content {
  episodes: Episode[];

  constructor() {
    super();
    this.episodes = [];
  }
}

export class Show extends Content {
  seasons: Season[];

  constructor() {
    super();
    this.seasons = [];
  }
}

export class Search {
  celebrities: Celebrity[];
  content: Content[];
  results: number;
  selectedContent: Content[];
  selectedTitle: string;

  constructor() {
    this.celebrities = [];
    this.content = [];
    this.results = 0;
    this.selectedContent = [];
    this.selectedTitle = "";
  }
}

export class Spotlight {
  posterImage: string;
  openingMovies: Movie[];
  topBoxOfficeMovies: Movie[];
  comingSoonMovies: Movie[];
  certifiedFreshMovies: Movie[];
  newShows: Show[];
  mostPopularShows: Show[];
  topDVDStreamingShows: Show[];
  certifiedFreshTV: Show[];
  selectedContent: Content[];
  selectedTitle: string; 

  constructor() {
    this.posterImage = "";
    this.openingMovies = [];
    this.topBoxOfficeMovies = [];
    this.comingSoonMovies = [];
    this.certifiedFreshMovies = [];
    this.newShows = [];
    this.mostPopularShows = [];
    this.topDVDStreamingShows = [];
    this.certifiedFreshTV = [];
    this.selectedContent = [];
    this.selectedTitle = "";
  }
}

export class CreatePage {
  type: ContentType;
  name: string;
  summary: string;
  summaryPhoto: File;
  genres: string [];
  photos: FileList;
  videos: FileList;
  cast: Celebrity[];
  
  constructor() {
    this.type = ContentType.MOVIE;
    this.name = "";
    this.summary = "";
    this.summaryPhoto = null;
    this.genres = [];
    this.photos = null;
    this.videos = null;
    this.cast = [];
  }
}