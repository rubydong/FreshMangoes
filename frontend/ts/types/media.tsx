export enum MediaType {
  PHOTO,
  VIDEO
}

export class Media {
  id: number;
  path: string;
  type: MediaType 
  
  constructor() {
    this.id = 0;
    this.path = '';
    this.type = null;
  }
}
