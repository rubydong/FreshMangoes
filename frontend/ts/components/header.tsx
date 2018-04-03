import * as React from "react";

export class Header extends React.Component {
    render() {
        return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href=""><img src="http://i68.tinypic.com/14iq5vl.png"/></a> 
                <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" className="navbar-toggler" data-target="#navbarSupportedContent" data-toggle="collapse" type="button">
                <span className="navbar-toggler-icon"></span></button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item"> <a className="nav-link" href="/">Home</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="/profile.html">Profile</a> </li>
                        {/* <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#login-modal">Login</a></li> */}
					    {/* <li className="nav-item"> <a className="nav-link register-login" href="" data-toggle="modal" data-target="#register-modal">Register</a></li> */}
                        <li className="nav-item"> <a className="nav-link" href="/movie">Movies</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="/tvshow.html">TV Shows</a> </li>
                        <li className="nav-item"> <a className="nav-link" href="#">Sign out</a> </li>
                    </ul>
                    <form className="form-inline my-2 my-lg-0">
                        <input aria-label="Search" className="form-control mr-sm-2" type="search"/> <button className="btn" type="submit">Search</button>
                    </form>
                </div>
            </nav>


            {/* Login */}
            <div id="login-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg">
                    <div className="modal-content">
                        <h2>Login</h2>
                        <form>
                            Username
                            <input type="text" className="form-control"/>
                            Password
                            <input type="password" className="form-control"/>
                            
                        <button type="submit" className="btn btn-primary">Login</button>
                        </form>
                    </div>
                </div>
		    </div>
		
            {/* Register */}
		    <div id="register-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg">
                    <div className="modal-content">
                        <h2>Register</h2>
                        <form>
                            Email
                            <input type="text" className="form-control"/> 
                            Username
                            <input type="text" className="form-control"/> 
                            Display Name
                            <input type="text" className="form-control"/>  
                            Password
                            <input type="password" className="form-control"/> 
                            Password Confirmation 
                            <input type="password" className="form-control"/> 
                        
                        <button type="submit" className="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
		</div>

        );
    }
}