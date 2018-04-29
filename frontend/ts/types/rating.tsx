import { User }  from "./user";
import { Content } from "./content";

export enum ReviewierType {
    AUDIENCE, 
    CRITIC
}
export class Rating {
    id: number;
    contentId: number; 
    score: number; 
    body: string;
    type: ReviewierType;
  
    constructor() {
      this.id = 0;
      this.contentId = 0;
      this.score = 0;
      this.body = "";
    }
  }

export class Report extends Rating{
  user: User;
  isFlagged: boolean;
  report: string;
  content: Content;

  constructor() {
    super();
    this.user = new User();
    this.isFlagged = false;
    this.report = "";
  }
}