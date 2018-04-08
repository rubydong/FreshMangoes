import * as React from "react";
import axios from "axios";

export class Header extends React.Component {
    state = {
        currentUser: -1
    }
    
    logout = event => {
        this.setState({ email: event.target.value });
        axios.post('http://localhost:9000/api/logout', {})
        .then(res => {
        });
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get("http://localhost:9000/api/getCurrentUser")
        .then(function (response) {
            currentComponent.setState({ 
                currentUser: response.data.userId,
            });
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {
        const isLoggedIn = this.state.currentUser != undefined && this.state.currentUser != -1;
        const profileUrl = "/profile/" + this.state.currentUser;
        
        return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href="/"><img src="http://i68.tinypic.com/14iq5vl.png"/></a> 
                <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" className="navbar-toggler" data-target="#navbarSupportedContent" data-toggle="collapse" type="button">
                <span className="navbar-toggler-icon"></span></button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item"> <a className="nav-link" href="/">Home</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="/spotlight">Spotlight</a> </li>
            
                        {isLoggedIn
                        ? <span className="flex-center">
                            <li className="nav-item"> <a className="nav-link" href={profileUrl}>Profile</a> </li>
                            <li className="nav-item"> <a className="nav-link" href="" onClick={this.logout}>Sign out</a> </li> 
                          </span>
                        : <span className="flex-center">
                            <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#login-modal">Login</a></li> 
                            <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#register-modal">Register</a></li>
                          </span>
                        }
                        
                    </ul>
                    <form className="form-inline my-2 my-lg-0">
                        <input aria-label="Search" className="form-control mr-sm-2" type="search"/>
                        <a href="/search?query=black" className="btn btn-primary">Search</a>
                        {/* <button className="btn" type="submit">Search</button> */}
                    </form>
                </div>
            </nav>
		</div>

        );
    }
}