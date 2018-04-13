import * as React from "react";
import { Mangoes } from "./components/Mangoes";
import axios from "axios";
import { parseMedia, parseDate }  from "../helperFunctions.js";
import { PhotoComponent } from './components/PhotoComponent';
import { VideoComponent } from './components/VideoComponent';
import { CastComponent } from './components/CastComponent';

export class MovieTemplate extends React.Component {
    state = {
        summaryPhoto: "",
        photos: [],
        videos: [],
        name: "",
        maturityRating: "",
        summary: "",
        genres: [],
        runTime: 0,
        mangoScore: 0,
        audienceScore: 0,
        releaseDate: "",
        studio: "",
        cast: [],

        numMangos: "",
        reviewBody: ""
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get("http://localhost:9000/api" + window.location.pathname)
        .then(function (response) {
            currentComponent.setState({ 
                summaryPhoto: parseMedia(response.data.summaryPhoto),
                photos: response.data.media.photos,
                videos: response.data.media.videos,
                name: response.data.metadata.name,
                maturityRating: response.data.metadata.maturityRating,
                summary: response.data.metadata.summary,
                genres: response.data.metadata.genres,
                runTime: response.data.metadata.runTime,
                mangoScore: response.data.metadata.mangoScore,
                audienceScore: response.data.metadata.audienceScore,
                releaseDate: parseDate(response.data.metadata.releaseDate),
                studio: response.data.metadata.studio,
                cast: response.data.metadata.cast
             });

             console.log(response.data);
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    handleMangoChange = event => {
        this.setState({ numMangos: event.value });
        console.log(event.value);
    }

    handleBodyChange = event => {
        this.setState({ reviewBody: event.value });
        console.log(event.value)
    }

    addReview() {
    }

    render() {
        const genres = this.state.genres.map((genre, i) => {
            return <span key={i}> {genre}{i < this.state.genres.length - 1 ? ', ' : ''}</span>
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
                        <b>Rating:</b>	{this.state.maturityRating}<br/>
                        <b>Genres:</b>	{genres} <br/>
                        <b>Directed By:</b>	Ryan Coogler <br/>
                        <b>Written By:</b>	Joe Robert Cole, Ryan Coogler <br/>
                        <b>In Theaters:</b>	{this.state.releaseDate} <br/>
                        <b>Runtime:</b>	{this.state.runTime} minutes <br/>
                        <b>Studio:</b> {this.state.studio} <p/><p/>
                        <button className="btn small-margin-right"> Interested</button>
                        <button className="btn"> Uninterested</button>
                    </div>
                </div>
                
                <PhotoComponent data-photos={this.state.photos}/>   
                <VideoComponent data-videos={this.state.videos}/>  
                <CastComponent data-cast={this.state.cast} data-name={this.state.name}/>
                
                <div className="padding"></div>
                <div className="reviews margin-top-bottom">
                    <h2> Reviews </h2>
                    <hr/>
                
                <div className="review pull-right">
                    <b><a href="">Matthew Rozsa</a></b> 
                    <span className="align-right"> <Mangoes data-rating={this.state.mangoScore}/></span> <br/>
                    <i> {this.state.name} </i>
                    <hr/>
                    "When it comes to creative visuals, engaging action and likable characters, "{this.state.name}" stands confidently next to the best fare offered up by the Marvel Cinematic Universe."
                </div>
                <div className="review pull-left">
                    <b><a href="">Christopher Orr</a></b> 
                    <span className="align-right"> <Mangoes data-rating={this.state.mangoScore}/></span> <br/>
                    <i>{this.state.name}</i>
                    
                    <hr/>
                    "Whether or not this is the best film Marvel Studios has made to date-and it is clearly in the discussion-it is by far the most thought-provoking."
                </div>
                <div className="review pull-right">
                    <b><a href="">J. R. Jones</a></b> 
                    <span className="align-right"> <Mangoes data-rating={this.state.mangoScore}/></span> <br/>
                    <i>{this.state.name}</i>
                    
                    <hr/>
                    "The identity politics provide a fresh spin to the genre's increasingly tedious narrative formula."
                </div>
                <div className="review pull-left">
                    <b><a href="">Anthony Lane</a></b> 
                    <span className="align-right"> <Mangoes data-rating={this.state.mangoScore}/></span> <br/>
                    <i>{this.state.name}</i>
                    
                    <hr/>
                    "Jordan has swagger to spare, with those rolling shoulders, but there's a breath of charm, too, all the more seductive in the overblown atmosphere of Marvel. He's twice as pantherish as the Panther."
                </div>
                    
                    <span className="align-right small-padding-top"> <a href="" data-toggle="modal" data-target="#rating-modal">Add a Rating</a>  | <a href="">View All Reviews </a> </span>
                    
                    
                    <div id="rating-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <h2>Add Rating</h2>
                            <form>
                                Rating out of five
                                <select onChange={this.handleMangoChange} className="form-control">
                                <option value="five-mangoes">Five Mangoes</option>
                                <option value="four-mangoes">Four Mangoes</option>
                                <option value="three-mangoes">Three Mangoes</option>
                                <option value="two-mangoes">Two Mangoes</option>
                                <option value="one-mango">One Mango</option>
                                </select>
                                <p/><p/>
                                Review
                                <textarea className="form-control"></textarea>
                                <p/><p/>

                            <button type="submit" className="btn btn-primary">Submit Review</button>
                            </form>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
		</div>

        );
    }
}
