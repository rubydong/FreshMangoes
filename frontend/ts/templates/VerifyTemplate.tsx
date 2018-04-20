import * as React from "react";
import axios from "axios";

export class VerifyTemplate extends React.Component {
    async componentWillMount() {
        axios.post(window.location.origin);
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