import * as React from "react";
import * as ReactDOM from "react-dom";
import axios from "axios";
import { MOVIE_GENRES } from "../../GlobalVariables";
import { TV_GENRES } from "../../GlobalVariables";
import { CreatePage, ContentType } from "../types/content";
import { CreateCast } from "../types/celebrity";

export class CreatePagesTemplate extends React.Component {
    state: CreatePage;

    constructor(props) {
        super(props);
        this.state = new CreatePage();
    }

    handleCreateContentPage = event => {
        event.preventDefault();
        console.log(this.state);
        // axios.post(window.location.origin + '/admin/insert', this.state)
        //     .then(res => {
        //     window.location.reload();
        // })
    }

    handleChangeType = event => {
        this.setState({type: event.target.value});
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
    
    addCastMember = () => {
        this.setState({castNum: this.state.castNum + 1});
        this.state.cast.push(new CreateCast());
        this.forceUpdate();
    }

    removeCastMember = (castMember, i) => {
        this.setState({castNum: this.state.castNum - 1});
        castMember.splice(i, 1);
        this.state.cast.splice(i, 1);
        this.forceUpdate();
    }

    handleCastImageChange =  (i, event) => {
        this.state.cast[i].profilePicture = event.target.files[0];
    }

    handleCastNameChange =  (i, event) => {
        this.state.cast[i].name = event.target.value;
    }

    handleCastRoleChange = (i, event) => {
        this.state.cast[i].role = event.target.value;
    }

    render() {
        const genres = (this.state.type == ContentType.MOVIE ? MOVIE_GENRES : TV_GENRES).map((genre, i) => {
            return <div className="form-check form-check-inline" key={i}>
                <input className="form-check-input" type="checkbox" value={genre} onChange={this.handleChangeGenre}/>
                <label className="form-check-label">{genre}</label>
            </div>
        });

        let castMember = [];

        for (let i = 0; i < this.state.castNum; i++) {
            castMember.push(<div key ={i} className={i != 0 ? "padding-top" : ""}>
                <input type="file" onChange={(event) => this.handleCastImageChange(i, event)}/> 
                <button className="btn-link align-right" onClick={() => this.removeCastMember(castMember, i)}>x</button> <p/> 
                <input type="text" className="small-margin-right" placeholder="Name" onChange={(event) => this.handleCastNameChange(i, event)}/>
                <input type="text" placeholder="Role" onChange={(event) => this.handleCastRoleChange(i, event)}/>
            </div>);
            
        }
        
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

                        {this.state.type == ContentType.SEASON || this.state.type == ContentType.EPISODE 
                        ? (<div className="form-group row">
                            <label className="col-sm-2 col-form-label">Show ID</label>
                            <input className="col-sm-6 form-control" onChange={(event) => this.state.showID = parseInt(event.target.value)}/>
                           </div>) 
                        : ''}

                        {this.state.type == ContentType.EPISODE
                        ? (<div className="form-group row">
                            <label className="col-sm-2 col-form-label">Season ID</label>
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
                                {castMember}

                                <button className={castMember.length != 0 ? "btn-link padding-top" : "btn-link"} onClick={this.addCastMember}>Add another cast</button>
                            </div>
                        </div>

                        <button className="btn col-sm-4">Create Page</button>
                    </form>
                </div>
            </div>
        );
    }
}