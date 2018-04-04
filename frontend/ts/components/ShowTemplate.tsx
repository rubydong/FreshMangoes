import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";
import { parseMedia, parseDate }  from "../../helperFunctions.js";

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
        cast: []
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get('http://localhost:8080/show/0')
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

        const photos = this.state.photos.map((photo, i) => {
            let newUrl = parseMedia(photo);
            return <img src={newUrl} key={i}/>
        });

        const videos = this.state.videos.map((video, i) => {
            let newUrl = parseMedia(video);
            return <video controls> <source src={newUrl} type="video/mp4" key={i}/> </video>
        });
        
        const cast = this.state.cast.map((castPerson, i) => {
            let newUrl = parseMedia(castPerson.profilePhoto);
            return <div className="cast-person" key={i}>
                <img src={newUrl} className="img-align-left"/>
                <b><a href={"../celebrity/" + castPerson.id}>{castPerson.name}</a></b>  <br/> 
                <i>{castPerson.role}</i>
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
                
                <div className="photos padding-top margin-top-bottom-">
                    <h2> Photos </h2> <p/> <hr/>
                    <div className="photos-inner"> {photos} </div>     
                </div>
                
                <div className="margin-top-bottom">
                    <h2> Videos </h2> <hr/>
                    <div className="videos"> {videos} </div>
                </div>
                
                <div className="seasons margin-top-bottom">
                    <h2> Seasons </h2> <hr/>
                    <div className="season">
                        <img src="../images/tvshow/strangerthings.jpg"/><b><a href="">Stranger Things: Season 2</a></b> 
                        <br/><i>2017, Netflix, 9 episodes, 94% rating</i><br/>
                        Stranger Things' slow-building sophomore season balances moments of humor and a nostalgic sweetness against a growing horror that's all the more effective thanks to the show's full-bodied characters and evocative tone.
                    </div>
                    
                    <div className="season">
                        <img src="../images/tvshow/strangerfirst.jpg"/>
                        <b><a href="">Stranger Things: Season 1</a></b> <br/><i>2016, Netflix, 8 episodes, 94% rating</i>
                        <br/>
                        Exciting, heartbreaking, and sometimes scary, Stranger Things acts as an addictive homage to Spielberg films and vintage 1980s television. <br/>
                    </div>
                </div>
                
                <div className="casts margin-top-bottom"> 
                    <h2>Cast</h2>
                    <hr/>
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