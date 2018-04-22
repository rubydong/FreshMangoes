import * as React from "react";
import { Mangoes } from "../components/Mangoes";
import { parseMedia }  from "../../helperFunctions.js";
import { INDEX_LIMIT } from "../../GlobalVariables";

export class IndexComponent extends React.Component {
    state = {
        selectedMovies: [],
        selectedShows: []
    }

    setSelectedMovieContent(content) {
        this.state.selectedMovies = content;
        this.forceUpdate()
    }

    setSelectedShowContent(content) {
        this.state.selectedShows = content;
        this.forceUpdate()
    }

    render() {
        const selectedMovies = (this.state.selectedMovies.length != 0 ? this.state.selectedMovies : this.props['data-spotlight'].openingMovies).slice(0,INDEX_LIMIT).map((content) => {
            const newUrl = parseMedia(content.summaryPhoto);
            return <div className="movieshow" key={content.id}>
                <img src={newUrl}/> <br/>
                <a href={"/movie/" + content.id}> {content.metadata.name}</a> <br/>
                <Mangoes data-rating={content.metadata.mangoScore}/> <br/>
                {content.metadata.mangoScore}%
            </div>     
        }); 

        const selectedShows = (this.state.selectedShows.length != 0 ? this.state.selectedShows : this.props['data-spotlight'].newShows).slice(0,INDEX_LIMIT).map((content) => {
            const newUrl = parseMedia(content.summaryPhoto);
            return <div className="movieshow" key={content.id}>
                <img src={newUrl}/> <br/>
                <a href={"/show/" + content.id}> {content.metadata.name}</a> <br/>
                <Mangoes data-rating={content.metadata.mangoScore}/> <br/>
                {content.metadata.mangoScore}%
            </div>     
        }); 

        return (
            <div className="content">
                <div className="margin-top-bottom spotlight">
                    <h2> Movies Spotlight </h2>	<hr/>
                    <ul className="list-inline align-center spotlight-nav">
                        <li><button className="btn-link" onClick={() => this.setSelectedMovieContent(this.props['data-spotlight'].openingMovies)}>Opening This Week</button></li>
                        <li><button className="btn-link" onClick={() => this.setSelectedMovieContent(this.props['data-spotlight'].topBoxOfficeMovies)}>Top Box Office</button></li>		
                        <li><button className="btn-link" onClick={() => this.setSelectedMovieContent(this.props['data-spotlight'].comingSoonMovies)}>Coming Soon</button></li> 
                        <li><a href="/spotlight">View All</a></li>
                    </ul>
                
                    <div className="spotlight-posters">
                        {selectedMovies}
                    </div>
                </div>

                <div className="margin-top-bottom spotlight">
                    <h2> Shows Spotlight </h2>	<hr/>
                    <ul className="list-inline align-center spotlight-nav">
                        <button className="btn-link" onClick={() => this.setSelectedShowContent(this.props['data-spotlight'].newShows)}>New Shows</button>
                        <li><button className="btn-link" onClick={() => this.setSelectedShowContent(this.props['data-spotlight'].mostPopularShows)}>Most Popular</button></li>		
                        <li><button className="btn-link" onClick={() => this.setSelectedShowContent(this.props['data-spotlight'].topDVDStreamingShows)}>Top DVD & Streamings</button></li> 
                        <li><a href="/spotlight">View All</a></li>
                    </ul>

                    <div className="spotlight-posters">
                        {selectedShows}
                    </div>
                </div>
            </div>
        );
    }
}