import * as React from "react";
import axios from "axios";
import { parseMedia }  from "../../helperFunctions.js";
import { ContentMetadata, Show } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";  
import { DetailsComponent } from "../components/DetailsComponent";
import { EpisodeListComponent } from "../components/EpisodeListComponent";

export class EpisodeTemplate extends React.Component {
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
                    <SummaryComponent data-title={this.state.metadata.name} 
                                      data-image={this.state.summaryPhoto} 
                                      data-mango={this.state.metadata.mangoScore} 
                                      data-audience={this.state.metadata.audienceScore} 
                                      data-plot={this.state.metadata.summary}
                                      data-list={3} data-list-type="episode"/>
                    <DetailsComponent data-genres={this.state.metadata.genres}
                                      data-premiere={this.state.metadata.releaseDate} 
                                      data-network={this.state.metadata.studio}/>
                </div>

                <PhotoComponent data-photos={this.state.media}/>
                <VideoComponent data-videos={this.state.media}/>
                <EpisodeListComponent/>
                <CastComponent data-cast={this.state.metadata.cast} data-name={this.state.metadata.name}/>
            </div>
		</div>

        );
    }
}
