import * as React from "react";
import axios from "axios";
import { CriticsApply } from '../types/user';
import { Mangoes } from "../components/Mangoes";
import { NO_USER_PHOTO } from "../../GlobalVariables";

export class CriticsTemplate extends React.Component {
    state : CriticsApply;

    constructor(props) {
        super(props);
        this.state = new CriticsApply();
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api' + window.location.pathname);
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    submitCriticApplication = event => {
        axios.post(window.location.origin + '/api/critic/apply', {body: this.state.applicationReason})
            .then(res => {
                window.location.reload();
        })
    }

    render() {
        return (
            <div id="critics"> 
                <hr/>
                <div className="content">
                    <div className="split-half big-margin-right">
                        <h2> Top Critics </h2> <hr/>
                        <div className="top-critic big-margin-right">
                            <a href="">Erin Crabtree</a> <br/> 
                            <img src={NO_USER_PHOTO}/>
                        </div>
                        <div className="top-critic">
                            <a href="">Erin Crabtree</a><br/> 
                            <img src={NO_USER_PHOTO}/>
                        </div>

                        <p/>

                        <div className="clear-both padding-top">
                            <h2> List of Critics </h2> <hr/>
                            <ul>
                                <li> <a href="">Alex Abad-Santos </a> </li>
                                <li> <a href="">Kate Abbott </a> </li>
                                <li> <a href="">Mae Abdulbaki </a> </li>
                                <li> <a href="">Hanif Abdurraqib </a> </li>
                                <li> <a href="">Daudi Abe </a> </li>
                                <li> <a href="">Fraser Abe </a> </li>
                            </ul>
                        </div>
                        <button className="btn" data-toggle="modal" data-target="#critic-modal">Apply to be a Critic</button>
                    </div>

                    <div className="split-half">
                        <h2> Top Reviews </h2> <hr/>
                        <div className="profile-reviews list-group">
                            <div className="review">
                                <b><a href="">Bob Smith</a></b> 
                                <span className="align-right"><Mangoes data-rating="80"/></span> <br/>
                                <i>Black Panther</i>

                                <hr/>
                                "Jordan has swagger to spare, with those rolling shoulders, but there's a breath of charm, too, all the more seductive in the overblown atmosphere of Marvel. He's twice as pantherish as the Panther."
                            </div>
                            <div className="review">
                                <b><a href="">Ruby Dong</a></b> 
                                <span className="align-right"><Mangoes data-rating="40"/></span>  <br/>
                                <i>Peter Rabbit</i>
                                <hr/>
                                "The movie remains an object lesson in how not to adapt a beloved volume to the screen."
                            </div>
                        </div>
                    </div>

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
            </div>
        )
    }
}
