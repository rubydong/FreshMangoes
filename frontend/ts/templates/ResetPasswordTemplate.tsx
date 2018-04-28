import * as React from "react";
import axios from "axios";

export class ResetPasswordTemplate extends React.Component {
    state = {
        email: '',
        password: '',
        passwordConfirm: ''
    }

    handleSubmit = event => {
        event.preventDefault();
        const loginInfo = {
            password: this.state.password,
            passwordConfirm: this.state.passwordConfirm
        };
        axios.post(window.location.origin + '/api/resetPassword', loginInfo)
            .then(res => {
                window.location.reload();
            })
    }

    render() {
        return (
            <div>
                <hr/>
                <div className="content">
                    <h2>Reset Password</h2>
                    <form onSubmit={this.handleSubmit}>
                        Email 
                        <input type="text" className="form-control" onChange={(event) => this.setState({email: event.target.value})}/>
                        New Password
                        <input type="text" className="form-control" onChange={(event) => this.setState({password: event.target.value})}/>
                        New Password Confirm
                        <input type="password" className="form-control" onChange={(event) => this.setState({passwordConfirm: event.target.value})}/>
                        <p/>
                        <button type="submit" className="btn btn-primary align-center">Reset</button>
                    </form>
                </div>
            </div>
        )
    }
}