import * as React from "react";
import { parseMedia }  from "../../helperFunctions.js";
import { MEDIA_CONTENT } from "../../GlobalVariables";

export class PhotoComponent extends React.Component {
    render() {
        const photos = this.props['data-photos'].slice(0, MEDIA_CONTENT).map((photo, i) => {
            let newUrl = this.props['data-actual-url'] == 'true' ? photo : parseMedia(photo);
            return <img src={newUrl} key={i}/>
        });

        return (
            <div className="photos padding-top margin-top-bottom">
                <h2> Photos </h2> <p/> <hr/>
                <div className="photos-inner"> {photos} </div>
            </div>
        );
    }
}