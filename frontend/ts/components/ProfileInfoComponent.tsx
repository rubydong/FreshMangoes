import * as React from "react";
import axios from "axios";

export class ProfileInfoComponent extends React.Component {
    state = {
        newDisplayName: '',
        newFile: null,
        newEmail: '',
        newPassword: '',
        oldPassword: ''
    }
    handleDisplayNameChange = event => {
        this.setState({ newDisplayName: event.target.value });
    }
    
    handleFileChange = event => {
        this.setState({ newFile: event.target.files[0] });
        
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
        const loginInfo = {
            newFile: this.state.newEmail,
            newEmail: this.state.newPassword,
            newPassword: this.state.newPassword,
            oldPassword: this.state.oldPassword
        };
        console.log(this.state);
        axios.post(window.location.origin + '/api/login', loginInfo)
            .then(res => {
            // window.location.reload();
        })
    }

    render() {
        const sameUser = ("/profile/" + this.props['data-current-user']) == window.location.pathname;
        const editOrFollowButton = sameUser 
            ? <button className="btn" data-toggle="modal" data-target="#profile-modal">Edit Profile</button> 
            : <button className="btn">Follow</button>;
        const profilePicture = '../' + this.props['data-profile-picture'].substring(7);
        
        return (
            <div className="left">
                <h2>{this.props['data-name']}</h2>
                <div className="bio box-shadow">
                    <img className="profile-picture" src={profilePicture}/>                    
                    <b>Followers:</b> <a href="">{this.props['data-followers']}</a> <br/>
                    <b>Following:</b> <a href="">{this.props['data-following']}</a> 
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
                    </div>
                </div>
		    </div>
            </div>
        );
    }
}