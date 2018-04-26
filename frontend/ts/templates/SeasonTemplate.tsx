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
import { SeasonEpisodeListComponent } from "../components/SeasonEpisodeListComponent";

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
        // console.log(response);
        // console.log(this.state.episodes);
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
                    <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-media={this.state.media} data-list-type="Season"/>             
                    <DetailsComponent data-metadata={this.state.metadata} data-crew={this.state.crew} 
                                                    data-id={this.state.id} data-type={this.state.type}/>
                </div>
                <div className="clear-both"></div>
                <PhotoComponent data-photos={this.state.media}/>
                <VideoComponent data-videos={this.state.media}/>
                <SeasonEpisodeListComponent data-list={this.state.episodes} data-type="episode"/>
                <CastComponent data-cast={this.state.cast} data-name={this.state.metadata.name}/>
                <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name} data-id={this.state.id}/>
            </div>
		</div>

        );
    }
}
