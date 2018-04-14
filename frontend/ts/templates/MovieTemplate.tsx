import * as React from "react";
import axios from "axios";
import { parseMedia, parseDate }  from "../../helperFunctions.js";
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
            const response = await axios.get('http://localhost:9000/api' + window.location.pathname);
            console.log(response.data);
            this.setState(response.data);
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
                    <SummaryComponent data-title={this.state.metadata.name} data-image={this.state.summaryPhoto} data-mango={this.state.metadata.mangoScore} 
                                      data-audience={this.state.metadata.audienceScore} data-plot={this.state.metadata.summary} />
                    <DetailsComponent data-rating={this.state.metadata.maturityRating} data-genres={this.state.metadata.genres} data-directors='Ryan Coogler'
                                      data-writers='Ryan Coogler' data-theaters={this.state.metadata.releaseDate} data-runtime={this.state.metadata.runTime}
                                      data-studio={this.state.metadata.studio} />
                </div>
                <PhotoComponent data-photos={this.state.media.photos}/>   
                <VideoComponent data-videos={this.state.media.videos}/>  
                <CastComponent data-cast={this.state.metadata.cast} data-name={this.state.metadata.name}/>
                <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name} data-review-style='fancy'/>
            </div>
		</div>
        );
    }
}
