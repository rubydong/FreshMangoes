import * as React from "react";
import { Mangoes } from "./Mangoes";

export class ProfileReviewComponent extends React.Component {

    render() {
        return <div>
            <h2> Reviews </h2>
            <div className="profile-reviews list-group">
            <div className="review">
                <b><a href="">{this.props['data-name']}</a></b> 
                <span className="align-right"><Mangoes data-rating="80"/></span> <br/>
                <i>Black Panther</i>

                <hr/>
                "Jordan has swagger to spare, with those rolling shoulders, but there's a breath of charm, too, all the more seductive in the overblown atmosphere of Marvel. He's twice as pantherish as the Panther."
            </div>
            <div className="review">
                <b><a href="">{this.props['data-name']}</a></b> 
                <span className="align-right"><Mangoes data-rating="40"/></span>  <br/>
                <i>Peter Rabbit</i>
                <hr/>
                "The movie remains an object lesson in how not to adapt a beloved volume to the screen."
            </div>
        </div>
        </div>
    }
}