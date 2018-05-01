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
    async componentWillMount() {
        try {
            const profilePromise = axios(window.location.origin + '/api' + window.location.pathname);
            const currentUserPromise = axios(window.location.origin + '/api/getCurrentUser');
            const [content, currentUser] = await Promise.all([profilePromise, currentUserPromise]);
            this.setState(content.data);
            this.setState({currentUser : currentUser.data});
            console.log(this.state);
        } catch (err) {
            window.location.assign('/404');
        }
    }



    render() {
        let myData = [];
        if (this.state.ratings.length != 0) {
            myData = [].concat(this.state.ratings)
                .sort((b, a) => a.score - b.score);
        }
        for (let i = 0; i < myData.length; i++) {
            if (myData[i].score >= 80) {
                this.state.highestRatings.push(myData[i]);
                break;
            }
        }

        for (let i = myData.length - 1; i >= 0; i--) {
            if (myData[i].score <= 40) {
                this.state.lowestRatings.push(myData[i]);
                break;
            }
        }

        return (
            <div className="profile page-background-color">
                <hr className="header-hr"/>
                <div className="content">
                    {this.state.displayName == "" ? '' :
                    <div>
                        <ProfileInfoComponent data-state={this.state}/>
                        <div className="right">
                            {this.state.currentUser.userType == "CRITIC" ?
                            <div>
                                <RatingComponent data-ratings={this.state.highestRatings.slice(0,1)} data-id={this.state.id} data-rating-type="profile" data-title="Best Rating"/>
                                <RatingComponent data-ratings={this.state.lowestRatings.slice(0,1)} data-id={this.state.id} data-rating-type="profile" data-title="Worst Rating"/>
                            </div>
                            : ''}
                            <RatingComponent data-ratings={this.state.ratings} data-id={this.state.id} data-rating-type="profile" data-title="Reviews"/>
                            <InterestsListComponent data-title='Interested' data-content={this.state.interestedList} data-current-user={this.state.currentUser.userId}/>
                            <InterestsListComponent data-title='Not Interested' data-content={this.state.disinterestedList} data-current-user={this.state.currentUser.userId}/>
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
