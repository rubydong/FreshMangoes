import * as React from "react";
import axios from "axios";
import { EditPage } from "../types/content";
import { NO_USER_PHOTO, MOVIE_GENRES, TV_GENRES, GENRES_MAP, GENRES_VALUES_MAP, FILE_STORAGE_BASE_DIR, TRASH_ICON } from "../../GlobalVariables";
import { parseMedia } from "../../HelperFunctions";
import { UserType } from '../types/user';
import { ContentType } from '../types/content';
import { Celebrity, CreateCast } from '../types/celebrity';
import {Media, MediaType} from "../types/media";

export class EditPageComponent extends React.Component {
    state: EditPage;

    constructor(props) {
        super(props);
        this.state = this.props['data-state'];
        this.state.tempSummaryPhoto = null;
        this.state.tempCast =[];
        this.state.castNum = 0;
    }

    handleEditInfo (id) {
        let summaryPhoto = "";
        if (this.state.tempSummaryPhoto != null) {
            let formData = new FormData();
            formData.append("myImage", this.state.tempSummaryPhoto);
            axios.post(window.location.origin + "/api/admin/upload", formData)
                .then(res => {
                    console.log("Completed Request " + res);
                })
            summaryPhoto = FILE_STORAGE_BASE_DIR + this.state.tempSummaryPhoto.name;
        }

        const requestBody = {
            type: this.state.type,
            summaryPhoto: summaryPhoto,
            name: this.state.metadata.name,
            summary: this.state.metadata.summary,
            genre: this.state.metadata.genres
        }

        // /admin/update/summary/{contentId}

        axios.post(window.location.origin + "/api/admin/update/summary/" + id, requestBody)
            .then(res => {
                console.log("Completed Request " + res);
                window.location.reload();
            })
    }

    handleUploadPhoto = event => {
        this.state.tempSummaryPhoto = event.target.files[0];
        //axios call here for uploading......
    }

//     this.setState({castNum: this.state.castNum - 1});
// castMember.splice(i, 1);
// this.state.cast.splice(i, 1);
    handleDeletePhoto = (photos, i, id) => {
        axios.delete(window.location.origin + "/api/admin/delete/media/" + this.state.type.toString() + "/" + this.state.id + "/" + id)
            .then(res => {
                console.log("Completed Request " + res);
            })
        photos.splice(i, 1);
        this.forceUpdate();
    }

    handleNameChange = event => {
        this.state.metadata.name = event.target.value;
        this.forceUpdate();
    }

    handleSummaryChange = event => {
        this.state.metadata.summary = event.target.value;
        this.forceUpdate();
    }

    handleDeleteCast = (cast, i, id) => {
        axios.delete(window.location.origin + "/api/admin/delete/cast/" + this.state.type.toString() + "/" + this.state.id + "/" + id)
            .then(res => {
                console.log("Completed Request " + res);
            })
        cast.splice(i, 1);
        this.forceUpdate();
    }

    handleUpdateCast = event => {
        console.log("updating cast");

        // for (let i = 0; i < this.state.tempCast.length; i++) {
        //     let c = this.state.tempCast[i];
        //     console.log(c.role);
        //     console.log(c.name);
        // }

        let formattedCast = []
        for (let i = 0; i < this.state.tempCast.length; i++) {
            let cast = this.state.tempCast[i];
            let formatCast = {
                celebrity: {
                    id: cast.id,
                    name: cast.name
                },
                role: cast.role
            };
            if (cast.profilePictureFile != null) {
                console.log("profile pic here");
                let formData = new FormData();
                formData.append("myImage", cast.profilePictureFile);
                axios.post(window.location.origin + "/api/admin/upload", formData)
                    .then(res => {
                        console.log("Completed Request " + res);
                    });
                formatCast.celebrity['profilePicture'] = {
                    path: FILE_STORAGE_BASE_DIR + cast.profilePictureFile.name,
                    type: MediaType.PHOTO
                }
            }
            formattedCast.push(formatCast);
        }

        const requestBody = {
            type: this.state.type.toString(),
            cast: formattedCast
        }

        ///admin/update/cast/{contentId}
        axios.post(window.location.origin + "/api/admin/update/cast/" + this.state.id, requestBody)
            .then(res => {
               console.log("Completed Request for update Cast" + res);
            });



        // window.location.reload();
    }
    
    addCastMember = () => {
        this.setState({castNum: this.state.castNum + 1});
        this.state.tempCast.push(new CreateCast());
        console.log(this.state.tempCast);
        // this.forceUpdate();
    }

    removeCastMember = (castMember, i) => {
        this.setState({castNum: this.state.castNum - 1});
        castMember.splice(i, 1);
        this.state.tempCast.splice(i, 1);
        // this.forceUpdate();
    }
    
    displayCastList = () => {
        let castMember = []
        for (let i = 0; i < this.state.castNum; i++) {
            castMember.push(<div key ={i} className={i != 0 ? "padding-top" : ""}>
                <input type="file" onChange={(event) => this.state.tempCast[i].profilePictureFile = event.target.files[0]}/>
                <span className="icon align-right"> <img src={TRASH_ICON} className="align-right" onClick={() => this.removeCastMember(castMember, i)}/> </span>
                <input type="text" className="form-control" placeholder="Name" onChange={(event) => this.state.tempCast[i].name = event.target.value}/>
                <input type="text" className="form-control" placeholder="ID" onChange={(event) => this.state.tempCast[i].id = parseInt(event.target.value)}/>
                <input type="text" className="form-control" placeholder="Role" onChange={(event) => this.state.tempCast[i].role = event.target.value}/>
            </div>);
        }
        return castMember;
    }

