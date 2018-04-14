import * as React from "react";
import { parseProfileMedia}  from "../../helperFunctions.js";

export class ContentListsComponent extends React.Component {

    render() {
        const sameUser = ("/profile/" + this.props['data-current-user']) == window.location.pathname;
        const x = sameUser ? <div className="x">X</div> : '';
        const list = this.props['data-content'].map((content, i) => {
            let newUrl = parseProfileMedia(content.summaryPhoto);
            return <div className="search-item">
                    <img src={newUrl}/>
                    {x}
                    <div className="text">{content.metadata.name}</div>
                </div>
        });

        return (
            <div>
                <h2 className="padding-top"> {this.props['data-title']} </h2>
                <div className="box-shadow">
                    <div className="flex-center"> {list} </div>
                    <span className="align-right"><a href="">View All</a></span>
                </div>
            </div>
        );
    }
}