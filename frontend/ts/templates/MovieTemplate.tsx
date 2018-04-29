import * as React from "react";
import axios from "axios";
import { ContentMetadata, Movie } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";
import { DetailsComponent } from "../components/DetailsComponent";
import { EditPageComponent } from "../components/EditPageComponent";
import { getUrlID } from "../../HelperFunctions";

export class MovieTemplate extends React.Component {
    state: Movie;

    constructor(props) {
        super(props);
        this.state = new Movie();
    }

    async componentWillMount() {
        try {
            // const currentUser = await axios.get(window.location.origin + '/api/getCurrentUser?contentId=' + getUrlID());
            const response = await axios.get(window.location.origin + '/api' + window.location.pathname);
            this.setState(response.data);
            // console.log(currentUser);
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
                    <EditPageComponent data-state={this.state}/>
                    <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-media={this.state.media}/>             
                    <DetailsComponent data-metadata={this.state.metadata} data-crew={this.state.crew} 
                                      data-id={this.state.id} data-type={this.state.type} data-state={this.state}/>
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
