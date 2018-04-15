import * as React from "react";
import axios from "axios";
import { parseMedia }  from "../../helperFunctions.js";
import { Spotlight } from "../types/content";
import { IndexComponent } from "../components/IndexComponent";

export class IndexTemplate extends React.Component {
    state : Spotlight;

    constructor(props) {
        super(props);
        this.state = new Spotlight();
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api/index')
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
        return (
        <div>
            <img id="poster" src={parseMedia(this.state.posterImage)}/>
            <IndexComponent data-spotlight={this.state}/>
        </div>
    )}
}
