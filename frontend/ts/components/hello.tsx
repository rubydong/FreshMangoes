import * as React from "react";

export interface HelloProps { compiler: string; framework: string; }

// 'HelloProps' describes the shape of props.
// State is never set so we use the '{}' type.
export class Hello extends React.Component {
    render() {
        return (
        <div>
            <img id="poster" src="images/greatestshowmanbanner.jpg"/>
            
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
                    <div className="movieshow">
                        <img src="images/posters/latest1.jpeg"/> <br/>
                        <a href="">Rascal Rebel Rabbit (2018)</a> <br/>
                        <div className="rating" data-rating="95"> <br/> 95% </div>	
                    </div>
                    
                    <div className="movieshow">
                        <img src="images/posters/latest2.jpeg"/> <br/>
                        <a href="">The 15:17 To Paris (2018) </a><br/>
                        <div className="rating" data-rating="58"> <br/> 58% </div>	
                    </div>
                    
                    <div className="movieshow">
                        <img src="images/posters/latest3.jpg"/> <br/>
                        <a href="">Golden Exits (2018)</a> <br/>
                        <div className="rating" data-rating="69"> <br/> 69% </div>	
                    </div>
                    
                    <div className="movieshow">
                        <img src="images/posters/latest4.jpg"/> <br/>
                        <a href="">Entanglement (2018)</a> <br/>
                        <div className="rating" data-rating="39"> <br/> 39% </div>	
                    </div>
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
                    <div className="movieshow">
                        <img src="images/posters/new1.jpeg"/> <br/>
                        <a href="">Kevin (Probably) Saves the World</a><br/>
                        <div className="rating" data-rating="63"> <br/> 63% </div>	
                    </div>
                    
                    <div className="movieshow">
                        <img src="images/posters/new2.jpg"/> <br/>
                        <a href="">The Frankenstein Chronicles</a><br/>
                        <div className="rating" data-rating="71"> <br/> 71% </div>	
                    </div>
                    
                    <div className="movieshow">
                        <img src="images/posters/new3.jpg"/> <br/>
                        <a href="">Another Period</a> <br/>
                        <div className="rating" data-rating="43"> <br/> 43% </div>	
                    </div>
                    
                    <div className="movieshow">
                        <img src="images/posters/new4.jpg"/> <br/>
                        <a href="">Baskets</a> <br/>
                        <div className="rating" data-rating="66"> <br/> 66% </div>	
                    </div>
                </div>
            </div>
        </div>
        );
    }
}
