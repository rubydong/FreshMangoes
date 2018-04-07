import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";
import { parseMedia }  from "../../helperFunctions.js";

export class ProfileTemplate extends React.Component {
    render() {

        return (
            <div className="profile">
                <hr className="header-hr"/>
                <div className="content">
                    
                    <div className="left">
                        <h2>Ruby Dong</h2>
                        <div className="bio box-shadow">
                            <img src="../images/usericon.png"/> <br/>

                            <b>Followers:</b> <a href="">34</a> <br/>
                            <b>Following:</b> <a href="">56</a> 
                            <p/>
                            {/* <button className="btn">Follow</button>  */}
                        </div>
                        
                    </div>
        
                    <div className="right">
                    
                    <h2> Reviews </h2>
                    <div className="profile-reviews list-group">
                        
                        <div className="review">
                            <b><a href="">Ruby Dong</a></b> 
                            <span className="align-right"><Mangoes data-rating="80"/></span> <br/>
                            <i>Black Panther</i>
        
                            <hr/>
                            "Jordan has swagger to spare, with those rolling shoulders, but there's a breath of charm, too, all the more seductive in the overblown atmosphere of Marvel. He's twice as pantherish as the Panther."
                        </div>
                        <div className="review">
                            <b><a href="">Ruby Dong</a></b> 
                            <span className="align-right"><Mangoes data-rating="40"/></span>  <br/>
                            <i>Peter Rabbit</i>
                            <hr/>
                            "The movie remains an object lesson in how not to adapt a beloved volume to the screen."
                        </div>
                    </div>
                    
                    <h2 className="padding-top"> Interested </h2>
                    <div className="interests box-shadow">
                        <div className="flex-center">
                            <div className="search-item">
                                <img src="../images/posters/greatestshowman.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">The Greatest Showman (2017)</div>
                            </div>
        
                            <div className="search-item">
                                <img src="../images/posters/shapeofwater.jpg"/>
                                <div className="x">X</div>
                                <div className="text">Shape of Water (2017)</div>
                            </div>
        
                            <div className="search-item">
                                <img src="../images/posters/redsparrow.jpg"/>
                                <div className="x">X</div>
                                <div className="text">Red Sparrow (2018)</div>
                            </div>
        
                            <div className="search-item">
                                <img src="../images/posters/pitchperfect3.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Pitch Perfect 3 (2017)</div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/coco.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Coco (2017)</div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/it.jpg"/>
                                <div className="x">X</div>
                                <div className="text">It (2017)</div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/avengers.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Avengers: Infinity War (2018)</div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/wrinkleintime.jpg"/>
                                <div className="x">X</div>
                                <div className="text">A Wrinkle in Time (2018)</div>
                            </div>
                        </div>
                        <span className="align-right"><a href="">View All</a></span>
                    </div>
                        
                    <h2 className="padding-top"> Not Interested </h2>
                    <div className="interests box-shadow">
                        <div className="flex-center">
                            <div className="search-item">
                                <img src="../images/posters/latest1.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Peter Rabbit (2018)</div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/latest2.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">The 15:17 To Paris (2018) </div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/latest3.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Golden Exits (2018) </div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/latest4.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Entanglement (2018) </div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/new1.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Kevin (Probably) Saves the World</div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/new2.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">The Frankenstein Chronicles</div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/new3.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Another Period </div>
                            </div>
                            
                            <div className="search-item">
                                <img src="../images/posters/new4.jpeg"/>
                                <div className="x">X</div>
                                <div className="text">Baskets</div>
                            </div>
                        </div>
                        
                        <span className="align-right"><a href="">View All</a></span>
                    </div>
                    </div>
                </div>
            </div>
        );
    }
}