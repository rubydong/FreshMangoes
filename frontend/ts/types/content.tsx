import { Celebrity, CreateCast } from './celebrity';
import { Media } from './media';
import { Rating } from './rating';
import { CurrentUser } from "./user";

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
  interested: boolean;
  disinterested: boolean;
  episodes: Episode[];
  seasons: Season[];
  currentUser: CurrentUser;
  
  constructor() {
    this.id = 0;
    this.type = null;
    this.media = [];
    this.metadata = new ContentMetadata();
    this.summaryPhoto = new Media();
    this.ratings = [];
    this.cast = [];
    this.crew = [];
    this.interested = false;
    this.disinterested = false;
    this.episodes = [];
    this.seasons = [];
    this.currentUser = new CurrentUser();
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
    
  }
}

export class Show extends Content {
  seasons: Season[];

  constructor() {
    super();
    
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
  posters: Media[];
  openingThisWeek: Movie[];
  topBoxOffice: Movie[];
  comingSoon: Movie[];
  highestRatedMovies: Movie[];
  certifiedFreshMovies: Movie[];
  newTonight: Show[];
  mostPopular: Show[];
  highestRatedShows: Show[];
  certifiedFreshShows: Show[];
  selectedContent: Content[];
  selectedMovies: Movie[];
  selectedShows: Show[];
  selectedTitle: string; 

  constructor() {
    this.posters = [];
    this.openingThisWeek = [];
    this.topBoxOffice = [];
    this.comingSoon = [];
    this.highestRatedMovies = [];
    this.certifiedFreshMovies = [];
    this.newTonight = [];
    this.mostPopular = [];
    this.certifiedFreshShows = [];
    this.selectedContent = [];
    this.selectedMovies = [];
    this.selectedShows = [];
    this.selectedTitle = "";
  }
}
export class Page extends Content{

}
export class CreatePage{
  name: string;
  summary: string;
  summaryPhoto: File;
  type: ContentType;
  genres: string [];
  photos: FileList;
  videos: FileList;
  cast: CreateCast[];
  castNum: number;
  showID: number;
  seasonID: number;

  constructor() {
    this.type = ContentType.MOVIE;
    this.genres = [];
    this.photos = null;
    this.videos = null;
    this.cast = [];
    this.castNum = 0;
    this.showID = -1;
    this.seasonID = -1;
    this.name = "";
    this.summary = "";
    this.summaryPhoto = null;
  }
}