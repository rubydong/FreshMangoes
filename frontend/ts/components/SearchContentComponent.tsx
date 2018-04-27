import * as React from "react";
import {parseMedia} from "../../HelperFunctions.js";
import {SEARCH_SELECTED_LIMIT } from "../../GlobalVariables";

export class SearchContentComponent extends React.Component {
    
    render() {
        const isCelebrity = this.props['data-title'] == 'Celebrities';
     
        const contentList = this.props['data-content'].slice(0, SEARCH_SELECTED_LIMIT ).map((content, i) => {
            let url = isCelebrity
                ? "/celebrity/" + content.id
                : "/" + content.type.toLowerCase() + "/" + content.id;
            let newUrl = !isCelebrity
                ? parseMedia(content.summaryPhoto)
                : parseMedia(content.profilePicture);
            return <div className="search-item">
                <img src={newUrl}/> 
                <div className="text">
                    <a href={url}>{isCelebrity ? content.name : content.metadata.name}</a>
                </div>
            </div>
        });

        return (
            <div>
                <div>
                    <h5 className="search-shows padding-top">
                        {this.props['data-title']}
                    </h5>
                    <div className="search-shows search-content flex-center">
                        {contentList}
                    </div>
                </div>
            </div>
        );
    }
}