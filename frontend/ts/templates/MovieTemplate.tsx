import * as React from "react";
import axios from "axios";
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
        } catch (err) {
            console.log(err);
            // window.location.assign('/../404');
        }
    }

    render() {
       return (     
        <div>
            <hr/>
            <div className="content">
                <div className="summary">
                    <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-media={this.state.media}/>             
                    <DetailsComponent data-metadata={this.state.metadata} data-crew={this.state.crew} 
                                      data-id={this.state.id} data-type={this.state.type}/>
                </div>
                <div className="clear-both"></div>
                <PhotoComponent data-photos={this.state.media}/>   
                <VideoComponent data-videos={this.state.media}/>  
                <CastComponent data-cast={this.state.cast}/>
                <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name} data-id={this.state.id}/>
            </div>
		</div>
        );
    }
}