    handleChangeGenre = event => {
        if (event.target.checked) {
            this.state.metadata.genres.push(GENRES_VALUES_MAP[event.target.value]);
        } else {
            let i = this.state.metadata.genres.indexOf(GENRES_VALUES_MAP[event.target.value]);
            this.state.metadata.genres.splice(i, 1);
        }
        this.forceUpdate();
    }

    handleMediaChange = event => {
        console.log('here');
        let mediaPaths = [];
        if (this.state.tempPhoto != null && this.state.tempPhoto.length > 0) {
            for (let i = 0; i < this.state.tempPhoto.length; i++) {
                console.log(this.state.tempPhoto.item(i).name);
                let formData = new FormData();
                formData.append("myImage", this.state.tempPhoto.item(i));
                axios.post(window.location.origin + "/api/admin/upload", formData)
                    .then(res => {
                        console.log("Completed Request " + res);
                    })
                let pic = new Media();
                pic.path = FILE_STORAGE_BASE_DIR + this.state.tempPhoto.item(i).name;
                pic.type = MediaType.PHOTO;
                mediaPaths.push(pic);
            }
        }

        const requestBody = {
            type: this.state.type.toString(),
            media: mediaPaths
        }

        ///admin/update/cast/{contentId}
        axios.post(window.location.origin + "/api/admin/update/media/" + this.state.id, requestBody)
            .then(res => {
                console.log("Completed Request for update Cast" + res);
                window.location.reload();
            });
    }

    render() {
        const state = this.props['data-state'];
        const currentUser = state.currentUser;
        const metadata = this.state.metadata;
        const genres = (this.state.type == ContentType.MOVIE ? MOVIE_GENRES : TV_GENRES).map((genre, i) => {
            return <div className="form-check form-check-inline" key={i}>
                <input className="form-check-input" type="checkbox" value={genre} checked={this.state.metadata.genres.indexOf(GENRES_VALUES_MAP[genre]) != -1}
                       onChange={this.handleChangeGenre}/>
                <label className="form-check-label">{genre}</label>
            </div>
        });
        
        const photos = state.media.filter(photo => photo.type == 'PHOTO').map((photo, i) => {
            return <div className="search-item">
                <img className="no-padding" src={photo.path}/> 
                { currentUser && currentUser.userType == UserType.ADMIN ? <span onClick={() => this.handleDeletePhoto(state.media, i, photo.id)}> <div className="x">X</div></span> : ''}
            </div>
        });
        
        const cast = state.cast.map((castPerson, i) => {
            return <div className="cast-person" key={i}>
                <img className="img-align-left" src={castPerson.celebrity.profilePicture ? castPerson.celebrity.profilePicture.path : NO_USER_PHOTO}/>
                <b> <a href={"/../celebrity/" + castPerson.celebrity.id}>{castPerson.celebrity.name}</a> </b> <br/>
                <i>{castPerson.role}</i> <br/>
                { currentUser && currentUser.userType == UserType.ADMIN 
                    ? <span className="icon"><img src={TRASH_ICON} onClick={() => this.handleDeleteCast(state.cast, i, castPerson.celebrity.id)}/></span>
                    : ''
                } 
            </div>
        });


        return (
            <div>
                <div id="edit-info-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <form onSubmit={()=>this.handleEditInfo(state.id)}>
                                <h2> Edit Information </h2>
                                Title
                                <input type="text" className="form-control" value={this.state.metadata.name} onChange={this.handleNameChange}/>
                    
                                Summary
                                <textarea className="form-control" value={this.state.metadata.summary} onChange={this.handleSummaryChange}/>
                    
                                Main Photo <br/>
                                <span className="form-control">
                                    <img className="summary-photo" src={parseMedia(this.state.summaryPhoto)}/>
                                    <input type="file"  onChange={this.handleUploadPhoto}/>
                                </span>
                                Genres  
                                <div className="form-control"> {genres} </div>
                                <p/>
                                <button className="btn"> Edit Information </button>
                            </form>
                        </div>
                    </div>    
                </div>

                <div id="edit-photos-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <h2>Photos</h2>
                            { currentUser && currentUser.userType == UserType.ADMIN ? 
                                <input type="file" className="form-control" multiple onChange={(event) => this.state.tempPhoto = event.target.files}/>
                            : ''}
                            <div className="form-control flex-center"> {photos} </div>
                            <p/>
                            <button className="btn" onClick={this.handleMediaChange}> Save Changes </button>
                        </div>
                    </div>    
                </div>


                                
                <div id="edit-cast-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content casts">
                            <form onSubmit={this.handleUpdateCast}>
                                <h2>Cast</h2>
                                { currentUser && currentUser.userType == UserType.ADMIN ? 
                                 <div>
                                    {this.displayCastList()}
                                    <button type="button" className={this.state.castNum != 0 ? "btn-link padding-top" : "btn-link"} onClick={this.addCastMember}>Add another cast</button>
                                    <p/>
                                </div>
                                : ''}
                                <div className="flex-center"> {cast} </div>
                                { currentUser && currentUser.userType == UserType.ADMIN ? <button className="btn"> Update Cast </button> : '' }
                            </form>
                        </div>
                    </div>    
                </div>
            </div>
        )
    }
}
