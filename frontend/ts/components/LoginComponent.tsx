import * as React from "react";
import axios from "axios";

export class LoginComponent extends React.Component {
    state = {
        email: '',
        password: ''
    }

    handleEmailChange = event => {
        this.setState({email: event.target.value});
    }

    handlePasswordChange = event => {
        this.setState({password: event.target.value});
    }

    handleSubmit = event => {
        event.preventDefault();
        const loginInfo = {
            email: this.state.email,
            password: this.state.password
        };
        axios.post(window.location.origin + '/api/login', loginInfo)
            .then(res => {
                window.location.reload();
            })
    }

    handleForgotEmailChange = event => {
        this.setState({email: event.target.value});
    }

    handleForgotPassword = event => {
        event.preventDefault();
        axios.post(window.location.origin + '/api/forgotpassword', {email: this.state.email})
            .then(res => {
                window.location.reload();
            })
    }

    handleResendVerification = event => {
        event.preventDefault();
        axios.post(window.location.origin + '/api/resendverification', {email: this.state.email})
            .then(res => {
                window.location.reload();
            })
    }

    render() {
        return (
            <div id="login-modal" className="modal fade bd-example-modal-lg" role="dialog"
                 aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg">
                    <div className="modal-content">
                        <h2>Login</h2>
                        <form onSubmit={this.handleSubmit}>
                            Email
                            <input type="text" className="form-control" onChange={this.handleEmailChange}/>
                            Password
                            <input type="password" className="form-control" onChange={this.handlePasswordChange}/>
                            <button type="submit" className="btn btn-primary">Login</button>
                        </form>
                    
                        <p/><p/>

                        <h2>Forgot Password?</h2>
                        <form onSubmit={this.handleForgotPassword}>
                            Email
                            <input type="text" className="form-control" onChange={this.handleEmailChange}/>
                            <button type="submit" className="btn btn-primary">Reset Password</button>
                        </form>

                        <p/><p/>

                        <h2>Resend Verification Email?</h2>
                        <form onSubmit={this.handleResendVerification}>
                            Email
                            <input type="text" className="form-control" onChange={this.handleForgotEmailChange}/>
                            <button type="submit" className="btn btn-primary">Email the Verification Key</button>
                        </form>


                    </div>
                </div>
            </div>
        )
    }
}
