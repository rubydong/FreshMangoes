import * as React from "react";
import {parseMedia} from "../../helperFunctions.js";
import {Mangoes} from "./Mangoes";

export class SummaryComponent extends React.Component {
    render() {
        const list = [];
        for (let i = 1; i <= this.props['data-list']; i++) {
            list.push(
                <option> 
                    <a href={"./" + i}>
                    {this.props['data-list-type'] == 'season' ? 'Season ' + i : 'Episode ' + i}
                    </a>
                </option>);
        }
        

        return (
            <div>
                <img src={parseMedia(this.props['data-image'])} className="img-align-left"/>
                <div className="summary-title">
                    <h2>{this.props['data-title']}</h2>
                </div>

                <div className="plot">
                    { list.length != 0 ? <select className="form-control"> {list} </select> : ''} 
                    <b>
                        MangoMeter
                        <span className="med-margin-right"></span>
                        Audience Score
                    </b>
                    <br/>
                    <Mangoes data-rating={this.props['data-mango']}/> {this.props['data-mango']}%
                    <span className="med-margin-right"></span>
                    <Mangoes data-rating={this.props['data-audience']}/> {this.props['data-audience']}%
                    <p/>
                    <b>About Movie</b>
                    <br/> {this.props['data-plot']}
                    <p/>
                </div>
            </div>
        );
    }
}