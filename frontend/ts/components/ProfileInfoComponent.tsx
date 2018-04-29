import * as React from "react";
import axios from "axios";
import FileInput from 'react-file-input';
import {parseMedia, getUrlID} from "../../HelperFunctions";
import {FollowComponent} from "../components/FollowComponent";

export class ProfileInfoComponent extends React.Component {
    state = {
        newDisplayName: '',
        newFile: null,
        newEmail: '',
        newPassword: '',
        oldPassword: '',
        profileUser: getUrlID()
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
        console.log(event.target.files[0]);

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

    handleSubmit = event => {
        event.preventDefault();
        const editProfileInfo = {
            newName: this.state.newDisplayName,
            newFile: this.state.newFile,
            newEmail: this.state.newEmail,
            newPassword: this.state.newPassword,
            oldPassword: this.state.oldPassword
        };

        if (editProfileInfo.newName != '') {
            axios.post(window.location.origin + '/api/profile/name/update/', editProfileInfo)
                .then(res => {
                    window.location.reload();
                })
        }

        if (editProfileInfo.newFile != null) {
            var formData = new FormData();
            var imagefile = document.querySelector('#file');
            formData.append("image", event.target.files[0], 'name');
            axios.post('upload_file', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
        }
        if (editProfileInfo.newEmail != '') {
            axios.post(window.location.origin + '/api/profile/picture/update/', editProfileInfo)
                .then(res => {
                    window.location.reload();
                })
        }
        if (editProfileInfo.newPassword != '') {
            axios.post(window.location.origin + '/api/profile/password/reset/', editProfileInfo)
                .then(res => {
                    window.location.reload();
                })
        }

    }

    async deleteAccount() {
        const response = await axios.post(window.location.origin + '/api/delete/profile');
        window.location.reload();
    }

    render() {
        const state = this.props['data-state'];
        const sameUser = ("/profile/" + state.currentUser) == window.location.pathname;
        let alreadyFollowed = false;
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
                    <FollowComponent data-followers={state.followers} data-following={state.following}/>
                    <p/>
                    {editOrFollowButton}
                </div>


                <div id="profile-modal" className="modal fade bd-example-modal-lg" role="dialog"
                     aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <h2>Edit Profile</h2>
                            <form onSubmit={this.handleSubmit}>
                                New Display Name
                                <input type="text" className="form-control" onChange={this.handleDisplayNameChange}/>
                                {/*<FileInput name="myImage"*/}
                                           {/*accept=".png,.jpeg"*/}
                                           {/*placeholder="My Image"*/}
                                           {/*onChange={this.handleFileChange} />*/}
                                Choose New Profile Picture
                                <input type="file" className="form-control" onChange={this.handleFileChange}/>
                                New Email
                                <input type="text" className="form-control" onChange={this.handleEmailChange}/>
                                New Password
                                <input type="password" className="form-control" onChange={this.handlePasswordChange}/>
                                Confirm Changes With Your Old Password
                                <input type="password" className="form-control"
                                       onChange={this.handleVerifyPasswordChange}/>
                                <button type="submit" className="btn btn-primary">Make Changes</button>
                            </form>

                            <span className="center-text">OR</span>
                            <button type="submit" className="btn btn primary" onClick={this.deleteAccount}> Delete
                                Account
                            </button>

                        </div>
                    </div>
                </div>
            </div>
        );
    }
}