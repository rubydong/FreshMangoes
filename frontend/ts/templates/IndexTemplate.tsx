import * as React from "react";
import axios from "axios";
import { parseMedia }  from "../../HelperFunctions";
import { Spotlight } from "../types/content";
import { IndexComponent } from "../components/IndexComponent";
import {HOME_PAGE_POSTER, HOME_POSTERS } from  "../../GlobalVariables";

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
            console.log(this.state);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
        const posters = HOME_POSTERS.map((poster, i) => {
            return <div className={i==0 ? 'active carousel-item' : 'carousel-item'}>
                <img id="poster" src={poster} key={i}/>
                <div className="carousel-caption d-none d-md-block">
                    <h2>The greatst showman</h2>
                </div>
            </div>
        })

        return (
        <div>
            <img id="poster" src={HOME_PAGE_POSTER}/>
            {/* <div id="carouselExampleControls" className="carousel slide" data-ride="carousel">
                <div className="carousel-inner">
                    {posters}
                </div>
                <a className="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="sr-only">Previous</span>
                </a>
                <a className="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="sr-only">Next</span>
                </a>
            </div> */}
            <IndexComponent data-spotlight={this.state}/>
        </div>
    )}
}
