import * as React from "react";
import axios from "axios";
import { Critics } from '../types/user';
import { Mangoes } from "../components/Mangoes";
import { parseUserMedia } from "../../HelperFunctions";
import { RatingComponent } from '../components/RatingComponent';

export class CriticsTemplate extends React.Component {
    state : Critics;

    constructor(props) {
        super(props);
        this.state = new Critics();
    }

    async componentWillMount() {
        try {
            const criticsPromise = axios.get(window.location.origin + '/api' + window.location.pathname);
            const latestReviewsPromise = axios.get(window.location.origin + '/api/rating/latest');
            const [critics, reviews] = await Promise.all([criticsPromise, latestReviewsPromise]);
            this.setState({critics: critics.data});
            this.setState({latestReviews: reviews.data});
            //console.log(this.state);
        } catch (err) {
            //console.log(err);
        }
    }

    submitCriticApplication = event => {
        axios.post(window.location.origin + '/api/critic/apply', {body: this.state.applicationReason})
            .then(res => {
                window.location.reload();
        })
    }

    render() {
        const topCritics = (this.state.critics || []).slice(0,1).map((critic, i) => {
            return <div className="top-critic small-margin-right"> 
                    <a href={"./profile/" + critic.id}> {critic.displayName} </a> <br/>
                    <img src={parseUserMedia(critic.profilePicture)}/>
                </div>
        });

        const allCritics = (this.state.critics || []).map((critic, i) => {
            return <li className="list-group-item">
                        <a href={"./profile/" + critic.id}> {critic.displayName} </a>
                   </li>
        });

        return (

            <div id="critics" className="page-background-color">     
                {this.state.critics.length == 0 ? '' :
                <div className="content">
                    <div className="split-half big-margin-right">
                      
                        <h2> Top Critic </h2> <hr/>
                        <div className="interests flex-center box-shadow">
                            {topCritics}
                            <br className="clear-both"/>
                        </div>

                        <div className="clear-both padding-top">
                            <h2> List of Critics </h2> <hr/>
                            <ul className="list-group">
                                {allCritics}
                            </ul>
                        </div>
                        <p className="padding-top"/>
                        <button className="btn align-center" data-toggle="modal" data-target="#critic-modal">Apply to be a Critic</button>
                    </div>

                    <div className="split-half">
                        <RatingComponent data-ratings={this.state.latestReviews.slice(0,5)} data-title="Latest Critic Reviews"/>
                    </div>
                    <p className="clear-both"/>
                    <div id="critic-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div className="modal-dialog modal-lg">
                            <div className="modal-content">
                                <h2>Critic Application</h2>
                                <form onSubmit={this.submitCriticApplication}>
                                    What is your name?
                                    <input type="text" className="form-control" onChange={(event)=>this.setState({applicationName: event.target.value})}/>
                                    What is the link to your profile?
                                    <input type="text" className="form-control" onChange={(event)=>this.setState({applicationProfile: event.target.value})}/>
                                    Why should we pick you as a critic?
                                    <input type="text" className="form-control" onChange={(event)=>this.setState({applicationReason: event.target.value})}/>
                                    <button type="submit" className="btn btn-primary">Submit Application</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                }
            
            </div>
        )
    }
}
