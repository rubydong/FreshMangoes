import * as React from "react";
import axios from "axios";
import { Page } from "../types/content";

export class EditPageComponent extends React.Component {
    state: Page;

    constructor(props) {
        super(props);
        this.state = new Page();
    }

    handleEditContentPage (id) {
        console.log(this.state);
        // axios.post(window.location.origin + '/edit/page/' + id, this.state)
        //     .then(res => {
        //     window.location.reload();
        // })
    }

    render() {
        
        const metadata = this.props['data-metadata'];
        return (
            <div id="edit-page-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <h2> Edit Page </h2>
                            <form onSubmit={()=>this.handleEditContentPage(metadata.id)}>
                                Title
                                <input type="text" className="form-control" value={metadata.name} onChange={(event) => this.state.name = event.target.value}/>
                    
                                Summary
                                <textarea className="form-control" value={metadata.summary} onChange={(event) => this.state.summary = event.target.value}/>
                    
                                Main Photo
                                <input className="form-control" type="file" onChange={(event) => this.state.summaryPhoto = event.target.files[0]}/>
                                
                                <button className="btn">Edit Page </button>
                            </form>
                        </div>
                    </div>
            </div>
        )
    }
}
