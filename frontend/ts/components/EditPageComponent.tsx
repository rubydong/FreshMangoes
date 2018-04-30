import * as React from "react";
import axios from "axios";
import { Page } from "../types/content";
import { NO_USER_PHOTO } from "../../GlobalVariables";
import { UserType } from '../types/user';

export class EditPageComponent extends React.Component {
    state: Page;

    constructor(props) {
        super(props);
        this.state = new Page();
    }

    handleEditInfo (id) {
        console.log(this.state);
        // axios.post(window.location.origin + '/edit/page/' + id, this.state)
        //     .then(res => {
        //     window.location.reload();
        // })
    }

    handleEditPhotos() {

    }

    render() {
        const state = this.props['data-state'];
        const currentUser = state.currentUser;
        const metadata = this.state.metadata;
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
                    
                                Main Photo 
                                <input className="form-control" type="file"/>
                                
                                <button className="btn"> Edit Information </button>
                            </form>
                        </div>
                    </div>    
                </div>

                <div id="edit-photos-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <form onSubmit={()=>this.handleEditPhotos()}>
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
                            <form onSubmit={()=>this.handleEditPhotos()}>
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
