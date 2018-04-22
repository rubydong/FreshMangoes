import * as React from "react";
import { parseMedia, parseDate } from "../../HelperFunctions.js";
import { Mangoes } from "../components/Mangoes";
import { FilmRating } from "../types/celebrity";

export class CelebrityInfoComponent extends React.Component {
    state : FilmRating;

    constructor(props) {
        super(props);
        this.state = new FilmRating();
    }

    render() {
        const state = this.props['data-state'];
        let roles = state.roles;
        for (let i = 0; i < roles.length; i++) {
            if (i == 0 ||roles[i].content.metadata.mangoScore > this.state.highestRatedScore) {
                console.log('higher');
                this.state.highestRatedName = roles[i].content.metadata.name;
                this.state.highestRatedScore = roles[i].content.metadata.mangoScore;
            } 
            if (i == 0 || roles[i].content.metadata.mangoScore < this.state.lowestRatedScore) {
                console.log('lower');
                this.state.lowestRatedName = roles[i].content.metadata.name;
                this.state.lowestRatedScore = roles[i].content.metadata.mangoScore;
            }
        }
    
        return (
            <div className="summary">
                <img src={parseMedia(state.profilePicture)} className="img-align-left"/>
                <h2>{state.name}</h2> <p/>
               
                <b>Highest Rated:</b> {this.state.highestRatedName}
                <span className="small-margin-right"></span>
                {this.state.highestRatedScore != 0 ? <span> <Mangoes data-rating={this.state.highestRatedScore}/> {this.state.highestRatedScore}% </span> : 'N/A'} <br/>
            
                <b>Lowest Rated:</b> {this.state.lowestRatedName}
                <span className="small-margin-right"></span>
                {this.state.lowestRatedScore != 0 ? <span><Mangoes data-rating={this.state.lowestRatedScore}/> {this.state.lowestRatedScore}% </span> : 'N/A'}<br/>

                <b>Birthday:</b> {parseDate(state.birthday)} <br/>
                <b>Birthplace:</b> {state.birthplace} <p/><p/> 
                {state.biography}
            </div>
        );
    }
}