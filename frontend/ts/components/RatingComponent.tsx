import * as React from "react";
import { parseMedia }  from "../../helperFunctions.js";
import { Mangoes } from "./Mangoes";
import { Rating } from '../types/rating';
import axios from "axios";

export class RatingComponent extends React.Component {
    state = {
        score: 5,
        body: '',
    }

    handleMangoChange = event => {
        this.setState({ score: event.target.value });
        console.log(event.target.value)
    }

    handleBodyChange = event => {
        this.setState({ body: event.target.value });
        console.log(event.target.value)
    }

    addReview = event => {
        event.preventDefault();
        const rating = {
            score: this.state.score,
            body: this.state.body
        };
  
        axios.post(window.location.origin + '/api/rating/' + this.props['data-id'], rating)
            .then(res => {
            console.log(res);
            console.log(res.data);
            window.location.reload();
        })
    }

    render() {
        const title = this.props['data-name'];
        const ratings = this.props['data-ratings'].map((rating, i) => {
            return <div className={"review " + (i%2==0 ? "pull-right" : "pull-left")}>
                    <b><a href={'../profile/' + rating.reviewerId}>{rating.username}</a></b> 
                    <span className="align-right"> <Mangoes data-rating={rating.score}/></span> <br/>
                    <i> <a href={'../' + rating.contentType.toLowerCase() + '/' + rating.contentId}> {title} </a></i> <hr/>
                    "{rating.body}"
                </div>
        });

        return (
            <div className="reviews margin-top-bottom">
                <h2> Reviews </h2> <hr/>
                {ratings}
                <span className="align-right small-padding-top"> <a href="" data-toggle="modal" data-target="#rating-modal">Add a Rating</a>  | <a href="">View All Reviews </a> </span>
    
                <div id="rating-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg">
                    <div className="modal-content">
                        <h2>Add Rating</h2>
                        <form onSubmit={this.addReview}>
                            Rating out of five
                            <select className="form-control" onChange={this.handleMangoChange}>
                                <option value="5">Five Mangoes</option>
                                <option value="4">Four Mangoes</option>
                                <option value="3">Three Mangoes</option>
                                <option value="2">Two Mangoes</option>
                                <option value="1">One Mango</option>
                            </select>
                            <p/><p/>
                            Review
                            <textarea className="form-control" onChange={this.handleBodyChange}></textarea>
                            <p/><p/>
                            <button type="submit" className="btn btn-primary">Submit Review</button>
                        </form>
                    </div>
                </div>
                </div>
            </div>
        );
    }
}