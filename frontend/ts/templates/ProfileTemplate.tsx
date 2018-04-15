import * as React from "react";
import axios from "axios";
import { User} from '../types/user';
import { Mangoes } from "../components/Mangoes";
import { ContentListsComponent } from '../components/ContentListsComponent';
import { ProfileInfoComponent } from '../components/ProfileInfoComponent'
import { parseProfileMedia }  from "../../helperFunctions.js";

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
                    <h2> Reviews </h2>
                    <div className="profile-reviews list-group">
                        
                        <div className="review">
                            <b><a href="">{this.state.displayName}</a></b> 
                            <span className="align-right"><Mangoes data-rating="80"/></span> <br/>
                            <i>Black Panther</i>
        
                            <hr/>
                            "Jordan has swagger to spare, with those rolling shoulders, but there's a breath of charm, too, all the more seductive in the overblown atmosphere of Marvel. He's twice as pantherish as the Panther."
                        </div>
                        <div className="review">
                            <b><a href="">{this.state.displayName}</a></b> 
                            <span className="align-right"><Mangoes data-rating="40"/></span>  <br/>
                            <i>Peter Rabbit</i>
                            <hr/>
                            "The movie remains an object lesson in how not to adapt a beloved volume to the screen."
                        </div>
                    </div>
                    
                    <ContentListsComponent data-title='Interested' data-content={this.state.interestedList} data-current-user={this.state.currentUser}/>
                    <ContentListsComponent data-title='Not Interested' data-content={this.state.disinterestedList} data-current-user={this.state.currentUser}/>
                    </div>
                </div>
            </div>
        );
    }
}
