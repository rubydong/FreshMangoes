import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";

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
        axios.get('https://ca8135fe-1ee0-465a-8147-c5d034840cbf.mock.pstmn.io/index')
        .then(function (response) {
            currentComponent.setState(
                { 
                    poster: response.data.poster,
                    opening: response.data.opening,
                    topBoxOffice: response.data.topBoxOffice,
                    comingSoon: response.data.comingSoon,
                    new: response.data.new,
                    mostPopular: response.data.mostPopular,
                    topDVDStreaming: response.data.topDVDStreaming
                }
            );
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {
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
                        {this.state.opening.map((content) =>
                            <div className="movieshow" key={content.id}>
                                <img src={content.photo}/> <br/>
                                <a href={"/movie/" + content.id}> {content.name}</a> <br/>
                                <Mangoes data-rating={content.score}/> <br/>
                                {content.score}%
                            </div>     
                        )}
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
                        {this.state.new.map((content) =>
                            <div className="movieshow" key={content.id}>
                                <img src={content.photo}/> <br/>
                                <a href={"/show/" + content.id}> {content.name}</a> <br/>
                                <Mangoes data-rating={content.score}/> <br/>
                                {content.score}%
                            </div>     
                        )}
                    </div>
                </div>
            </div>
        </div>
    )}
}
