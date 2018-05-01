import * as React from "react";
import { MEDIA_LIMIT, EDIT_ICON } from "../../GlobalVariables";
import { isNullOrUndefined } from "util";
import { UserType } from '../types/user';
import { EditPageComponent } from "./EditPageComponent";

export class PhotoComponent extends React.Component {
    render() {
        const currentUser = this.props['data-current-user'];
        const photosOnly = this.props['data-photos'].filter(photo => photo.type == 'PHOTO');
        const photos = photosOnly.slice(0, MEDIA_LIMIT).map((photo, i) => {
            return <img src={photo.path} key={i}/>
        });

        return ( photos == isNullOrUndefined || photos.length == 0 ) 
            ? ''
            : <div className="photos white-component margin-top-bottom">
                <h2> 
                    Photos 
                    { currentUser && currentUser.userType == UserType.ADMIN 
                        ? <span className="icon"><img src={EDIT_ICON} data-toggle="modal" data-target="#edit-photos-modal"/></span>
                        : ''
                    }
                </h2> <p/> <hr/>
                <div className="photos-inner"> {photos} </div>
                <span className="align-right"><a href="" data-toggle="modal" data-target="#edit-photos-modal">View All Photos</a></span>
              </div>;
    }
}