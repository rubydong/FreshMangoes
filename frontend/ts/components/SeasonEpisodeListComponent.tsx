import * as React from "react";
import {parseMoreMedia, parseDate} from "../../HelperFunctions.js";
import {Mangoes} from "../components/Mangoes";

export class SeasonEpisodeListComponent extends React.Component {
    render() {
        const type = this.props['data-type'];
        const list = this.props['data-list'].map((list, i) => {
            return <div className="season">
                <img src={parseMoreMedia(list.summaryPhoto, list.media)}/>
                <b><a href={window.location.href + "/" + type + "/" + list.id}>{i+1 + ". " + list.metadata.name}</a></b> <br/>
                <i>Air date: {parseDate(list.metadata.releaseDate)}</i> <br/>
                {list.metadata.summary}
                </div>
        });

        return (
            <div className="seasons margin-top-bottom">
                <h2> {type=='season' ? 'Seasons' : 'Episodes'} </h2> <hr/>
                {list}
            </div>
        );
    }
}