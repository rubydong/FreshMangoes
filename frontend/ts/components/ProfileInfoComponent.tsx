import * as React from "react";
import axios from "axios";
import {parseUserMedia, getUrlID} from "../../HelperFunctions";
import {FollowComponent} from "../components/FollowComponent";

export class ProfileInfoComponent extends React.Component {
    state = {
        newDisplayName: '',
        newFile: null,
        newEmail: '',
        newPassword: '',
        oldPassword: '',
        profileUser: getUrlID(),
        privacy: '',
    }

    followUser() {
        axios.post(window.location.origin + '/api/follow/' + getUrlID())
            .then(res => {
                window.location.reload();
            });
    }

    unfollowUser() {
        axios.post(window.location.origin + '/api/unfollow/' + getUrlID())
            .then(res => {
                window.location.reload();
            });
    }

    handleDisplayNameChange = event => {
        this.setState({newDisplayName: event.target.value});
    }

    handleFileChange = event => {
        this.setState({newFile: event.target.files[0]});

    }
    handleEmailChange = event => {
        this.setState({newEmail: event.target.value});
    }

    handlePasswordChange = event => {
        this.setState({newPassword: event.target.value});
    }

    handleVerifyPasswordChange = event => {
        this.setState({oldPassword: event.target.value});
    }

    handleSubmit = async event => {
        event.preventDefault();
        const requests = []
        const editProfileInfo = {
            newName: this.state.newDisplayName,
            newFile: this.state.newFile,
            newEmail: this.state.newEmail,
            newPassword: this.state.newPassword,
            oldPassword: this.state.oldPassword,
            newPrivacy: this.state.privacy
        };

        if (editProfileInfo.newName != '') {
            requests.push(axios.post(window.location.origin + '/api/profile/name/update/', editProfileInfo));
        }
        if (editProfileInfo.newFile != null) {
            let formData = new FormData();
            formData.append("myImage", editProfileInfo.newFile);
            formData.append("oldPassword", editProfileInfo.oldPassword);
            requests.push(axios.post(window.location.origin + '/api/profile/picture/update/', formData));
        }
        if (editProfileInfo.newEmail != '') {
            requests.push(axios.post(window.location.origin + '/api/profile/email/reset/', editProfileInfo));
        }
        if (editProfileInfo.newPassword != '') {
            requests.push(axios.post(window.location.origin + '/api/profile/password/reset/', editProfileInfo));
        }
        if(editProfileInfo.newPrivacy != ''){
            requests.push(axios.post(window.location.origin + '/api/profile/privacy/update/', editProfileInfo));
        }
        await Promise.all(requests)
        window.location.reload();
    }

    handlePrivacyChange = event => {
        this.setState({privacy: event.target.value})
    }

    async deleteAccount() {
        const editInfo= {
            oldPassword: this.state.oldPassword
        }
        const response = await axios.post(window.location.origin + '/api/delete/profile', editInfo);
        window.location.reload();
    }

    async adminDeleteAccount() {
        const response = await axios.delete(window.location.origin + '/api/admin/user/delete/' + getUrlID());
        window.location.reload();
        //console.log(response);
    }

    render() {
        const state = this.props['data-state'];
        //console.log(state);
        const sameUser = ("/profile/" + state.currentUser.userId) == window.location.pathname;
        let alreadyFollowed = false;
        for (let i = 0; i < state.followers.length; i++) {
            if (state.followers[i].id == state.currentUser.userId) {
                alreadyFollowed = true;
                break;
            }
        }

        const editOrFollowButton = sameUser
            ? <button className="btn" data-toggle="modal" data-target="#profile-modal">Edit Profile</button>
            : (alreadyFollowed
                ? <button className="btn-light" onClick={this.unfollowUser}>Unfollow</button>
                : <button className="btn" onClick={this.followUser}>Follow</button>);
        const adminDeleteButton = state.currentUser.userType == "ADMIN"
            ? <button type="submit" className="btn btn primary" onClick={() =>
            { if (window.confirm("Are you sure you want to delete this account?")) this.adminDeleteAccount() }}>
                Delete Account
            </button>
            : '';
        return (
            <div className="left">
                <h2>{state.displayName}</h2>
                <div className="bio box-shadow">
                    <img className="profile-picture" src={parseUserMedia(state.profilePicture)}/>
                    <b>Views: </b> {state.views}
                    <FollowComponent data-followers={state.followers} data-following={state.following}/>
                    <p/>
                    {editOrFollowButton} <p/>
                    {adminDeleteButton}
                </div>


                <div id="profile-modal" className="modal fade bd-example-modal-lg" role="dialog"
                     aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <h2>Edit Profile</h2>
                            <form onSubmit={this.handleSubmit} encType="multipart/form-data">
                                New Display Name
                                <input type="text" className="form-control" onChange={this.handleDisplayNameChange}/>
                                Choose New Profile Picture
                                <input type="file" name="newFile" className="form-control" onChange={this.handleFileChange}/>
                                New Email
                                <input type="text" className="form-control" onChange={this.handleEmailChange}/>
                                New Password
                                <input type="password" className="form-control" onChange={this.handlePasswordChange}/>
                                Privacy Settings
                                <div className="form-control">
                                    <input type="radio" value="Everyone" name="privacy" onChange={this.handlePrivacyChange}/> Show to Everyone
                                    <span className="med-margin-right"/>
                                    <input type="radio" value="Me" name="privacy" onChange={this.handlePrivacyChange}/> Only Me
                                </div>
                                <br/>
                                Confirm Changes With Your Old Password
                                <input type="password" className="form-control"
                                       onChange={this.handleVerifyPasswordChange}/>
                                <button type="submit" className="btn btn-primary">Make Changes</button>
                            </form>

                            <span className="center-text">OR</span>
                            <button type="submit" className="btn btn primary" onClick={() => { if (window.confirm("Are you sure you want to delete this account?")) this.deleteAccount() }}> Delete
                                Account
                            </button>

                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
