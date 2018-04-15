import * as React from "react";

export class ProfileInfoComponent extends React.Component {

    render() {
        const sameUser = ("/profile/" + this.props['data-current-user']) == window.location.pathname;
        const followButton = sameUser ? '' : <button className="btn">Follow</button>;
        const profilePicture = '../' + this.props['data-profile-picture'].substring(7);
        
        return (
            <div className="left">
                <h2>{this.props['data-name']}</h2>
                <div className="bio box-shadow">
                    <img src={profilePicture}/> <br/>

                    <b>Followers:</b> <a href="">{this.props['data-followers']}</a> <br/>
                    <b>Following:</b> <a href="">{this.props['data-following']}</a> 
                    <p/>
                    {followButton}
                </div>
                
            </div>
        );
    }
}