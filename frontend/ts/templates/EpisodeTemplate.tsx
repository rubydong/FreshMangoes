import * as React from "react";
import axios from "axios";
import { parseMedia }  from "../../HelperFunctions.js";
import { ContentMetadata, Episode } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";  
import { DetailsComponent } from "../components/DetailsComponent";

export class EpisodeTemplate extends React.Component {
    state : Episode;

    constructor(props) {
      super(props);
      this.state = new Episode();
    }

    async componentDidMount() {
      try {
        const response = await axios.get(window.location.origin + '/api' + window.location.pathname);
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
                    <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-media={this.state.media} data-list-type="Episode"/>             
                    <DetailsComponent data-metadata={this.state.metadata} data-crew={this.state.crew} data-type={this.state.type}/>
                </div>
                <div className="clear-both"></div>
                <PhotoComponent data-photos={this.state.media}/>
                <VideoComponent data-videos={this.state.media}/>
                <CastComponent data-cast={this.state.cast} data-name={this.state.metadata.name}/>
                <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name} data-id={this.state.id}/>
            </div>
		</div>

        );
    }
}
