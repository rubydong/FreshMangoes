import * as React from "react";
import {parseMoreMedia, parseDate} from "../../HelperFunctions.js";
import {Mangoes} from "../components/Mangoes";

export class SeasonEpisodeListComponent extends React.Component {
    render() {
        const seasons = (this.props['data-seasons'] || []).map((list, i) => {
            return <div className="season">
                <img src={parseMoreMedia(list.summaryPhoto, list.media)}/>
                <b><a href={window.location.href + "/season/" + parseInt(i+1)}>{i+1 + ". " + list.metadata.name}</a></b> <br/>
                <i>Air date: {parseDate(list.metadata.releaseDate)}</i> <br/>
                {list.metadata.summary}
                </div>
        });

        const episodes = (this.props['data-episodes'] || []).map((list, i) => {
            return <div className="episode">
            
                <b><a href={window.location.href + "/episode/" + parseInt(i+1)}>{(i+1) + ". " + list.metadata.name}</a></b>
                <span className="align-right"><i>Air date: {parseDate(list.metadata.releaseDate)}</i></span> <br/>
                {list.metadata.summary}
                </div>
        });

        return (
            <div className="seasons margin-top-bottom">
                <h2> {this.props['data-seasons'] ? 'Seasons' : 'Episodes'} </h2> <hr/>
                {seasons} {episodes}
            </div>
        );
    }
}