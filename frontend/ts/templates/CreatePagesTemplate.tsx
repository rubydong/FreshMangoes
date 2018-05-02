import * as React from "react";
import * as ReactDOM from "react-dom";
import axios from "axios";
import { MOVIE_GENRES, TV_GENRES, GENRES_VALUES_MAP, FILE_STORAGE_BASE_DIR, TRASH_ICON } from "../../GlobalVariables";
import { CreatePage, ContentType } from "../types/content";
import { CreateCast } from "../types/celebrity";
import {Media, MediaType} from "../types/media";

export class CreatePagesTemplate extends React.Component {
    state: CreatePage;

    constructor(props) {
        super(props);
        this.state = new CreatePage();
    }

    handleCreateContentPage = event => {
        event.preventDefault();
        //console.log(this.state);

        //console.log("I AM HERE");

        let summaryPhoto = null;
        if (this.state.summaryPhoto != null) {
            let formData = new FormData();
            formData.append("myImage", this.state.summaryPhoto);
            //console.log("Posting to upload summaryPhoto");
            axios.post(window.location.origin + "/api/admin/upload", formData)
                .then(res => {
                    //console.log("Completed Request " + res);
                })
            summaryPhoto = new Media()
            summaryPhoto.path = this.state.summaryPhoto.name;
            summaryPhoto.type = MediaType.PHOTO;
        }

        // add pictures
        let mediaPaths = [];
        if (this.state.photos != null && this.state.photos.length > 0) {
            for (let i = 0; i < this.state.photos.length; i++) {
                let formData = new FormData();
                formData.append("myImage", this.state.photos.item(i));
                axios.post(window.location.origin + "/api/admin/upload", formData)
                    .then(res => {
                        //console.log("Completed Request " + res);
                    })
                let pic = new Media();
                pic.path = this.state.photos.item(i).name;
                pic.type = MediaType.PHOTO;
                mediaPaths.push(pic);
            }
        }
        // // // add pictures for celebrities?
        let formattedCast = []
        for (let i = 0; i < this.state.cast.length; i++) {
            let c = this.state.cast[i];
            let c2 = {
                celebrity: {
                    id: c.id,
                    name: c.name
                },
                role: c.role
            };
            if (c.profilePictureFile != null) {
                let formData = new FormData();
                formData.append("myImage", c.profilePictureFile);
                axios.post(window.location.origin + "/api/admin/upload", formData)
                    .then(res => {
                        //console.log("Completed Request " + res);
                    })
                c2.celebrity['profilePicture'] =  {
                    path: c.profilePictureFile.name,
                    type: MediaType.PHOTO
                }

            }



                formattedCast.push(c2);
        }

        let metadata = {
            name: this.state.name,
            summary: this.state.summary,
            genres: this.state.genres
        }

        const requestBody = {
            type: this.state.type.toString(),
            showId: this.state.showID,
            seasonId: this.state.seasonID,
            summaryPhoto: summaryPhoto,
            media: mediaPaths,
            metadata: metadata,
            cast: formattedCast
        }

        //console.log("about to post insert");
        //console.log(requestBody);
        axios.post(window.location.origin + "/api/admin/content/insert", requestBody)
            .then(res => {
                //console.log(res);
                //console.log("after posting to insert")

                if (requestBody.type == ContentType.MOVIE) {
                    window.location.assign(window.location.origin + "/movie/" + res.data.id);
                } else if (requestBody.type == ContentType.SHOW) {
                    window.location.assign(window.location.origin + "/show/" + res.data.id);
                } else {
                    window.location.assign(window.location.origin + "/show/" + requestBody.showId);
                }
            })
    }

    handleChangeType = event => {
        this.setState({type: event.target.value});
        this.forceUpdate();
    }

    handleChangeGenre = event => {
        if (event.target.checked) {
            this.state.genres.push(GENRES_VALUES_MAP[event.target.value]);
        } else {
            let i = this.state.genres.indexOf(GENRES_VALUES_MAP[event.target.value]);
            this.state.genres.splice(i, 1);
        }
        //console.log(this.state.genres);
    }
    
    addCastMember = () => {
        this.setState({castNum: this.state.castNum + 1});
        this.state.cast.push(new CreateCast());
        // this.forceUpdate();
    }

    removeCastMember = (castMember, i) => {
        this.setState({castNum: this.state.castNum - 1});
        castMember.splice(i, 1);
        this.state.cast.splice(i, 1);
        // this.forceUpdate();
    }

