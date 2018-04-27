import * as React from "react";
import * as ReactDOM from "react-dom";
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

    handleChangeGenre = event => {
        if (event.target.checked) {
            this.state.genres.push(event.target.value);
        } else {
            let i = this.state.genres.indexOf(event.target.value);
            this.state.genres.splice(i, 1);
        }
    }
    render() {
        const genres = (this.state.type == ContentType.MOVIE ? MOVIE_GENRES : TV_GENRES).map((genre) => {
            return <div className="form-check form-check-inline">
                <input className="form-check-input" type="checkbox" value={genre} onChange={this.handleChangeGenre}/>
                <label className="form-check-label">{genre}</label>
            </div>
        });

        const cast = ({children}) => {  
            return ReactDOM.createPortal(
                <div>
                    <input type="file"/> <p/>
                    <input type="text" className="small-margin-right" placeholder="Name"/>
                    <input type="text" placeholder="Role"/>
                </div> ,
              document.getElementById('cast')
            );
          };
        
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
                            <div className="col-sm-6 form-control" id="cast">
                                {/* <input type="file"/> <p/>
                                <input type="text" className="small-margin-right" placeholder="Name"/>
                                <input type="text" placeholder="Role"/> 

                                <div className="padding"></div>
                                <input type="file"/> <p/>
                                <input type="text" className="small-margin-right" placeholder="Name"/> 
                                <input type="text" placeholder="Role"/>  */}

                                <button className="btn-link" onClick={this.addAnotherCast}>Add another cast</button>
                            </div>
                        </div>

                        <button className="btn col-sm-4">Create Page</button>
                    </form>
                </div>
            </div>
        );
    }
}