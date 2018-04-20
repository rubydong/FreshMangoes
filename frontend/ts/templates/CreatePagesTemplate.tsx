import * as React from "react";
import { MOVIE_GENRES } from "../../GlobalVariables";
import { TV_GENRES } from "../../GlobalVariables";

export class CreatePagesTemplate extends React.Component {

    render() {
        console.log(MOVIE_GENRES);
        const genres = MOVIE_GENRES.map((genre) => {
            return <div className="form-check form-check-inline">
                <input className="form-check-input" type="checkbox"/>
                <label className="form-check-label">{genre}</label>
            </div>
        });
        
        return ( 
            <div>
                <hr/>
                <div className="content">
                    <form id="create-form">
                        <h2> Create New Movie or TV Page </h2> 
                        <div className="padding"></div>


                        <div className="form-group row">
                            <label className="col-sm-2 col-form-label">Content Type</label>
                            <div className="form-check form-check-inline">
                                <input className="form-check-input" type="radio"/>
                                <label className="form-check-label">Movie</label>
                            </div>
                            <div className="form-check form-check-inline">
                                <input className="form-check-input" type="radio"/>
                                <label className="form-check-label">TV Show</label>
                            </div>
                        </div>
                        <div className="form-group row">
                            <label className="col-sm-2 col-form-label">Title</label>
                            <input type="text" className="col-sm-6 form-control"/>
                        </div>
                        
                        <div className="form-group row">
                            <label className="col-sm-2 col-form-label">Description</label>
                            <textarea className="col-sm-6 form-control"/>
                        </div>

                        <div className="form-group row">
                            <label className="col-form-label col-sm-2">Genres</label>
                            <div className="col-sm-6"> {genres} </div>
                        </div>
                        
                    </form>
                </div>
            </div>
        );
    }
}