import * as React from "react";
import { Mangoes } from "./Mangoes";

export class ProfileReviewComponent extends React.Component {
    render() {
        const reviews = this.props['data-reviews'].map((review) => {
            return <div className="review">
                <b> <a href="">{this.props['data-name']}</a> </b>
                <span className="align-right"><Mangoes data-rating={review.score}/></span> <br/>
                <i><a href={"/" + review.content.type.toLowerCase() + "/" + review.content.metadata.id}>{review.content.metadata.name}</a></i>
                { this.props['data-current-user'] == review.user.id
                ? <span className="align-right">
                    <img src="/../../images/pencil.png" data-toggle="modal" data-target="#edit-rating-modal" />
                    <img src="/../../images/trash.png"/>
                    </span> 
                : <span className="align-right"> <img src="/../../images/flag.png"/> </span>
                }
                <hr/>
                "{review.body}"
                </div>
        });
        return <div>
            <h2> Reviews </h2>
            <div className="profile-reviews list-group">
            {reviews.length != 0 ? reviews : <div className="interests box-shadow">You have not reviewed anything yet!</div>}
            </div>
        </div>
    }
}