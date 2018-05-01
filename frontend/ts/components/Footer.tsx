import * as React from "react";
import axios from "axios";

export class Footer extends React.Component {
    render() {
        return (
            <div className="footer center-text bg-light">
                
                <div className="flex-center">
                    <a href="/tos" className="med-margin-right">Terms of Service</a>  
                    <a href="/about">About Us</a>
                </div>
                <div className="social-icons flex-center ">
                    <img src="/./images/facebook.png"/>
                    <img src="/./images/instagram.png"/>
                    <img src="/./images/phone.png"/>
                    <img src="/./images/mail.png"/>
                </div>
                © 2018 Fresh Mangoes
            </div>
        )
    }
}