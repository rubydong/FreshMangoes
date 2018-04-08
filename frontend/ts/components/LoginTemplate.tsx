import * as React from "react";
import axios from "axios";

export class LoginTemplate extends React.Component {
    state = {
        email: '',
        password: '',
      }
    
    handleEmailChange = event => {
    this.setState({ email: event.target.value });
    }

    handlePasswordChange = event => {
        this.setState({ password: event.target.value });
    }

    handleSubmit = event => {
    event.preventDefault();

    const loginInfo = {
        email: this.state.email,
        password: this.state.password
    };

    console.log(loginInfo);

    axios.post('http://localhost:9000/api/login', loginInfo)
        .then(res => {
        console.log(res);
        console.log(res.data);
      })
    }

    render() {
        return (
            <div id="login-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
                    </div>
                </div>
		    </div>
        )
    }
}
