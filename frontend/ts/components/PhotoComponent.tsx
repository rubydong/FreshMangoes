import * as React from "react";
import Lightbox from "react-images";
import { MEDIA_LIMIT, EDIT_ICON } from "../../GlobalVariables";
import { parseMedia } from "../../HelperFunctions"
import { isNullOrUndefined } from "util";
import { UserType } from '../types/user';
import { EditPageComponent } from "./EditPageComponent";

export class PhotoComponent extends React.Component {
    state: any;

    componentWillMount() {
        this.setState({
          isOpen: false,
          currentImage: 0
        });
    }

    constructor(props) {
        super(props);
        this.handleThumbnail = this.handleThumbnail.bind(this);
        this.handlePrev = this.handlePrev.bind(this);
        this.handleNext = this.handleNext.bind(this);
        this.handleClose = this.handleClose.bind(this);
    }

    handleThumbnail(event) {
        this.setState({
            isOpen: true,
            currentImage: Number(event.target.id)
        });
    }

    handlePrev(event) {
        this.setState({
            isOpen: true,
            currentImage: this.state.currentImage - 1
        });
    }

    handleNext(event) {
        this.setState({
            isOpen: true,
            currentImage: this.state.currentImage + 1
        });
    }

    handleClose(event) {
        this.setState({
            isOpen: false,
            currentImage: 0
        });
    }

    render() {
        const currentUser = this.props['data-current-user'];
        const photosOnly = this.props['data-photos'].filter(photo => photo.type == 'PHOTO');
        const photos = photosOnly.slice(0, MEDIA_LIMIT).map((photo, i) => {
            return <img src={parseMedia(photo)} id={i} onClick={this.handleThumbnail}/>
        });
        const albumPhotos = photosOnly.map((photo, i) => { return { src: parseMedia(photo) }; });

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
                <div className="photos-album"> <Lightbox images={albumPhotos}
                                                         enableKeyboardInput={true}
                                                         isOpen={this.state.isOpen}
                                                         currentImage={this.state.currentImage}
                                                         onClickPrev={this.handlePrev}
                                                         onClickNext={this.handleNext}
                                                         onClose={this.handleClose}
                                               />
                </div>
                <span className="align-right"><a href="" data-toggle="modal" data-target="#edit-photos-modal">View All Photos</a></span>
              </div>;
    }
}
