import * as React from "react";
import axios from "axios";

export class RegisterTemplate extends React.Component {
    state = {
        email: '',
        username: '',
        password: '',
        passwordConfirmation: ''
    }
    
    handleEmailChange = event => {
    this.setState({ email: event.target.value });
    }

    handleUsernameChange = event => {
    this.setState({ username: event.target.value });
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
        displayName: this.state.username,
        password: this.state.password,
    };

    console.log(registerInfo);

     axios.post('http://localhost:9000/api/register', { registerInfo })
       .then(res => {
         console.log(res);
         console.log(res.data);
       },
         err => {
           console.log(err);
           console.log(err.data);
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
                            Username
                            <input type="text" className="form-control" onChange={this.handleUsernameChange}/> 
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