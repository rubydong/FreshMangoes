import * as React from "react";
import {parseMedia} from "../../HelperFunctions.js";
import {CONTENT_LIMIT} from "../../GlobalVariables";
import axios from "axios";

export class InterestsListComponent extends React.Component {
    removeFromInterested(id) {
        axios.post(window.location.origin + '/api/interested/remove/' + id)
            .then(res => {
                window.location.reload();
        });
    }

    removeFromDisinterested(id) {
        axios.post(window.location.origin + '/api/disinterested/remove/' + id)
            .then(res => {
                window.location.reload();
        });
    }

    render() {
        const listType = this.props['data-title'];
        const sameUser = ("/profile/" + this.props['data-current-user']) == window.location.pathname;
        const x = sameUser ? <div className="x">X</div> : '';
        const contentList = this.props['data-content'].slice(0, CONTENT_LIMIT).map((content, i) => {
            return <div className="search-item">
                <img src={parseMedia(content.summaryPhoto)}/> 
                    <span onClick={ () => listType == "Interested" 
                        ? this.removeFromInterested(content.id) 
                        : this.removeFromDisinterested(content.id) }>{x}</span>
                <div className="text">
                    <a href={"/" + content.type.toLowerCase() + "/" + content.id}>{content.metadata.name}</a>
                </div>
            </div>
        });

        return (
            <div>
                <div>
                    <h2 className="padding-top"> {this.props['data-title']} </h2>
                    <div className="interests box-shadow">
                        <div className="flex-center"> {contentList} </div>
                        {contentList.length == 0 
                            ? <div className="center-text"> You have not added anything to your list yet! </div>
                            : <span className="align-right"> <a href="">View All</a> </span>
                        }
                    </div>
                </div>
            
            </div>
        );
    }
}