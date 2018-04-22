import * as React from "react";
import {parseMedia, parseDate} from "../../HelperFunctions.js";
import {Mangoes} from "../components/Mangoes";

export class CelebrityInfoComponent extends React.Component {
    render() {
        return (
            <div className="summary">
                <img src={this.props['data-image']} className="img-align-left"/>
                <h2>{this.props['data-name']}</h2>
                <p/>
                <b>Highest Rated:</b>
                {this.props['data-highest-name']}
                <span className="small-margin-right"></span>
                <Mangoes data-rating={this.props['data-highest-score']}/> {this.props['data-highest-score']}%
                <br/>

                <b>Lowest Rated:</b>
                {this.props['data-lowest-name']}
                <span className="small-margin-right"></span>
                <Mangoes data-rating={this.props['data-lowest-score']}/> {this.props['data-lowest-score']}%
                <br/>

                <b>Birthday:</b>
                {parseDate(this.props['data-birthday'])}
                <br/>
                <b>Birthplace:</b>
                {this.props['data-birthplace']}
                <p/><p/> {this.props['data-biography']}
            </div>
        );
    }
}