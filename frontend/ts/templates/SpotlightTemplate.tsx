import * as React from "react";
import axios from "axios";
import {parseMedia} from "../../HelperFunctions.js";
import {Spotlight} from "../types/content";
import { SpotlightDetailComponent } from "../components/SpotlightDetailComponents";

export class SpotlightTemplate extends React.Component {
    state : Spotlight;

    constructor(props) {
        super(props);
        this.state = new Spotlight();
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api/index')
            this.state.selectedContent = response.data.openingMovies;
            this.state.selectedTitle = 'Opening This Week';
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    setSelectedContent(content, title) {
        this.state.selectedContent = content;
        this.state.selectedTitle = title;
        this.forceUpdate()
    }

    render() {
        return (
            <div id="spotlight-page">
                <hr/>
                <div className="spotlight-type">
                    <b>IN THEATERS</b>
                    <ul>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.openingThisWeek, 'Opening This Week')}>Opening This Week </button> </li>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.topBoxOffice, 'Top Box Office')}>Top Box Office </button> </li>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.comingSoon, 'Coming Soon')}>Coming Soon</button> </li>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.certifiedFreshMovies, 'Certified Fresh Movies')}>Certified Fresh Movies</button> </li>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.highestRatedMovies, 'Highest Rated Movies')}>Highest Rated Movies</button> </li>
                    </ul>

                    <b>TV</b>
                    <ul>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.newTonight, 'New TV Tonight')}>New TV Tonight </button> </li>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.mostPopular, 'Most Popular TV on RT')}>Most Popular TV on RT </button> </li>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.certifiedFreshShows, 'Certified Fresh TV')}>Certified Fresh TV </button> </li>
                        <li> <button className="btn-link" onClick={() => this.setSelectedContent(this.state.highestRatedShows, 'Highest Rated TV Shows')}>Highest Rated TV Shows</button> </li>
                    </ul>
                </div>

                <SpotlightDetailComponent data-content={this.state.selectedContent} data-title={this.state.selectedTitle}/>
            </div>
        )
    }
}
