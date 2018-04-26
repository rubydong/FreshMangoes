import * as React from "react";
import {Mangoes} from "./Mangoes";
import { parseMoreMedia } from "../../HelperFunctions.js";

export class SummaryComponent extends React.Component {
    render() {
        const metadata = this.props['data-metadata'];
        const list = [];
        for (let i = 1; i <= this.props['data-list']; i++) {
            list.push(
                <option> 
                    <a href={"./" + i}>
                    {this.props['data-list-type'] == 'season' ? 'Season ' + i : 'Episode ' + i}
                    </a>
                </option>);
        }
        
        console.log(this.props['data-image']);
        console.log(this.props['data-media']);
        console.log(this.props['data-media'][0]);
        return (
            <div>        
                <img src={parseMoreMedia(this.props['data-image'], this.props['data-media'])} className="img-align-left"/>
                <div className="summary-title">
                    <h2>{metadata.name}</h2>
                </div>

                <div className="plot">
                    { list.length != 0 ? <select className="form-control"> {list} </select> : ''} 
                    <b>
                        MangoMeter
                        <span className="med-margin-right"></span>
                        Audience Score
                    </b>
                    <br/>
                    <Mangoes data-rating={metadata.mangoScore}/> {metadata.mangoScore}%
                    <span className="med-margin-right"></span>
                    <Mangoes data-rating={metadata.audienceScore}/> {metadata.audienceScore}%
                    <p/>
                    <b>About Movie</b>
                    <br/> {metadata.summary}
                    <p/>
                </div>
            </div>
        );
    }
}