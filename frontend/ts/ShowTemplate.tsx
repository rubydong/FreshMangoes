import * as React from "react";
import { Mangoes } from "./components/Mangoes";
import axios from "axios";
import { parseDate, parseMedia }  from "../helperFunctions.js";
import {PhotoComponent} from './components/PhotoComponent'

export class ShowTemplate extends React.Component {
    state = {
        summaryPhoto: "",
        photos: [],
        videos: [],
        name: "",
        summary: "",
        genres: [],
        mangoScore: 0,
        audienceScore: 0,
        releaseDate: "",
        network: "",
        seasons: [],
        cast: [],
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get('http://localhost:9000/api' + window.location.pathname)
        .then(function (response) {
            currentComponent.setState({ 
                summaryPhoto: parseMedia(response.data.summaryPhoto),
                photos: response.data.media.photos,
                videos: response.data.media.videos,
                name: response.data.metadata.name,
                summary: response.data.metadata.summary,
                genres: response.data.metadata.genres,
                mangoScore: response.data.metadata.mangoScore,
                audienceScore: response.data.metadata.audienceScore,
                releaseDate: parseDate(response.data.metadata.releaseDate),
                network: response.data.metadata.studio,
                seasons: response.data.seasons,
                cast: response.data.metadata.cast
             });
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {

        const genres = this.state.genres.map((genre, i) => {
            return <span key={i}> {genre}{i < this.state.genres.length - 1 ? ', ' : ''}</span>
        });

        // const photos = this.state.photos.map((photo, i) => {
        //     let newUrl = parseMedia(photo);
        //     return <img src={newUrl} key={i}/>
        // });

        const videos = this.state.videos.map((video, i) => {
            let newUrl = parseMedia(video);
            return <video controls> <source src={newUrl} type="video/mp4" key={i}/> </video>
        });
       
        const seasons = this.state.seasons.map((season, i) => {
            let newUrl = parseMedia(season.summaryPhoto);
           
            return <div className="season">
                <img src={newUrl}/>
                <b><a href={"/season/" + season.id}>{season.metadata.name}</a></b> <br/>
                {season.metadata.summary}
                </div>
        });

        const cast = this.state.cast.map((castPerson, i) => {
            let newUrl = parseMedia(castPerson.profilePhoto);
            let role = Object.keys(castPerson.roles[this.state.name])[0];
            return <div className="cast-person" key={i}>
                <img src={newUrl} className="img-align-left"/>
                <b><a href={"../celebrity/" + castPerson.id}>{castPerson.name}</a></b>  <br/> 
                <i>{role}</i>
            </div>
        });

        return (
            
        <div>
            <hr/>
            <div className="content">
                <div className="summary">
                    <img src={this.state.summaryPhoto} className="img-align-left"/> 
                    <div className="summary-title">
                        <h2>{this.state.name}</h2>
                    </div>
                    
                    <div className="plot">
                        <b> MangoMeter <span className="med-margin-right"></span> Audience Score</b> <br/>

                        <Mangoes data-rating={this.state.mangoScore}/>
                        {this.state.mangoScore}%
                        
                        <span className="med-margin-right"></span>

                        <Mangoes data-rating={this.state.audienceScore}/> 
                        {this.state.audienceScore}% <p/><p/>

                        <b>About Movie</b> <br/> 
                        {this.state.summary} <p/> 
                    </div>

                    <div className="content-info">
                        <b>Genres:</b>	{genres} <br/>
                        <b>Directed By:</b>	Ryan Coogler <br/>
                        <b>Written By:</b>	Joe Robert Cole, Ryan Coogler <br/>
                        <b>In Theaters:</b>	{this.state.releaseDate} <br/>
                        <b>Network:</b> {this.state.network} <p/><p/>
                        <button className="btn small-margin-right"> Interested</button>
                        <button className="btn"> Uninterested</button>
                    </div>
                </div>
                
               
                <PhotoComponent data-photos={this.state.photos}/>
                    
                <div className="margin-top-bottom">
                    <h2> Videos </h2> <hr/>
                    <div className="videos"> {videos} </div>
                </div>
                
                <div className="seasons margin-top-bottom">
                    <h2> Seasons </h2> <hr/>
                    {seasons}
                </div>
                
                <div className="casts margin-top-bottom"> 
                    <h2>Cast</h2> <hr/>
                    <div className="flex-center">
                        {cast}
                    </div>
                    <p/>
                    <div className="align-right"><a href="">View All Cast</a></div>
                </div>
            </div>
		</div>

        );
    }
}
