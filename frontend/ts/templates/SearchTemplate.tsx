import * as React from "react";
import axios from "axios";
import { Search }  from "../types/content";
import { SearchCriteriaComponent } from "../components/SearchCriteriaComponent";
import { ContentListsComponent } from "../components/ContentListsComponent";

export class SearchTemplate extends React.Component {
    state : Search;

    constructor(props) {
        super(props);
        this.state = new Search();
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api/search' + window.location.search);
            this.state.results = response.data.celebrities.length + response.data.shows.length + response.data.movies.length;
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
        return (
        <div className="search">
            <hr className="header-hr"/>
            <div className="content">
                
                <SearchCriteriaComponent/>

                <div className="search-results">
                    <h4> {this.state.results} Results found for "{window.location.search.substring(7).replace("%20", " ")}"</h4> <hr/>
                    <ul className="list-inline">
                        <li className="underline"><a href="">All</a></li>
                        <li><a href="">Movies</a></li>		
                        <li><a href="">TV Shows</a></li>		
                        <li><a href="">Celebrities</a></li>
                    </ul>
                    
                    <ContentListsComponent data-title='Movies' data-content={this.state.movies} data-search="true"/>
                    <ContentListsComponent data-title='TV Shows' data-content={this.state.shows} data-search="true"/>
                    <ContentListsComponent data-title='Celebrities' data-content={this.state.celebrities} data-search="true"/>
                </div>			
            </div>
        </div>
        );
    }
}
