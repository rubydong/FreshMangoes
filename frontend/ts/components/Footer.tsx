import * as React from "react";
import axios from "axios";

export class Footer extends React.Component {
    render() {
        return (
            <footer className="center-text white-background">
                <hr/>
                    Terms of Service  About Us
                <div className="flex-center">
                    facebook instagram email phone
                </div>
                © 2018 Fresh Mangoes
            </footer>
        )
    }
}