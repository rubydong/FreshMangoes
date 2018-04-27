import * as React from "react";
import axios from "axios";
import { parseMedia } from "../../HelperFunctions";

export class ProfileInfoComponent extends React.Component {
    state = {
        newDisplayName: '',
        newFile: null,
        newEmail: '',
        newPassword: '',
        oldPassword: ''
    }

    followUser () {
        axios.post(window.location.origin + '/api/follow/' + window.location.pathname.substring(window.location.pathname.lastIndexOf('/')+1))
        .then(res => {
            window.location.reload();
        });
    }

    unfollowUser () {
        axios.post(window.location.origin + '/api/unfollow/' + window.location.pathname.substring(window.location.pathname.lastIndexOf('/')+1))
        .then(res => {
            console.log(res);
            window.location.reload();
        });
    }

    handleDisplayNameChange = event => {
        this.setState({ newDisplayName: event.target.value });
    }

    handleFileChange = event => {
        this.setState({ newFile: event.target.files[0] });

        console.log(event.target.files[0]); 
        
    }
    handleEmailChange = event => {
        this.setState({ newEmail: event.target.value });
    }

    handlePasswordChange = event => {
        this.setState({ newPassword: event.target.value });
    }

    handleVerifyPasswordChange = event => {
        this.setState({ oldPassword: event.target.value });
    }

    handleSubmit = event => {
        event.preventDefault();
        const editProfileInfo = {
            newFile: this.state.newEmail,
            newEmail: this.state.newPassword,
            newPassword: this.state.newPassword,
            oldPassword: this.state.oldPassword
        };
        axios.post(window.location.origin + '/api/editProfile/' + this.props['data-current-user'], editProfileInfo)
            .then(res => {
            // window.location.reload();
        })
    }

    deleteAccount () {
        axios.post(window.location.origin + '/api/profile/delete/' + this.props['data-current-user'])
            .then(res => {
            window.location.reload();
            //logout
        })
    }

    render() {
        const state = this.props['data-state'];
        const sameUser = ("/profile/" + state.currentUser) == window.location.pathname;
        let alreadyFollowed = false;
        console.log(state);
        for (let i = 0; i < state.followers.length; i++) {
            if (state.followers[i].id == state.currentUser) {
                alreadyFollowed = true;
                break;
            }
        }

        const editOrFollowButton = sameUser 
            ? <button className="btn" data-toggle="modal" data-target="#profile-modal">Edit Profile</button> 
            : (alreadyFollowed 
                ? <button className="btn-light" onClick={this.unfollowUser}>Unfollow</button> 
                : <button className="btn" onClick={this.followUser}>Follow</button>);

        return (
            <div className="left">
                <h2>{state.displayName}</h2>
                <div className="bio box-shadow">
                    <img className="profile-picture" src={parseMedia(state.profilePicture)}/>
                    <b>Followers:</b> <a href="">{state.followers.length}</a> <br/>
                    <b>Following:</b> <a href="">{state.following.length}</a>
                    <p/>
                    {editOrFollowButton}
                </div>


                <div id="profile-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg">
                    <div className="modal-content">
                        <h2>Edit Profile</h2>
                        <form onSubmit={this.handleSubmit}>
                            New Display Name
                            <input type="text" className="form-control" onChange={this.handleDisplayNameChange}/>
                            Choose New  Profile Picture
                            <input type="file" className="form-control" onChange={this.handleFileChange}/>
                            New Email
                            <input type="text" className="form-control" onChange={this.handleEmailChange}/>
                            New Password
                            <input type="password" className="form-control" onChange={this.handlePasswordChange}/>
                            Confirm Changes With Your Old Password
                            <input type="password" className="form-control" onChange={this.handleVerifyPasswordChange}/>
                            <button type="submit" className="btn btn-primary">Make Changes</button>
                        </form>

                        <span className="center-text">OR</span>
                        <button type="submit" className="btn btn primary" onClick={this.deleteAccount}> Delete Account </button>

                    </div>
                </div>
		    </div>
            </div>
        );
    }
}