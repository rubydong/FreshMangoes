import * as React from "react";
import axios from "axios";
import { parseMedia } from "../../helperFunctions.js";
import { ContentMetadata, Movie } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";
import { DetailsComponent } from "../components/DetailsComponent";

export class MovieTemplate extends React.Component {
    state: Movie;

    constructor(props) {
        super(props);
        this.state = new Movie();
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api' + window.location.pathname);
            this.setState(response.data);
            console.log(response.data);
            console.log(response.data.id);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
       return (     
        <div>
            <hr/>
            <div className="content">
                <div className="summary">
                    <SummaryComponent data-title={this.state.metadata.name} 
                                      data-image={parseMedia(this.state.summaryPhoto)} 
                                      data-mango={this.state.metadata.mangoScore} 
                                      data-audience={this.state.metadata.audienceScore} 
                                      data-plot={this.state.metadata.summary} />
                    <DetailsComponent data-rating={this.state.metadata.maturityRating} 
                                      data-genres={this.state.metadata.genres}
                                      data-theaters={this.state.metadata.releaseDate} 
                                      data-runtime={this.state.metadata.runtime}
                                      data-studio={this.state.metadata.studio} />
                </div>
                <PhotoComponent data-photos={this.state.media}/>   
                <VideoComponent data-videos={this.state.media}/>  
                <CastComponent data-cast={this.state.cast}/>
                <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name} 
                                 data-id={this.state.id}/>
            </div>
		</div>
        );
    }
}
