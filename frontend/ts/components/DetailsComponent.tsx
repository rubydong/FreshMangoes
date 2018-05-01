import * as React from "react";
import axios from "axios";
import { parseDate, getUrlID}  from "../../HelperFunctions";
import { UserType } from '../types/user';
import { ContentType } from '../types/content';
import { Mangoes } from "./Mangoes";
import { TRASH_ICON, EDIT_ICON, GENRES_MAP } from "../../GlobalVariables";

export class DetailsComponent extends React.Component {
    
    addToInterested = event => {
        axios.post(window.location.origin + '/api/interested/add/' + getUrlID())
            .then(res => {
                console.log(res);
                window.location.reload();
        })
    }
    addToDisinterested = event => {
        axios.post(window.location.origin + '/api/disinterested/add/' + getUrlID())
            .then(res => {
                console.log(res);
                window.location.reload();
        })
    }

    removeFromInterested() {
        axios.post(window.location.origin + '/api/interested/remove/' + getUrlID())
            .then(res => {
                window.location.reload();
        });
    }

    removeFromDisinterested() {
        axios.post(window.location.origin + '/api/disinterested/remove/' + getUrlID())
            .then(res => {
                window.location.reload();
        });
    }

    deleteContent() {
        axios.delete(window.location.origin + '/api/admin/delete/' + this.props['data-state'].type.toString() + '/' + this.props['data-state'].id)
            .then(res => {
                console.log(res);
                window.location.assign(window.location.origin);
            })
    }
    
    render() {
        const state = this.props['data-state'];
        const metadata = state.metadata;
        const crew = state.crew;
        const type = state.type;
        const genres = metadata.genres.map((genre, i) => {
            return <span key={i}> {GENRES_MAP[genre]}{i < metadata.genres.length - 1 ? ', ' : ''}</span>
        });
        const currentUser = state.currentUser;

        let directors = [];
        let writers = [];
        let producers = [];

        const crewmen = crew.map((c, i) => {
            if (c.job == 'Director') directors.push(c.celebrity.name);
            else if (c.job == 'Screenplay') writers.push(c.celebrity.name);
            else if (c.job == 'Executive Producer') producers.push(c.celebrity.name);
        })

        const directorsFinal = directors.map((d, i) => {
            return <span> {d}{i < directors.length - 1 ? ', ' : ''}</span>
        });

        const writersFinal = writers.map((w, i) => {
            return <span> {w}{i < writers.length - 1 ? ', ' : ''}</span>
        });

        const producersFinal = producers.map((p, i) => {
            return <span> {p}{i < producers.length - 1 ? ', ' : ''}</span>
        });
    
        return (
            
            <div className="content-info">
                
                {currentUser && currentUser.userType == UserType.ADMIN 
                ? <span className="rating">
                    <b>Edit Information:</b>  <img src={EDIT_ICON} data-toggle="modal" data-target="#edit-info-modal"/> <br/>
                    <b>Delete Page:</b>
                        <img src={TRASH_ICON} onClick={() => { if (window.confirm("Are you sure you want to delete this content?")) this.deleteContent() }}/><br/>
                  </span>
                : ''}

                {type == 'MOVIE'
                ? <div> 
                    {metadata.maturityRating ? <div> <b>Rating:</b> {metadata.maturityRating} </div> : ''} 
                    {metadata.runtime ? <div> <b>Runtime:</b> {metadata.runtime} minutes </div> : ''}
                    {metadata.studio ? <div> <b>Studio:</b> {metadata.studio} </div> : ''}
                    {metadata.releaseDate ? <div> <b>In Theaters:</b> {parseDate(metadata.releaseDate)} </div> : ''} 
                  </div>
                : <div>
                    {metadata.network ? <div><b>Network:</b> {metadata.network}</div> : ''}
                    {metadata.releaseDate ? <div> <b>Premiere Date:</b> {parseDate(metadata.releaseDate)} </div> : ''}
                  </div>
                }
                
                {genres.length != 0 ? <div><b>Genres:</b> {genres}</div> : ''} 
                {directors.length != 0 ? <div> <b>Directed By:</b> {directorsFinal} </div> : ''}
                {writers.length != 0 ? <div> <b>Written By:</b> {writersFinal} </div> : ''}
                {producers.length != 0 ? <div> <b>Produced By:</b> {producersFinal} </div> : ''} 
                
                {type == ContentType.MOVIE || type == ContentType.SHOW 
                ? <div><p/>
                    <button className={currentUser && currentUser.interest == true 
                                        ? "btn-light small-margin-right" 
                                        : "btn small-margin-right"} 
                            onClick={currentUser && currentUser.interest == true ? this.removeFromInterested : this.addToInterested}> Interested </button>
                    <button className={currentUser && currentUser.interest == false 
                                        ? "btn-light small-margin-right" 
                                        : "btn small-margin-right"} 
                            onClick={currentUser && currentUser.interest == false ? this.removeFromDisinterested : this.addToDisinterested}> Uninterested </button> 
                  </div>
                : ''
                }
            </div>
        );
    }
}