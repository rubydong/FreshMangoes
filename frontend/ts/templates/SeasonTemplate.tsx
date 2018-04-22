import * as React from "react";
import axios from "axios";
import { parseMedia }  from "../../HelperFunctions.js";
import { ContentMetadata, Season } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";  
import { DetailsComponent } from "../components/DetailsComponent";
import { EpisodeListComponent } from "../components/EpisodeListComponent";

export class SeasonTemplate extends React.Component {
    state : Season;

    constructor(props) {
      super(props);
      this.state = new Season();
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
                    <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-list={3} data-list-type="season"/>             
                    <DetailsComponent data-metadata={this.state.metadata} data-crew={this.state.crew} data-type={this.state.type}/>
                </div>
                <PhotoComponent data-photos={this.state.media}/>
                <VideoComponent data-videos={this.state.media}/>
                <EpisodeListComponent data-episodes={this.state.episodes}/>
                <CastComponent data-cast={this.state.cast} data-name={this.state.metadata.name}/>
            </div>
		</div>

        );
    }
}
