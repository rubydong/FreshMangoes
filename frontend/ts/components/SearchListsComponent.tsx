import * as React from "react";
import { parseMedia}  from "../../helperFunctions.js";

export class SearchListsComponent extends React.Component {

    render() {
        const sameUser = ("/profile/" + this.props['data-current-user']) == window.location.pathname;
        const x = sameUser ? <div className="x">X</div> : '';
        const isCelebrity = this.props['data-title'] == 'Celebrities';
        const contentList = this.props['data-content'].map((content, i) => {
            let newUrl = !isCelebrity  ? parseMedia(content.summaryPhoto) : parseMedia(content.profilePhoto);
            return <div className="search-item">
                    <img src={newUrl}/> {x}
                    <div className="text">{isCelebrity ? content.name : content.metadata.name}</div>
                </div>
        });
        


        return (
            <div>
                <h2 className="padding-top"> {this.props['data-title']} </h2>
                <div className="interests box-shadow">
                    <div className="flex-center"> {contentList} </div>
                    <span className="align-right"><a href="">View All</a></span>
                </div>
            </div>
        );
    }
}