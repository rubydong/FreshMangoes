import * as React from "react";
import { parseDate }  from "../../HelperFunctions.js";
import { Mangoes } from "./Mangoes";

export class DetailsComponent extends React.Component {
    render() {
        const metadata = this.props['data-metadata'];
        const crew = this.props['data-crew'];
        const type = this.props['data-type'];
    
        const genres = metadata.genres.map((genre, i) => {
            return <span> {genre}{i < metadata.genres.length - 1 ? ', ' : ''}</span>
        });

        let directors = [];
        let writers = [];

        const crewmen = crew.map((c, i) => {
            if (c.job == 'Director') directors.push(c.celebrity.name);
            else if (c.job == 'Screenplay') writers.push(c.celebrity.name);
        });

        const directorsFinal = directors.map((d, i) => {
            return <span> {d}{i < directors.length - 1 ? ', ' : ''}</span>
        });

        const writersFinal = writers.map((w, i) => {
            return <span> {w}{i < writers.length - 1 ? ', ' : ''}</span>
        });
    
        return (
            <div className="content-info">
                {type == 'MOVIE'
                ? <div> 
                    <b>Rating:</b> {metadata.maturityRating} <br/> 
                    <b>Runtime:</b> {metadata.runtime} minutes <br/>
                    <b>Studio:</b> {metadata.studio} <br/>
                    <b>In Theaters:</b> {parseDate(metadata.releaseDate)} 
                  </div>
                : <div>
                    <b>Network:</b> {metadata.network} <br/>
                    <b>Premiere Date:</b> {parseDate(metadata.releaseDate)} 
                  </div>
                }
                
                <b>Genres:</b>	{genres} <br/>
                <b>Directed By:</b> {directorsFinal} <br/>
                {writers.length != 0 ? <b>Written By:</b> : ''} {writersFinal} <p/>

                <button className="btn small-margin-right"> Interested</button>
                <button className="btn"> Uninterested</button>
            </div>
        );
    }
}