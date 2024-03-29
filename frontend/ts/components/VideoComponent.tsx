import * as React from "react";
import {parseMedia} from "../../HelperFunctions.js";
import { VIDEO_LIMIT } from "../../GlobalVariables";

export class VideoComponent extends React.Component {
    render() {
        const videosOnly = this.props['data-videos'].filter(video => video.type == 'VIDEO');
        const videos = videosOnly.slice(0, VIDEO_LIMIT).map((video, i) => {
            return <iframe className="box-shadow" src={video.path} key={i}> </iframe>
        });

        
        return (videos == null || videos.length == 0) 
            ? ''
            : <div className="white-component margin-top-bottom">
                <h2> Videos </h2>
                <hr/>
                <div className="videos"> {videos} </div>
              </div>
        ;
    }
}