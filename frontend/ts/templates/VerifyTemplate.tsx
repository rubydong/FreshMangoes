import * as React from "react";
import axios from "axios";

export class VerifyTemplate extends React.Component {
    async componentWillMount() {
        axios.post(window.location.origin);
        window.location.replace('/');
    }
}