import * as React from "react";
import { Mangoes } from "../components/Mangoes";
import axios from "axios";
import { parseMedia, parseDate }  from "../../helperFunctions.js";
import { PhotoComponent } from '../components/PhotoComponent';
import { VideoComponent } from '../components/VideoComponent';
import { CastComponent } from '../components/CastComponent';
import { RatingComponent } from '../components/RatingComponent';
import { ContentMetadata, Movie } from '../types/content';

export class MovieTemplate extends React.Component {
    state: Movie;

    constructor(props) {
        super(props);
        this.state = new Movie();
    }

    async componentWillMount() {
        try {
            const response = await axios.get('http://localhost:9000/api' + window.location.pathname);
            console.log(response.data);
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
        const genres = this.state.metadata.genres.map((genre, i) => {
            return <span key={i}> {genre}{i < this.state.metadata.genres.length - 1 ? ', ' : ''}</span>
        });

        const summaryPhoto = parseMedia(this.state.summaryPhoto);
        return (
            
        <div>
            <hr/>
            <div className="content">
                <div className="summary">
                    <img src={summaryPhoto} className="img-align-left"/> 
                    <div className="summary-title">
                        <h2>{this.state.metadata.name}</h2>
                    </div>
                    
                    <div className="plot">
                        <b> MangoMeter <span className="med-margin-right"></span> Audience Score</b> <br/>

                        <Mangoes data-rating={this.state.metadata.mangoScore}/>
                        {this.state.metadata.mangoScore}%
                        
                        <span className="med-margin-right"></span>

                        <Mangoes data-rating={this.state.metadata.audienceScore}/> 
                        {this.state.metadata.audienceScore}% <p/><p/>

                        <b>About Movie</b> <br/> 
                        {this.state.metadata.summary} <p/> 
                    </div>

                    <div className="content-info">
                        <b>Rating:</b>	{this.state.metadata.maturityRating}<br/>
                        <b>Genres:</b>	{genres} <br/>
                        <b>Directed By:</b>	Ryan Coogler <br/>
                        <b>Written By:</b>	Joe Robert Cole, Ryan Coogler <br/>
                        <b>In Theaters:</b>	{this.state.metadata.releaseDate} <br/>
                        <b>Runtime:</b>	{this.state.metadata.runtime} minutes <br/>
                        <b>Studio:</b> {this.state.metadata.studioNetwork} <p/><p/>
                        <button className="btn small-margin-right"> Interested</button>
                        <button className="btn"> Uninterested</button>
                    </div>
                </div>
                
                <PhotoComponent data-photos={this.state.media.photos}/>   
                <VideoComponent data-videos={this.state.media.videos}/>  
                <CastComponent data-cast={this.state.metadata.cast} data-name={this.state.metadata.name}/>
                <RatingComponent data-ratings={this.state.ratings} data-name={this.state.metadata.name}/>
                
            </div>
		</div>

        );
    }
}
