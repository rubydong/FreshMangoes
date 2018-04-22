import * as React from "react";
import axios from "axios";

export class VerifyTemplate extends React.Component {
    async componentWillMount() {
        try {
            const response = await axios.post(window.location.origin + '/api' + window.location.pathname);
            console.log(response);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
        return (
            <div>
                <hr/>
                <div className="content">
                    <h1>Thanks for joining Fresh Mangoes!</h1>
                    <h2>You are now verified.</h2>
                </div>
            </div>
        );
    }
    
}