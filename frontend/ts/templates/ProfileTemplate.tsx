import * as React from 'react';
import axios from 'axios';
import { User} from '../types/user';
import { Mangoes } from "../components/Mangoes";
import { InterestsListComponent } from '../components/InterestsListComponent';
import { ProfileInfoComponent } from '../components/ProfileInfoComponent';
import { RatingComponent } from '../components/RatingComponent';
import { parseProfileMedia }  from '../../HelperFunctions.js';

export class ProfileTemplate extends React.Component {
    state : User;

    constructor(props) {
        super(props);
        this.state = new User();
    }

    componentWillMount() {
        let currentComponent = this;
        axios.all([
            axios.get(window.location.origin + '/api' + window.location.pathname),
            axios.get(window.location.origin + '/api/getCurrentUser')
        ]).then(axios.spread(function(profile, currentUser) {
            currentComponent.state.currentUser = currentUser.data.userId;
            currentComponent.setState(profile.data); 
        }));
        
    }

    render() {
        let myData = [];
        if (this.state.ratings.length != 0) {
            myData = [].concat(this.state.ratings)
                .sort((b, a) => a.score - b.score);
        }
        let count = 0;
        for (let i = 0; i < myData.length; i++) {
            if (count < 2 && myData[i].score >= 80) {
                this.state.highestRatings.push(myData[i]);
                count++;
            }
        }
        count = 0;
        for (let i = myData.length - 1; i >= 0; i--) {
            if (count < 2 && myData[i].score <= 40) {
                this.state.lowestRatings.push(myData[i]);
                count++;
            }
        }

        return (
            <div className="profile page-background-color">
                <hr className="header-hr"/>
                <div className="content">
                    {this.state.displayName == "" ? <h2>There is no user here.</h2> :
                    <div>
                        <ProfileInfoComponent data-state={this.state}/>
                        <div className="right">
                            <RatingComponent data-ratings={this.state.ratings} data-id={this.state.id} data-rating-type="profile"/>
                            <RatingComponent data-ratings={this.state.highestRatings} data-id={this.state.id} data-rating-type="profile"/>
                            <RatingComponent data-ratings={this.state.lowestRatings} data-id={this.state.id} data-rating-type="profile"/>
                            <InterestsListComponent data-title='Interested' data-content={this.state.interestedList} data-current-user={this.state.currentUser}/>
                            <InterestsListComponent data-title='Not Interested' data-content={this.state.disinterestedList} data-current-user={this.state.currentUser}/>
                        </div>
                        <div className="clear-both padding-top"></div>
                    </div>
                    }
                </div>
                <div className="clear-both"></div>	
            </div>
        );
    }
}
