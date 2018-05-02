import * as React from "react";
import { Mangoes } from "./Mangoes";
import { parseMoreMedia } from "../../HelperFunctions.js";
import { ContentType } from '../types/content';

export class SummaryComponent extends React.Component {
    render() {
        const metadata = this.props['data-metadata'];
        const list = [];
        const type = this.props['data-type'];
        const selectorText = (type == ContentType.SEASON) ? 'Season ' : 'Episode ';

        let regex, match, current;

        if (type == ContentType.SEASON) {
            regex = /\/season\/(\d+)/g;
            match = regex.exec(window.location.pathname);
            console.log(match);
            current = Number(match[1]);
        } else if (type == ContentType.EPISODE) {
            regex = /\/season\/(\d+)\/episode\/(\d+)/g;
            match = regex.exec(window.location.pathname);
            console.log(match);
            current = Number(match[2]);
        }

        for (let i = 1; i <= this.props['data-list-count']; i++) {
            list.push(
                <option key={i} value={"./" + i} selected={i == current}>
                    {selectorText + i}
                </option>
            );
        }


        return (
            <div>        
                <img className="img-align-left" src={parseMoreMedia(this.props['data-image'], this.props['data-media'])}/>
                <div className="summary-title">
                    <h2>{metadata.name}</h2>
                </div>

                <div className="plot">
                    { list.length != 0 ? <select className="form-control" onChange={(event) => window.location.assign(event.target.value)}> {list} </select> : ''} 
                    {type==ContentType.SEASON || type == ContentType.EPISODE ? '' 
                    : 
                     <div>
                        <b>
                        MangoMeter
                        <span className="med-margin-right"></span>
                        Audience Score
                        </b>
                        <Mangoes data-rating={metadata.mangoScore || 0}/> {metadata.mangoScore || 0}%
                        <span className="med-margin-right"></span>
                        <Mangoes data-rating={metadata.audienceScore || 0}/> {metadata.audienceScore || 0}%
                    </div>}
                    <p/>
                    {metadata.summary ? <div> <b>About Movie</b> <br/> {metadata.summary} <p/></div>: ''}
                </div>
            </div>
        );
    }
}
