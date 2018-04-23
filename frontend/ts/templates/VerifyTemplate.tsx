import * as React from "react";
import axios from "axios";

export class VerifyTemplate extends React.Component {
    async componentWillMount() {
        await axios.post(window.location.origin + '/api' + window.location.pathname);
    }

    render() {	
        return (	
            <div>	
                <hr/>	
                <div className="content center-text">	
                    <h1>Thanks for joining Fresh Mangoes!</h1>	
                    <h3>You are now verified, go to the <a href="/../">home page.</a></h3>	
                </div>

            </div>	
        );	
    }
}