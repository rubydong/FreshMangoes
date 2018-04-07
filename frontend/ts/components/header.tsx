import * as React from "react";

export class Header extends React.Component {
    render() {
        return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href="/"><img src="http://i68.tinypic.com/14iq5vl.png"/></a> 
                <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" className="navbar-toggler" data-target="#navbarSupportedContent" data-toggle="collapse" type="button">
                <span className="navbar-toggler-icon"></span></button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item"> <a className="nav-link" href="/">Home</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="/profile/0">Profile</a> </li>
                        <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#login-modal">Login</a></li>
					    <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#register-modal">Register</a></li>
                        <li className="nav-item"> <a className="nav-link" href="/movie/0">Movies</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="/show/0">TV Shows</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="#">Sign out</a> </li>
                    </ul>
                    <form className="form-inline my-2 my-lg-0">
                        <input aria-label="Search" className="form-control mr-sm-2" type="search"/>
                        <a href="/search" className="btn btn-primary">Search</a>
                        {/* <button className="btn" type="submit">Search</button> */}
                    </form>
                </div>
            </nav>
		</div>

        );
    }
}