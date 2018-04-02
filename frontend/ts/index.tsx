import * as React from "react";
import * as ReactDOM from "react-dom";
import "../bootstrap/css/bootstrap.css";
import "../css/style.css";
import {Header} from "./components/header";
const data = require('../json/index.json');

ReactDOM.render(
    <div>
        <Header/>
        <img id="poster" src={data.poster}/>
        
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
                {data.opening.map((content, i) =>
                    <div className="movieshow" key={i}>
                        <img src={content.photo}/> <br/>
                        <a href={content.url}> {content.name}</a> <br/>
                        <div className="rating" data-rating={content.score}> <br/>{content.score}%</div>
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
                {data.new.map((content, i) =>
                    <div className="movieshow" key={i}>
                        <img src={content.photo}/> <br/>
                         <a href={content.url}> {content.name}</a> <br/>
                         <div className="rating" data-rating={content.score}> <br/>{content.score}%</div>
                    </div>     
                )}
            </div>
        </div>
        </div>
    </div>,
    document.getElementById("index")
);
