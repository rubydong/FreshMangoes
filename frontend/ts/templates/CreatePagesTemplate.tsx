import * as React from "react";
import { MOVIE_GENRES } from "../../GlobalVariables";
import { TV_GENRES } from "../../GlobalVariables";
import { CreatePage, ContentType } from "../types/content";

export class CreatePagesTemplate extends React.Component {
    state: CreatePage;

    constructor(props) {
        super(props);
        this.state = new CreatePage();
    }

    addAnotherCast () {

    }

    handleCreateContentPage = event => {
        event.preventDefault();
        console.log(this.state);
    }

    handleChangeType = event => {
        this.state.type = event.target.value;
        this.forceUpdate();
    }
    render() {
        const genres = (this.state.type == ContentType.MOVIE ? MOVIE_GENRES : TV_GENRES).map((genre) => {
            return <div className="form-check form-check-inline">
                <input className="form-check-input" type="checkbox"/>
                <label className="form-check-label">{genre}</label>
            </div>
        });
        
        return ( 
            <div className="page-background-color">
                <hr/>
                <div className="content">
                    <form id="create-form" onSubmit={this.handleCreateContentPage}>
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
                            <label className="col-form-label col-sm-2">Photos</label>
                            <input className="col-sm-6 form-control" type="file" multiple onChange={(event) => this.state.photos = event.target.files}/>
                        </div>

                        <div className="form-group row">
                            <label className="col-form-label col-sm-2">Videos</label>
                            <input className="col-sm-6 form-control" type="file" multiple onChange={(event) => this.state.videos = event.target.files}/>
                        </div>

                        <div className="form-group row">
                            <label className="col-form-label col-sm-2">Cast</label>
                            <div className="col-sm-6 form-control">
                                <input type="file"/> <p/>
                                <input type="text" className="small-margin-right" placeholder="Name"/>
                                <input type="text" placeholder="Role"/> 

                                <div className="padding"></div>
                                <input type="file"/> <p/>
                                <input type="text" className="small-margin-right" placeholder="Name"/> 
                                <input type="text" placeholder="Role"/> 
                            </div>
                        </div>

                        <button className="btn">Create Page</button>
                    </form>
                </div>
            </div>
        );
    }
}