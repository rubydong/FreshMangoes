import * as React from "react";
import { MEDIA_LIMIT } from "../../GlobalVariables";

export class PhotoComponent extends React.Component {
    render() {
        const photos = this.props['data-photos'].slice(0, MEDIA_LIMIT).map((photo, i) => {
            return (photo.type == "PHOTO" ? <img src={photo.path} key={i}/> : '')
        });

        return (
            <div className="photos padding-top margin-top-bottom">
                <h2> Photos </h2> <p/> <hr/>
                <div className="photos-inner"> {photos} </div>
            </div>
        );
    }
}