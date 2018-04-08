import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";
import { parseIndexMedia }  from "../../helperFunctions.js";

export class IndexTemplate extends React.Component {
    state = {
        poster: "",
        opening: [],
        topBoxOffice: [],
        comingSoon: [],
        new: [],
        mostPopular: [],
        topDVDStreaming: []
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get('http://localhost:9000/api/index')
        .then(function (response) {
            currentComponent.setState(
                { 
                    poster: parseIndexMedia(response.data.posterImage),
                    opening: response.data.openingMovies,
                    topBoxOffice: response.data.topBoxOfficeMovies,
                    comingSoon: response.data.comingSoonMovies,
                    new: response.data.newShows,
                    mostPopular: response.data.mostPopularShows,
                    topDVDStreaming: response.data.topDVDStreamingShows
                }
            );
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {

        const opening = this.state.opening.map((content) => {
            const newUrl = parseIndexMedia(content.summaryPhoto);
            return <div className="movieshow" key={content.id}>
                <img src={newUrl}/> <br/>
                <a href={"/movie/" + content.id}> {content.metadata.name}</a> <br/>
                <Mangoes data-rating={content.metadata.mangoScore}/> <br/>
                {content.metadata.mangoScore}%
            </div>     
        }); 

        const newShows = this.state.new.map((content) => {
            const newUrl = parseIndexMedia(content.summaryPhoto);
            return <div className="movieshow" key={content.id}>
                <img src={newUrl}/> <br/>
                <a href={"/show/" + content.id}> {content.metadata.name}</a> <br/>
                <Mangoes data-rating={content.metadata.mangoScore}/> <br/>
                {content.metadata.mangoScore}%
            </div>     
        });

        return (
        <div>
            <img id="poster" src={this.state.poster}/>
            <div className="content">
                <div className="margin-top-bottom spotlight">
                    <h2> Movies Spotlight </h2>	
                    <hr/>
                    <ul className="list-inline align-center spotlight-nav">
                        <li className="underline"><a href="">Opening This Week</a></li>
                        <li><a href="">Top Box Office</a></li>		
                        <li><a href="">Coming Soon</a></li> 
                        <li><a href="/spotlight.html">View All</a></li>
                    </ul>
                
                    <div className="spotlight-posters">
                        {opening}
                    </div>
                </div>

                <div className="margin-top-bottom spotlight">
                    <h2> TV Spotlight </h2>
                    <hr/>
                    
                    <ul className="list-inline align-center spotlight-nav">
                        <li className="underline"> <a href="">New TV</a></li>
                        <li><a href="">Most Popular</a></li>		
                        <li><a href="">Top DVD & Streaming</a></li> 
                        <li><a href="/spotlight.html">View All</a></li>
                    </ul>

                    <div className="spotlight-posters">
                        {newShows}
                    </div>
                </div>
            </div>
        </div>
    )}
}
