import * as React from "react";
import { Mangoes } from "./mangoes";
const movie = require('../../json/movie.json');

export class MovieTemplate extends React.Component {
    render() {
        return (
        <div>
            <hr/>
            <div className="content">
                <div className="summary">
                    <img src="images/movie/blackpanther.jpg" className="img-align-left"/> 
                    <div className="summary-title">
                        <h2>Black Panther</h2>
                    </div>
                    
                    <div className="plot">
                        <b>MangoMeter Audience Score</b> <br/>
                        <Mangoes data-rating={movie.metadata.mangoScore}/> <br/>
                        {movie.metadata.mangoScore}%

                        <Mangoes data-rating={movie.metadata.audienceScore}/> <br/>
                        {movie.metadata.audienceScore}% <p/><p/>

                        <b>About Movie</b> <br/> 
                        {movie.metadata.summary} <p/> 
                    </div>

                    <div className="content-info">
                        <b>Rating:</b>	{movie.metadata.maturityRating}<br/>
                        <b>Genres:</b>	{movie.metadata.genres} <br/>
                        <b>Directed By:</b>	Ryan Coogler <br/>
                        <b>Written By:</b>	Joe Robert Cole, Ryan Coogler <br/>
                        <b>In Theaters:</b>	{movie.metadata.releaseDate} <br/>
                        <b>Runtime:</b>	{movie.metadata.runTime} minutes <br/>
                        <b>Studio:</b>	Marvel Studios <p/><p/>
                        <button className="btn"> Interested</button>
                        <button className="btn"> Uninterested</button>
                    </div>
                    
                        
                    
                </div>
                
                <div className="photos padding-top margin-top-bottom-">
                    <h2> Photos </h2> <p/>
                    <hr/>
                    <div className="photos-inner">
                        <img src="images/movie/bp1.jpg"/>
                        <img src="images/movie/bp2.jpg"/>
                        <img src="images/movie/bp3.jpg"/>
                        <img src="images/movie/bp4.jpg"/>
                    </div>
                </div>
                
                <div className="margin-top-bottom">
                    <h2> Trailers </h2> 
                    <hr/>
                    <div className="videos">
                        <video controls>
                            <source src="videos/bptrailer.mp4" type="video/mp4"/>
                        </video>
                        <video controls>
                            <source src="videos/bptrailer.mp4" type="video/mp4"/>
                        </video>
                        <video controls>
                            <source src="videos/bptrailer.mp4" type="video/mp4"/>
                        </video>
                    </div>
                    
                </div>
                
                <div className="ticketshowtime padding-top margin-top-bottom">
                    <h2> Tickets & Showtimes</h2>
                    <hr/>
                    Showtimes for <b><a href="">February 21, 2018</a></b> near Stony Brook  <br/>
                    <b><a href="">AMC LOEWS STONY BROOK 17</a></b> <br/>
                    2196 Nesconset Hwy <br/>
                    <a href="">Change Location</a>
                
                    <div className="padding"></div>
                    3D Showtimes 
                    <ul className="list-inline showtime"> 
                        <li> 11:00am </li>
                        <li> 2:15am </li>
                        <li> 5:20am </li>
                        <li> 8:30am </li>
                        <li> 9:15am </li>
                    </ul>
                    
                    Standard Showtimes
                    <ul className="list-inline showtime">
                        <li> 10:30am </li>
                        <li> 11:30am </li>
                        <li> 12:00pm </li>
                        <li> 1:30pm </li>
                        <li> 2:45pm </li>
                        <li> 3:15pm </li>
                        <li> 4:35pm </li>
                        <li> 6:00pm </li>
                        <li> 6:35pm </li>
                        <li> 7:45pm </li>
                        <li> 10:00pm </li>
                        <li> 10:20pm </li>
                    </ul>
                    
                    <div className="align-right"><a href=""> View All Theaters & Showtimes </a> </div>
                </div>
                
                <div className="casts margin-top-bottom"> 
                    <h2>Cast</h2>
                    <hr/>
                    <div className="flex-center">
                        <div className="cast-person">
                            <img src="images/movie/cast1.jpg" className="img-align-left"/>
                            <b><a href="">Chadwick Boseman</a></b>  <br/> <i>T'Challa/Black Panther</i>
                        </div>

                        <div className="cast-person">
                            <img src="images/movie/cast2.jpg" className="img-align-left"/>
                            <b><a href="">Michael B. Jordan</a></b>  <br/> <i>Erik Killmonger</i>
                        </div>

                        <div className="cast-person">
                            <img src="images/movie/cast3.jpg" className="img-align-left"/>
                            <b><a href="">Lupita Nyong'o</a></b>  <br/> <i> Nakia</i>
                        </div>

                        <div className="cast-person">
                            <img src="images/movie/cast4.jpg" className="img-align-left"/>
                            <b><a href="">Danai Gurira</a></b>  <br/><i>Okoye</i>
                        </div>

                        <div className="cast-person">
                            <img src="images/movie/cast5.jpg" className="img-align-left"/>
                            <b><a href="">Martin Freeman</a></b>  <br/> <i>Everett K. Ross</i>
                        </div>

                        <div className="cast-person">
                            <img src="images/movie/cast6.jpg" className="img-align-left"/>
                            <b><a href="">Daniel Kaluuya</a></b>  <br/> <i>W'Kabi</i>
                        </div>
                    </div>
                    <p/>
                    <div className="align-right"><a href="">View All Cast</a></div>
                </div>
                <div className="padding"></div>
                <div className="reviews margin-top-bottom">
                    <h2> Reviews </h2>
                    <hr/>
                
                <div className="review pull-right">
                    <b><a href="">Matthew Rozsa</a></b> 
                    <span className="align-right"> <Mangoes data-rating={movie.metadata.mangoScore}/></span> <br/>
                    <i> Black Panther </i>
                    <hr/>
                    "When it comes to creative visuals, engaging action and likable characters, "Black Panther" stands confidently next to the best fare offered up by the Marvel Cinematic Universe."
                </div>
                <div className="review pull-left">
                    <b><a href="">Christopher Orr</a></b> 
                    <span className="align-right"> <Mangoes data-rating={movie.metadata.mangoScore}/></span> <br/>
                    <i>Black Panther</i>
                    
                    <hr/>
                    "Whether or not this is the best film Marvel Studios has made to date-and it is clearly in the discussion-it is by far the most thought-provoking."
                </div>
                <div className="review pull-right">
                    <b><a href="">J. R. Jones</a></b> 
                    <span className="align-right"> <Mangoes data-rating={movie.metadata.mangoScore}/></span> <br/>
                    <i>Black Panther</i>
                    
                    <hr/>
                    "The identity politics provide a fresh spin to the genre's increasingly tedious narrative formula."
                </div>
                <div className="review pull-left">
                    <b><a href="">Anthony Lane</a></b> 
                    <span className="align-right"> <Mangoes data-rating={movie.metadata.mangoScore}/></span> <br/>
                    <i>Black Panther</i>
                    
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
                                <select className="form-control">
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