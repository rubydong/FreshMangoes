import * as React from 'react';
import axios from 'axios';
import { User} from '../types/user';
import { Mangoes } from "../components/Mangoes";
import { ContentListsComponent } from '../components/ContentListsComponent';
import { ProfileInfoComponent } from '../components/ProfileInfoComponent';
import { ProfileReviewComponent } from '../components/ProfileReviewComponent';
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
        }))
    }

    render() {
        return (
            <div className="profile">
                <hr className="header-hr"/>
                <div className="content">
                    <ProfileInfoComponent data-name={this.state.displayName} data-profile-picture={this.state.profilePicture}
                                          data-followers={this.state.numFollowers} data-following={this.state.numFollowing}
                                          data-current-user={this.state.currentUser}/>
                    <div className="right">
                        <ProfileReviewComponent data-name={this.state.displayName} data-current-user={this.state.currentUser} data-reviews={this.state.ratings}/>
                        <ContentListsComponent data-title='Interested' data-content={this.state.interestedList} data-current-user={this.state.currentUser}/>
                        <ContentListsComponent data-title='Not Interested' data-content={this.state.disinterestedList} data-current-user={this.state.currentUser}/>
                    </div>
                    <div className="clear-both padding-top"></div>
                </div>
            </div>
        );
    }
}
