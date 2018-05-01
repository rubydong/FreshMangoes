import * as React from "react";
import axios from "axios";
import { ContentMetadata, Content, ContentType } from '../types/content';
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { SummaryComponent } from "../components/SummaryComponent";
import { DetailsComponent } from "../components/DetailsComponent";
import { EditPageComponent } from "../components/EditPageComponent";
import { SeasonEpisodeListComponent } from "../components/SeasonEpisodeListComponent";
import { getUrlID } from "../../HelperFunctions";

export class ContentTemplate extends React.Component {
    state: Content;

    constructor(props) {
        super(props);
        this.state = new Content();
    }

    async componentWillMount() {
        try {
            const contentPromise = axios(window.location.origin + '/api' + window.location.pathname);
            const currentUserPromise = axios(window.location.origin + '/api/getCurrentUser?contentId=' + getUrlID());
            const [content, currentUser] = await Promise.all([contentPromise, currentUserPromise]);
            this.setState(content.data);
            this.setState({currentUser : currentUser.data});
            console.log(this.state);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
       return (     
        <div className="no-background-image">
            <hr className="header-hr"/>
            <div className="content">
                {this.state.metadata.name == "" ? <h2>There is nothing here.</h2> :
                <div>
                    <div className="summary">
                        <EditPageComponent data-state={this.state}/>
                        <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-media={this.state.media}/>             
                        <DetailsComponent data-state={this.state}/>
                    </div>
                    <div className="clear-both"></div>
                    <PhotoComponent data-photos={this.state.media} data-current-user={this.state.currentUser}/>   
                    <VideoComponent data-videos={this.state.media}/>  
                    <CastComponent data-cast={this.state.cast} data-current-user={this.state.currentUser}/>
                    {this.state.type == ContentType.SHOW ? <SeasonEpisodeListComponent data-seasons={this.state.seasons}/> : ''}
                    {this.state.type == ContentType.SEASON ? <SeasonEpisodeListComponent data-episodes={this.state.episodes}/> : ''}
                    {this.state.type == ContentType.SHOW || this.state.type == ContentType.MOVIE 
                    ? <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name} data-id={this.state.id}/>
                    : ''}
                </div>
                }
            </div>
		</div>
        );
    }
}
