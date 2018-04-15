import * as React from "react";
import { Mangoes } from "../components/Mangoes";
import { parseMedia }  from "../../helperFunctions.js";

export class SpotlightDetailComponent extends React.Component {
    render() {

        const spotlightContent = this.props['data-content'].map((content) => {
            const newUrl = parseMedia(content.summaryPhoto);
            return <div className="movieshow" key={content.id}>
                <img src={newUrl}/> <br/>
                <a href={"/" + (content.type != null ? content.type.toLowerCase() : 'movie') + "/" + content.id}> {content.metadata.name}</a> <br/>
                <Mangoes data-rating={content.metadata.mangoScore}/> <br/>
                {content.metadata.mangoScore}%
            </div>     
        }); 

        return (<div className="spotlight-content">
        <h2>{this.props['data-title']}</h2>
        <div className="spotlight-page-posters">
            {spotlightContent}{spotlightContent}{spotlightContent}{spotlightContent}
        </div>
        
        <span className="align-right"><a href="">Next Page</a></span>
    </div>);
    }
}