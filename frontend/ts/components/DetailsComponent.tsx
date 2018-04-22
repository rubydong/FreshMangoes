import * as React from "react";
import { parseDate }  from "../../HelperFunctions";
import { Mangoes } from "./Mangoes";
import { GENRES_MAP } from "../../GlobalVariables";
import axios from "axios";

export class DetailsComponent extends React.Component {
    addToInterested = event => {
        axios.post(window.location.origin + '/api/interested/add/' + this.props['data-id'])
            .then(res => {
                console.log(res);
        })
    }
    addToDisinterested = event => {
        axios.post(window.location.origin + '/api/disinterested/add/' + this.props['data-id'])
            .then(res => {
                console.log(res);
        })
    }
    
    render() {
        const metadata = this.props['data-metadata'];
        const crew = this.props['data-crew'];
        const type = this.props['data-type'];
    
        const genres = metadata.genres.map((genre, i) => {
            return <span> {GENRES_MAP[genre]}{i < metadata.genres.length - 1 ? ', ' : ''}</span>
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

                <button className="btn small-margin-right" onClick={this.addToInterested}> Interested</button>
                <button className="btn" onClick={this.addToDisinterested}> Uninterested</button>
            </div>
        );
    }
}