import * as React from "react";
import axios from "axios";

export class RegisterComponent extends React.Component {
    state = {
        email: '',
        displayName: '',
        password: '',
        passwordConfirmation: ''
    }
    
    handleEmailChange = event => {
    this.setState({ email: event.target.value });
    }

    handleDisplayNameChange = event => {
    this.setState({ displayName: event.target.value });
    }

    handlePasswordChange = event => {
    this.setState({ password: event.target.value });
    }

    handlePasswordConfirmationChange = event => {
    this.setState({ passwordConfirmation: event.target.value });
    }
    
    handleSubmit = event => {
    event.preventDefault();

    const registerInfo = {
        email: this.state.email,
        displayName: this.state.displayName,
        password: this.state.password,
    };

    console.log(registerInfo);
    axios.post(window.location.origin + '/api/register', registerInfo)
        .then(res => {
            console.log(res);
            window.location.reload();
        })
        .catch(err => {
            console.log(err);
        })
    }
    render() {
        return (
            <div id="register-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg">
                    <div className="modal-content">
                        <h2>Register</h2>
                        <form onSubmit={this.handleSubmit}>
                            Email
                            <input type="text" className="form-control" onChange={this.handleEmailChange}/> 
                            Display Name
                            <input type="text" className="form-control" onChange={this.handleDisplayNameChange}/> 
                            Password
                            <input type="password" className="form-control" onChange={this.handlePasswordChange}/> 
                            Password Confirmation 
                            <input type="password" className="form-control" onChange={this.handlePasswordConfirmationChange}/> 
                        
                        <button type="submit" className="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}
