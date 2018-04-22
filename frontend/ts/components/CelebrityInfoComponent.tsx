import * as React from "react";
import {parseMedia, parseDate} from "../../HelperFunctions.js";
import {Mangoes} from "../components/Mangoes";

export class CelebrityInfoComponent extends React.Component {
    render() {
        const state = this.props['data-state'];
        return (
            <div className="summary">
                <img src={parseMedia(state.profilePicture)} className="img-align-left"/>
                <h2>{state.name}</h2> <p/>

                <b>Highest Rated:</b> {state.highestRated.metadata.name}
                <span className="small-margin-right"></span>
                <Mangoes data-rating={state.highestRated.metadata.mangoScore}/> {state.highestRated.metadata.mangoScore}%
                <br/>

                <b>Lowest Rated:</b> {state.lowestRated.metadata.name}
                <span className="small-margin-right"></span>
                <Mangoes data-rating={state.lowestRated.metadata.mangoScore}/> {state.lowestRated.metadata.mangoScore}%
                <br/>

                <b>Birthday:</b> {parseDate(state.birthday)} <br/>
                <b>Birthplace:</b> {state.birthplace} <p/><p/> 
                {state.biography}
            </div>
        );
    }
}