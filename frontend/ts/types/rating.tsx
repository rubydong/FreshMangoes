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
  