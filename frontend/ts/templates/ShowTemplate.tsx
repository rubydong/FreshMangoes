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

export class ShowTemplate extends React.Component {
    state : Show;

    constructor(props) {
      super(props);
      this.state = new Show();
    }

    async componentDidMount() {
      try {
        const response = await axios.get('http://localhost:9000/api' + window.location.pathname);
        console.log(response.data);
        this.setState(response.data);
      } catch (err) {
        console.log(err);
      }
    }

    render() {
        const seasons = this.state.seasons.map((season, i) => {
            let newUrl = parseMedia(season.summaryPhoto);
            return <div className="season">
                <img src={newUrl}/>
                <b><a href={"/season/" + season.id}>{season.metadata.name}</a></b> <br/>
                {season.metadata.summary}
                </div>
        });

        return (
        <div>
            <hr/>
            <div className="content">
                <div className="summary">
                    <SummaryComponent data-title={this.state.metadata.name} data-image={this.state.summaryPhoto} data-mango={this.state.metadata.mangoScore} 
                                      data-audience={this.state.metadata.audienceScore} data-plot={this.state.metadata.summary}/>
                    <DetailsComponent data-genres={this.state.metadata.genres} data-producers='Matt Duffer, Ross Duffer, Shawn Levy, Dan Cohen, Karl Gajdusek'
                                      data-premiere={this.state.metadata.releaseDate} data-network={this.state.metadata.studio}/>
                </div>

                <PhotoComponent data-photos={this.state.media.photos}/>
                <VideoComponent data-videos={this.state.media.videos}/>

                <div className="seasons margin-top-bottom">
                    <h2> Seasons </h2> <hr/>
                    {seasons}
                </div>
                
                <CastComponent data-cast={this.state.metadata.cast} data-name={this.state.metadata.name}/>
            </div>
		</div>

        );
    }
}
