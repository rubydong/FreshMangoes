import * as React from "react";
import axios from "axios";
import { Content } from "../types/content";
import { NO_USER_PHOTO, MOVIE_GENRES, TV_GENRES, GENRES_MAP, GENRES_VALUES_MAP } from "../../GlobalVariables";
import { parseMedia } from "../../HelperFunctions";
import { UserType } from '../types/user';
import { ContentType } from '../types/content';

export class EditPageComponent extends React.Component {
    state: Content;

    constructor(props) {
        super(props);
        this.state = this.props['data-state'];
    }

    handleEditInfo (id) {
        console.log(this.state);
        // axios.post(window.location.origin + '/edit/page/' + id, this.state)
        //     .then(res => {
        //     window.location.reload();
        // })
    }

    handleUpdatePhotos() {}
    handleUpdateCast() {}

    handleChangeGenre = event => {
        if (event.target.checked) {
            console.log("i'm pushing...... " + event.target.value);
            this.state.metadata.genres.push(GENRES_VALUES_MAP[event.target.value]);
        } else {
            console.log("i'm deleting...... " + event.target.value);
            let i = this.state.metadata.genres.indexOf(GENRES_VALUES_MAP[event.target.value]);
            this.state.metadata.genres.splice(i, 1);
        }
        console.log(this.state.metadata.genres);
        this.forceUpdate();
    }

    render() {
        const state = this.props['data-state'];
        const currentUser = state.currentUser;
        const metadata = this.state.metadata;
        const genres = (this.state.type == ContentType.MOVIE ? MOVIE_GENRES : TV_GENRES).map((genre, i) => {
            return <div className="form-check form-check-inline" key={i}>
                <input className="form-check-input" type="checkbox" value={genre} checked={this.state.metadata.genres.indexOf(GENRES_VALUES_MAP[genre]) != -1}
                       onChange={this.handleChangeGenre}/>
                <label className="form-check-label">{genre}</label>
            </div>
        });

        const photos = state.media.filter(photo => photo.type == 'PHOTO').map((photo, i) => {
            return <img src={photo.path} key={i}/>
        });
        
        const cast = state.cast.map((castPerson, i) => {
            return <div className="cast-person" key={i}>
                <img className="img-align-left" src={castPerson.celebrity.profilePicture ? castPerson.celebrity.profilePicture.path : NO_USER_PHOTO}/>
                <b> <a href={"/../celebrity/" + castPerson.celebrity.id}>{castPerson.celebrity.name}</a> </b> <br/>
                <i>{castPerson.role}</i>
            </div>
        });


        return (
            <div>
                <div id="edit-info-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <form onSubmit={()=>this.handleEditInfo(state.id)}>
                                <h2> Edit Information </h2>
                                Title
                                <input type="text" className="form-control" value={state.metadata.name} onChange={(event) => this.state.metadata.name = event.target.value}/>
                    
                                Summary
                                <textarea className="form-control" value={state.metadata.summary} onChange={(event) => this.state.metadata.summary = event.target.value}/>
                    
                                Main Photo <br/>
                                <span className="form-control">
                                    <img className="summary-photo" src={parseMedia(this.state.summaryPhoto)}/>
                                    <input type="file"/>
                                </span>
                                Genres  
                                <div className="form-control"> {genres} </div>
                                <p/>
                                <button className="btn"> Edit Information </button>
                            </form>
                        </div>
                    </div>    
                </div>

                <div id="edit-photos-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <form onSubmit={()=>this.handleUpdatePhotos()}>
                                <h2>Photos</h2>
                                <div className="all-photos"> {photos} </div>
                                { currentUser && currentUser.userType == UserType.ADMIN ? <button className="btn"> Update Photos </button> : '' }
                            </form>
                        </div>
                    </div>    
                </div>

                <div id="edit-cast-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content casts">
                            <form onSubmit={()=>this.handleUpdateCast()}>
                                <h2>Cast</h2>
                                <div className="flex-center"> {cast} </div>
                                { currentUser && currentUser.userType == UserType.ADMIN ? <button className="btn"> Update Cast </button> : '' }
                            </form>
                        </div>
                    </div>    
                </div>
            </div>
        )
    }
}
