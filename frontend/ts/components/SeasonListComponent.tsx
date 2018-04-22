import * as React from "react";
import {parseMedia, parseDate} from "../../HelperFunctions.js";
import {Mangoes} from "../components/Mangoes";

export class SeasonListComponent extends React.Component {
    render() {
        const seasons = this.props['data-seasons'].map((season, i) => {
            return <div className="season">
                <img src={parseMedia(season.summaryPhoto)}/>
                <b><a href={"/season/" + season.id}>{season.metadata.name}</a></b> <br/>
                {season.metadata.summary}
                </div>
        });

        return (
            <div className="seasons margin-top-bottom">
                <h2> Seasons </h2> <hr/>
                {seasons}
            </div>
        );
    }
}