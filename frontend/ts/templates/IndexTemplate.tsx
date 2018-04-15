import * as React from "react";
import { Mangoes } from "../components/Mangoes";
import axios from "axios";
import { parseMedia }  from "../../helperFunctions.js";
import { Spotlight } from "../types/content";
import { SpotlightComponent } from "../components/SpotlightComponent";

export class IndexTemplate extends React.Component {
    state : Spotlight;

    constructor(props) {
        super(props);
        this.state = new Spotlight();
    }

    async componentWillMount() {
        try {
            const response = await axios.get("http://localhost:9000/api/index")
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
        return (
        <div>
            <img id="poster" src={parseMedia(this.state.posterImage)}/>
            <SpotlightComponent data-spotlight={this.state}/>
        </div>
    )}
}
