import * as React from "react";
import axios from "axios";
import { Page } from "../types/content";

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
        const metadata = this.state.metadata;
        const photosOnly = state.media.filter(photo => photo.type == 'PHOTO');
        const photos = (photosOnly||[]).map((photo, i) => {
            return <img src={photo.path} key={i}/>
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
                                <h2>Edit Photos</h2>
                                <div className="all-photos"> {photos} </div>
                                <button className="btn"> Update Photos </button>
                            </form>
                        </div>
                    </div>    
                </div>


                
            </div>
        )
    }
}
