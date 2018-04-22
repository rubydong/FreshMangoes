import * as React from "react";
import { parseMedia }  from "../../HelperFunctions.js";
import { Mangoes } from "./Mangoes";
import { Rating } from '../types/rating';
import axios from "axios";

export class RatingComponent extends React.Component {
    state = {
        score: 5,
        body: '',
        currentUser: -1, 
        currentReviewId: -1,
    }
    
    componentWillMount() {
        let currentComponent = this;
        axios.get(window.location.origin + '/api/getCurrentUser')
        .then(function (response) {
            currentComponent.setState({ 
                currentUser: response.data.userId,
            });
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    handleMangoChange = event => {
        this.setState({ score: event.target.value });
    }

    handleBodyChange = event => {
        this.setState({ body: event.target.value });
    }

    addReview = event => {
        const rating = {
            score: this.state.score * 20,
            body: this.state.body
        };
  
        axios.post(window.location.origin + '/api/rating/' + this.props['data-id'], rating);
    }

    editReview = event => {
        const rating = {
            score: this.state.score * 20,
            body: this.state.body,
            id: this.state.currentReviewId
        };
        console.log(rating);

        axios.post(window.location.origin + '/api/editRating/' + rating.id, rating)
            .then(res => {
        })
    }

    deleteReview(reviewId) { 
        axios.delete(window.location.origin + '/api/rating/delete/' + reviewId)
            .then(res => {
            window.location.reload();
        })
    }

    reportReview(reviewId) {
        axios.post(window.location.origin + '/api/rating/report/' + reviewId)
            .then(res => {
            window.location.reload();
        })
    }


    render() {
     
        const title = this.props['data-name'];
        const ratings = this.props['data-ratings'].map((rating, i) => {
            return <div className={"review " + (i%2==0 ? "pull-left" : "pull-right")}>
                    <b><a href={'../profile/' + rating.reviewerId}>{rating.username}</a></b> 
                    <span className="align-right"> <Mangoes data-rating={rating.score}/></span> <br/>
                    <i> <a href={'../' + rating.contentType.toLowerCase() + '/' + rating.contentId}> {title} </a></i> 
                    { this.state.currentUser == rating.reviewerId 
                    ? <span className="align-right">
                        <img src="../../images/icons/pencil.png" data-toggle="modal" data-target="#edit-rating-modal" onClick={()=>this.state.currentReviewId = rating.id}/>
                        <img src="../../images/icons/trash.png" onClick={() => this.deleteReview(rating.id)}/>
                      </span> 
                    : <span className="align-right"> <img src="../../images/icons/flag.png" onClick={() => this.reportReview(rating.id)}/> </span>
                    }
                    <hr/>
                    "{rating.body}"

                    <div id="edit-rating-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div className="modal-dialog modal-lg">
                            <div className="modal-content">
                                <h2>Edit Rating</h2>
                                <form onSubmit={this.editReview}>
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
                                    <button type="submit" className="btn btn-primary">Confirm Changes</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        });

        return (
            <div className="reviews margin-top-bottom">
                <h2> Reviews </h2> <hr/>
                {ratings.length == 0 ? <div className="center-text">There are no reviews right now. You can be the first!</div> : ratings}
                <span className="align-right small-padding-top"> <a href="" data-toggle="modal" data-target="#rating-modal">Add a Rating</a>  | <a href="">View All Reviews </a> </span>
                <div className="padding-top clear-both"></div>
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