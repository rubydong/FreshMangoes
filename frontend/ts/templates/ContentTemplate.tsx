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
            //console.log(this.state);
        } catch (err) {
            //window.location.assign('/404');
        }
    }

    render() {
       return (     
        <div className="no-background-image">
            
            <div className="content">
                {this.state.metadata.name == "" ? '' :
                <div>
                    <div className="summary white-component">
                        <EditPageComponent data-state={this.state}/>
                        <SummaryComponent data-metadata={this.state.metadata} data-image={this.state.summaryPhoto} data-media={this.state.media}
                                          data-list-count={this.state.type == ContentType.SEASON ? this.state.numberOfSeasons : 
                                                           (this.state.type == ContentType.EPISODE ? this.state.numberOfEpisodes : 0)}
                                          data-type={this.state.type}
                        />  
                        <DetailsComponent data-state={this.state}/>
                        <div className="clear-both"></div>
                    </div>
                    <div className="clear-both"></div>
                    <PhotoComponent data-photos={this.state.media} data-current-user={this.state.currentUser}/>   
                    <VideoComponent data-videos={this.state.media}/>  
                    <CastComponent data-cast={this.state.cast} data-current-user={this.state.currentUser}/>
                    {this.state.type == ContentType.SHOW ? <SeasonEpisodeListComponent data-seasons={this.state.seasons}/> : ''}
                    {this.state.type == ContentType.SEASON ? <SeasonEpisodeListComponent data-episodes={this.state.episodes}/> : ''}
                    {this.state.type == ContentType.SHOW || this.state.type == ContentType.MOVIE 
                    ? <div className="white-component margin-top-bottom"> 
                        <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name} data-id={this.state.id} 
                                         data-title="Reviews" data-no-margin={true}/> 
                      </div>
                    : ''}
                </div>
                }
            </div>
		</div>
        );
    }
}
