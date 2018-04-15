import * as React from "react";
import { Mangoes } from "./components/Mangoes";
import axios from "axios";
import { parseMedia }  from "../helperFunctions.js";

export class SpotlightTemplate extends React.Component {
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
                    poster: parseMedia(response.data.posterImage),
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
            const newUrl = parseMedia(content.summaryPhoto);
            return <div className="movieshow" key={content.id}>
                <img src={newUrl}/> <br/>
                <a href={"/movie/" + content.id}> {content.metadata.name}</a> <br/>
                <Mangoes data-rating={content.metadata.mangoScore}/> <br/>
                {content.metadata.mangoScore}%
            </div>     
        }); 

        return (
        <div id="spotlight-page">
            <hr/>
            <div className="spotlight-type">
                <b>IN THEATERS</b>
                <ul>
                    <li className="underline"> <a href="">Opening This Week </a></li>
                    <li> <a href="">Top Box Office</a></li>
                    <li> <a href="">Coming Soon</a> </li>
                    <li> <a href="">Certified Fresh Movies </a></li>
                </ul>
                
                <b>TV</b>
                <ul>
                    <li> <a href="">New TV Tonight</a> </li>
                    <li> <a href="">Most Popular TV on RT</a></li>
                    <li> <a href="">Certified Fresh TV </a></li>
                </ul>
            </div>
            
            <div className="spotlight-content">
                <h2>Opening This Week</h2>
                <div className="spotlight-page-posters">
                    {opening} {opening} {opening} {opening}
                </div>
                
                <span className="align-right"><a href="">Next Page</a></span>
            </div>
        </div>
        )
    }
}
