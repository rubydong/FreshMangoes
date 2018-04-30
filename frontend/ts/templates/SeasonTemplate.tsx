import * as React from "react";
import axios from "axios";
import { parseMedia }  from "../../HelperFunctions.js";
import { ContentMetadata, Season, ContentType } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";  
import { DetailsComponent } from "../components/DetailsComponent";
import { SeasonEpisodeListComponent } from "../components/SeasonEpisodeListComponent";
import { EditPageComponent } from "../components/EditPageComponent";

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
                {this.state.metadata.name == "" ? <h2>There is no season here.</h2> :
                <div>
                    <div className="summary">
                        <EditPageComponent data-state={this.state}/>
                        <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-media={this.state.media} data-type={ContentType.SEASON}/>                    
                        <DetailsComponent data-metadata={this.state.metadata} data-crew={this.state.crew} data-id={this.state.id} data-type={this.state.type}/>
                    </div>
                    <div className="clear-both"></div>
                    <PhotoComponent data-photos={this.state.media}/>
                    <VideoComponent data-videos={this.state.media}/>
                    <SeasonEpisodeListComponent data-episodes={this.state.episodes}/>
                    <CastComponent data-cast={this.state.cast} data-name={this.state.metadata.name}/>
                </div>
                }
            </div>
		</div>

        );
    }
}
