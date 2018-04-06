import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";
import { parseMedia }  from "../../helperFunctions.js";

export class SearchTemplate extends React.Component {
    state = {
        celebrities: [],
        movies: [],
        shows: [],
        results: 0
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get('http://localhost:8080/search?query=h')
        .then(function (response) {
            currentComponent.setState({ 
                celebrities: response.data.celebrities,
                movies: response.data.movies,
                shows: response.data.shows,
                results: response.data.celebrities.length + response.data.shows.length + response.data.movies.length
             });
            console.log(response.data);
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {

        const movies = this.state.movies.map((movie) => {
            const newUrl = parseMedia(movie.summaryPhoto);
            return <div className="search-item" key={movie.id}>
                <img src={newUrl}/>
                <div className="text">{movie.metadata.name}</div>
            </div>
        });

        const shows = this.state.shows.map((show) => {
            const newUrl = parseMedia(show.summaryPhoto);
            return <div className="search-item" key={show.id}>
                <img src={newUrl}/>
                <div className="text">{show.metadata.name}</div>
            </div>
        });

        const celebrities = this.state.celebrities.map((celebrity) => {
            const newUrl = parseMedia(celebrity.profilePhoto);  
            return <div className="search-item" key={celebrity.id}>
                <img src={newUrl}/>
                <div className="text">{celebrity.name}</div>
            </div>
        });

        //RESULTS AND QUERY FOR BELOW

        return (
        <div className="search">
            <hr className="header-hr"/>
            <div className="content">
                <div className="search-criteria">
                        <h4>Search Criteria</h4> <hr/>
                        <em>**Used for movies and tv shows only**</em> <p/><p/>
                        Genres
                        <ul>
                            <li><input type="checkbox"/> Romance</li> 
                            <li><input type="checkbox"/> Mystery</li>
                            <li><input type="checkbox"/> Comedy</li>
                            <li><input type="checkbox"/> Horror</li>
                            <li><input type="checkbox"/> Science Fiction & Fantasy</li>
                            <li><input type="checkbox"/> Action & Adventure</li>
                            <li><input type="checkbox"/> Drama</li>

                        </ul>

                        Years
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <span className="input-group-text" id="inputGroup-sizing-default">Start</span>
                            </div>
                            <input type="text" className="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"/>
                        </div>


                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <span className="input-group-text" id="inputGroup-sizing-default">End</span>
                            </div>
                            <input type="text" className="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"/>
                        </div>

                        Ratings
                        <ul>
                            <li>
                                <input className="small-margin-right" type="radio"/> 
                                <Mangoes data-rating="100"/>
                            </li> 
                            <li>
                            <input className="small-margin-right" type="radio"/> 
                                <Mangoes data-rating="80"/> & up
                            </li> 
                            <li>
                                <input className="small-margin-right" type="radio"/> 
                                <Mangoes data-rating="60"/> & up
                            </li> 
                            <li>
                                <input className="small-margin-right" type="radio"/> 
                                <Mangoes data-rating="40"/> & up
                            </li> 
                            <li>
                                <input className="small-margin-right" type="radio"/> 
                                <Mangoes data-rating="20"/> & up
                            </li> 
                        </ul>
                        <p/>
                        <div className="criterias-div">
                            <button className="btn" type="submit">Apply Criterias</button>
                        </div>
                    </div>

                <div className="search-results">
                    <h4> {this.state.results} Results found for "Black"</h4> <hr/>
                    <ul className="list-inline">
                        <li className="underline"><a href="">All</a></li>
                        <li><a href="">Movies</a></li>		
                        <li><a href="">TV Shows</a></li>		
                        <li><a href="">Celebrities</a></li>
                    </ul>

                    <h5 className="search-movies">Movies <span className="align-right"><a href="">View All</a></span></h5> 
                    <div className="search-movies search-content flex-center"> {movies} </div>

                    <h5 className="search-shows padding-top"> TV Shows <span className="align-right"><a href="">View All</a></span></h5>
                    <div className="search-shows search-content flex-center"> {shows} </div>

                    <h5 className="search-celebrities padding-top">Celebrities <span className="align-right"><a href="">View All</a></span></h5>
                    <div className="search-celebrities search-content flex-center"> {celebrities} </div>
                </div>			
            </div>
        </div>
        );
    }
}