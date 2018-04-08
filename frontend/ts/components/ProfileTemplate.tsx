import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";
import { parseProfileMedia }  from "../../helperFunctions.js";

export class ProfileTemplate extends React.Component {
    state = {
        displayName: "",
        profilePicture: "",
        numFollowers: 0,
        numFollowing: 0,
        interestedList: [],
        disinterestedList: [], 
        currentUser: -1
    }    

    componentWillMount() {
        let currentComponent = this;
        axios.all([
            axios.get("http://localhost:9000/api" + window.location.pathname),
            axios.get("http://localhost:9000/api/getCurrentUser")
        ]).then(axios.spread(function(profile, currentUser) {
            currentComponent.setState({ 
                displayName: profile.data.displayName,
                profilePicture: "../"+ parseProfileMedia(profile.data.profilePicture),
                interestedList: profile.data.interestedList,
                disinterestedList: profile.data.disinterestedList,
                numFollowers: profile.data.numFollowers,
                numFollowing: profile.data.numFollowing,
                currentUser: currentUser.data.userId
             });
        }))
    }

    render() {
        console.log(this.state.currentUser);
        const x = (("/profile/" + this.state.currentUser) == window.location.pathname) ? <div className="x">X</div> : '';
        const followButton = (("/profile/" + this.state.currentUser) != window.location.pathname) ? <button className="btn">Follow</button> : '';
        
        
        const interestedList = this.state.interestedList.map((content, i) => {
            let newUrl = parseProfileMedia(content.summaryPhoto);
            return <div className="search-item">
            <img src={newUrl}/>
            {x}
            <div className="text">{content.metadata.name}</div>
            </div>
        });

        const disinterestedList = this.state.disinterestedList.map((content, i) => {
            let newUrl = parseProfileMedia(content.summaryPhoto);
            return <div className="search-item">
            <img src={newUrl}/>
            {x}
            <div className="text">{content.metadata.name}</div>
            </div>
        });

        return (
            <div className="profile">
                <hr className="header-hr"/>
                <div className="content">
                    
                    <div className="left">
                        <h2>{this.state.displayName}</h2>
                        <div className="bio box-shadow">
                            <img src={this.state.profilePicture}/> <br/>

                            <b>Followers:</b> <a href="">{this.state.numFollowers}</a> <br/>
                            <b>Following:</b> <a href="">{this.state.numFollowing}</a> 
                            <p/>
                            {followButton}
                        </div>
                        
                    </div>
        
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
                    
                    <h2 className="padding-top"> Interested </h2>
                    <div className="interests box-shadow">
                        <div className="flex-center">
                            {interestedList}
                        </div>
                        <span className="align-right"><a href="">View All</a></span>
                    </div>
                        
                    <h2 className="padding-top"> Not Interested </h2>
                    <div className="interests box-shadow">
                        <div className="flex-center">
                            {disinterestedList}
                        </div>
                        <span className="align-right"><a href="">View All</a></span>
                    </div>
                    </div>
                </div>
            </div>
        );
    }
}
