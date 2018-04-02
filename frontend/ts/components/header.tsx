import * as React from "react";

export class Header extends React.Component {
    render() {
        return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href="/"><img src="images/logov2.png"/></a> 
                <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" className="navbar-toggler" data-target="#navbarSupportedContent" data-toggle="collapse" type="button">
                <span className="navbar-toggler-icon"></span></button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item"> <a className="nav-link" href="/">Home</a> </li>
                        
                        <li className="nav-item"> <a className="nav-link" href="/profile.html">Profile</a> </li>
                        
                        <li className="nav-item"> <a className="nav-link" href="/movie.html">Movies</a> </li>
                        
                        <li className="nav-item"> <a className="nav-link" href="/tvshow.html">TV Shows</a> </li>
                    
                        <li className="nav-item"> <a className="nav-link" href="#">Sign out</a> </li>
                    </ul>
                    <form className="form-inline my-2 my-lg-0">
                        <input aria-label="Search" className="form-control mr-sm-2" type="search"/> <button className="btn" type="submit">Search</button>
                    </form>
                </div>
            </nav>
		</div>

        );
    }
}