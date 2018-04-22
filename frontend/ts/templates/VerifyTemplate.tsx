import * as React from "react";
import axios from "axios";

export class VerifyTemplate extends React.Component {
    async componentWillMount() {
        const response = await axios.get(window.location.origin + '/api' + window.location.pathname);
        window.location.assign('/../');
    }
}