    displayCastList = () => {
        let castMember = []
        for (let i = 0; i < this.state.castNum; i++) {
            castMember.push(<div key ={i} className={i != 0 ? "padding-top" : ""}>
                <input type="file" onChange={(event) => this.state.cast[i].profilePictureFile = event.target.files[0]}/>
                <img src={TRASH_ICON} className="align-right" onClick={() => this.removeCastMember(castMember, i)}/>
                <input type="text" className="form-control" placeholder="Name" onChange={(event) => this.state.cast[i].name = event.target.value}/>
                <input type="text" className="form-control" placeholder="ID" onChange={(event) => this.state.cast[i].id = parseInt(event.target.value)}/>
                <input type="text" className="form-control" placeholder="Role" onChange={(event) => this.state.cast[i].role = event.target.value}/>
            </div>);
        }
        return castMember;
    }

    render() {
        const genres = (this.state.type == ContentType.MOVIE ? MOVIE_GENRES : TV_GENRES).map((genre, i) => {
            return <div className="form-check form-check-inline" key={i}>
                <input className="form-check-input" type="checkbox" value={genre} onChange={this.handleChangeGenre}/>
                <label className="form-check-label">{genre}</label>
            </div>
        });
        
        return ( 
            <div className="page-background-color">
                
                <div className="content">
                    <form id="create-form" onSubmit={this.handleCreateContentPage.bind(this)}>
                        <h2> Create a New Content Page </h2> 
                        <div className="padding"></div>

                        <div className="form-group row">
                            <label className="col-sm-2 col-form-label">Content Type</label>
                            <div className="col-sm-6 form-control">
                                <div className="form-check form-check-inline">
                                    <input className="form-check-input" name="content" defaultChecked type="radio" value={ContentType.MOVIE} onChange={this.handleChangeType}/>
                                    <label className="form-check-label">Movie</label>
                                </div>
                                <div className="form-check form-check-inline">
                                    <input className="form-check-input" name="content" type="radio" value={ContentType.SHOW} onChange={this.handleChangeType}/>
                                    <label className="form-check-label">TV Show</label>
                                </div>
                                <div className="form-check form-check-inline">
                                    <input className="form-check-input" name="content" type="radio" value={ContentType.SEASON} onChange={this.handleChangeType}/>
                                    <label className="form-check-label">Season</label>
                                </div>
                                <div className="form-check form-check-inline">
                                    <input className="form-check-input" name="content" type="radio" value={ContentType.EPISODE} onChange={this.handleChangeType}/>
                                    <label className="form-check-label">Episode</label>
                                </div>
                            </div>
                        </div>

                        {this.state.type == ContentType.SEASON || this.state.type == ContentType.EPISODE 
                        ? (<div className="form-group row">
                            <label className="col-sm-2 col-form-label">Show ID</label>
                            <input className="col-sm-6 form-control" onChange={(event) => this.state.showID = parseInt(event.target.value)}/>
                           </div>) 
                        : ''}

                        {this.state.type == ContentType.EPISODE
                        ? (<div className="form-group row">
                            <label className="col-sm-2 col-form-label">Season</label>
                            <input className="col-sm-6 form-control" onChange={(event) => this.state.seasonID = parseInt(event.target.value)}/>
                           </div>) 
                        : ''}

                        <div className="form-group row">
                            <label className="col-sm-2 col-form-label">Title</label>
                            <input type="text" className="col-sm-6 form-control" onChange={(event) => this.state.name = event.target.value}/>
                        </div>
                        
                        <div className="form-group row">
                            <label className="col-sm-2 col-form-label">Description</label>
                            <textarea className="col-sm-6 form-control" onChange={(event) => this.state.summary = event.target.value}/>
                        </div>

                        <div className="form-group row">
                            <label className="col-form-label col-sm-2">Main Photo</label>
                            <input className="col-sm-6 form-control" type="file" onChange={(event) => this.state.summaryPhoto = event.target.files[0]}/>
                        </div>

                        <div className="form-group row">
                            <label className="col-form-label col-sm-2">Genres</label>
                            <div className="col-sm-6 form-control"> {genres} </div>
                        </div>
                        
                        <div className="form-group row">
                            <label className="col-form-label col-sm-2">Media</label>
                            <input className="col-sm-6 form-control" type="file" multiple onChange={(event) => this.state.photos = event.target.files}/>
                        </div>

                        <div className="form-group row">
                            <label className="col-form-label col-sm-2">Cast</label>
                            <div className="col-sm-6 form-control" id="cast">
                                {this.displayCastList()}

                                <button type="button" className={this.state.castNum != 0 ? "btn-link padding-top" : "btn-link"} onClick={this.addCastMember}>Add another cast</button>
                            </div>
                        </div>

                        <button className="btn col-sm-4" type="submit">Create Page</button>
                    </form>
                </div>
            </div>
        );
    }
}
