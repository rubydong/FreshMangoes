import * as React from "react";
import axios from "axios";
import { LOGO, USER_TYPES } from "../../GlobalVariables";

export class Header extends React.Component {
    state = {
        currentUser: -1,
        userType: null,
        searchQueries: ''
    }
    
    logout = event => {
        this.setState({ email: event.target.value, currentUser: -1 });
        axios.post(window.location.origin + '/api/logout').then(res => {
            window.location.assign("/../");
        });
    }

    handleSearchChange = event => {
        this.setState({searchQueries: event.target.value});
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get(window.location.origin + '/api/getCurrentUser')
        .then(function (response) {
            currentComponent.setState({ 
                currentUser: response.data.userId,
                userType: response.data.userType
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
                <a className="navbar-brand" href="/"><img src={LOGO}/></a> 
                <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" className="navbar-toggler" data-target="#navbarSupportedContent" data-toggle="collapse" type="button">
                <span className="navbar-toggler-icon"></span></button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item"> <a className="nav-link" href="/">Home</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="/spotlight">Spotlight</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="/critics">Critics</a> </li>
                        {isLoggedIn && this.state.userType == "ADMIN"
                        ? 
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Admin
                            </a>
                            <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a className="nav-link dropdown-item" href="/create">Create Page</a>
                                <a className="nav-link dropdown-item" href="/reports">View Reports</a>
                                <a className="nav-link dropdown-item" href="/applications">View Critic Applications</a>
                            </div>
                        </li>
                        : ''
                        }
                        {isLoggedIn
                        ? <span>
                            <li className="nav-item"> <a className="nav-link" href={profileUrl}>Profile</a> </li>
                            <li className="nav-item"> <a className="nav-link" href="" onClick={this.logout}>Sign out</a> </li>  
                          </span>
                        : <span>
                            <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#login-modal">Login</a></li> 
                            <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#register-modal">Register</a></li>
                          </span>
                        }
                        
                    </ul>
                    <form className="form-inline my-2 my-lg-0">
                        <input aria-label="Search" className="form-control mr-sm-2 search-bar" type="search" onChange={this.handleSearchChange}/>
                        <a className="btn btn-primary" href={"/search?query=" + this.state.searchQueries}>Search</a>
                    </form>
                </div>
            </nav>
		</div>

        );
    }
}