import * as React from "react";
import {parseMedia} from "../../helperFunctions.js";
import {MEDIA_CONTENT} from "../../GlobalVariables";

export class VideoComponent extends React.Component {
    render() {
        const videos = this.props['data-videos'].slice(0, MEDIA_CONTENT).map((video, i) => {
                let newUrl = parseMedia(video);
                return <video controls>
                            <source src={newUrl} type="video/mp4" key={i}/>
                       </video>
            });

        return (
            <div className="margin-top-bottom">
                <h2> Videos </h2>
                <hr/>
                <div className="videos"> {videos} </div>
            </div>
        );
    }
}