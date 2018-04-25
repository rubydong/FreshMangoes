import * as React from "react";
import axios from "axios";
import { parseMedia }  from "../../HelperFunctions.js";
import { ContentMetadata, Show } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";  
import { DetailsComponent } from "../components/DetailsComponent";
import { SeasonEpisodeListComponent } from "../components/SeasonEpisodeListComponent";

export class ShowTemplate extends React.Component {
    state : Show;

    constructor(props) {
      super(props);
      this.state = new Show();
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
                    <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} />             
                    <DetailsComponent data-metadata={this.state.metadata} data-crew={this.state.crew} 
                                      data-id={this.state.id} data-type={this.state.type}/> 
                </div>
                <div className="clear-both"></div>
                <PhotoComponent data-photos={this.state.media}/>
                <VideoComponent data-videos={this.state.media}/>
                <SeasonEpisodeListComponent data-id={this.state.id} data-list={this.state.seasons} data-type="season"/>
                <CastComponent data-cast={this.state.cast} data-name={this.state.metadata.name}/>
            </div>
		</div>

        );
    }
}
