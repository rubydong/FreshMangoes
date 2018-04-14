import * as React from "react";
import { parseMedia }  from "../../helperFunctions.js";
import { Mangoes } from "./Mangoes";

export class DetailsComponent extends React.Component {

    render() {
       const genres = this.props['data-genres'].map((genre, i) => {
            return <span> {genre}{i < this.props['data-genres'].length - 1 ? ', ' : ''}</span>
        });
    
        return (
            <div className="content-info">
                {this.props['data-rating'] ? <div><b>Rating:</b> {this.props['data-rating']}</div>: ''}
                <b>Genres:</b>	{genres} <br/>
                {this.props['data-directors'] ? <div><b>Directed By:</b> {this.props['data-directors']}</div> : ''}
                {this.props['data-writers'] ? <div><b>Written By:</b> {this.props['data-writers']}</div> : ''}
                {this.props['data-producers'] ? <div><b>Produced By:</b> {this.props['data-producers']}</div> : ''}
                {this.props['data-theaters'] ? <div><b>In Theaters:</b> {this.props['data-theaters']}</div> : ''}
                {this.props['data-premiere'] ? <div><b>Premiere Date:</b> {this.props['data-premiere']}</div> : ''}
                {this.props['data-runtime'] ? <div><b>Runtime:</b> {this.props['data-runtime']} minutes</div> : ''}
                {this.props['data-studio'] ? <div><b>Studio:</b> {this.props['data-studio']}</div> : ''}
                {this.props['data-network'] ? <div><b>Network:</b> {this.props['data-network']}</div> : ''}
                <p/>
                <button className="btn small-margin-right"> Interested</button>
                <button className="btn"> Uninterested</button>
            </div>
        );
    }
}