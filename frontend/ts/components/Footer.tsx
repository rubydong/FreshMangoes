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
                    <a href="https://www.facebook.com/FreshMangoes308/" target="_blank"><img src="/./images/facebook.png"/></a>
                    <a href="https://www.instagram.com/freshmangoes308/" target="_blank"><img src="/./images/instagram.png"/></a>
                    <img title="347-777-8888" src="/./images/phone.png"/>
                    <img title="Freshmangoes@gmail.com" src="/./images/mail.png"/>
                </div>
                © 2018 Fresh Mangoes
            </div>
        )
    }
}