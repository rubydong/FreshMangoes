import * as React from "react";
import { MEDIA_LIMIT } from "../../GlobalVariables";
import { isNullOrUndefined } from "util";

export class PhotoComponent extends React.Component {
    render() {
        const photosOnly = this.props['data-photos'].filter(photo => photo.type == 'PHOTO');
        const photos = photosOnly.slice(0, MEDIA_LIMIT).map((photo, i) => {
            return <img src={photo.path} key={i}/>
        });

        return ( photos == isNullOrUndefined || photos.length == 0 ) 
            ? ''
            : <div className="photos margin-top-bottom">
                <h2> Photos </h2> <p/> <hr/>
                <div className="photos-inner"> {photos} </div>
              </div>;
    }
}