import * as React from "react";
import { parseMedia }  from "../../helperFunctions.js";
import { Mangoes } from "./Mangoes";
import { Rating } from '../types/rating';

export class RatingComponent extends React.Component {
    handleMangoChange = event => {
        this.setState({ numMangos: event.value });
        console.log(event.value);
    }

    handleBodyChange = event => {
        this.setState({ reviewBody: event.value });
        console.log(event.value)
    }

    addReview() {
    }

    render() {
        const title = this.props['data-name'];
        const ratings = this.props['data-ratings'].map((rating, i) => {
            return <div className={"review " + (i%2==0 ? "pull-right" : "pull-left")}>
                    <b><a href="">Matthew Rozsa</a></b> 
                    <span className="align-right"> <Mangoes data-rating={rating.score}/></span> <br/>
                    <i> {title} </i> <hr/>
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
                        <form>
                            Rating out of five
                            <select onChange={this.handleMangoChange} className="form-control">
                            <option value="five-mangoes">Five Mangoes</option>
                            <option value="four-mangoes">Four Mangoes</option>
                            <option value="three-mangoes">Three Mangoes</option>
                            <option value="two-mangoes">Two Mangoes</option>
                            <option value="one-mango">One Mango</option>
                            </select>
                            <p/><p/>
                            Review
                            <textarea className="form-control"></textarea>
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