import * as React from "react";
import axios from "axios";
import { Search, Content, ContentType }  from "../types/content";
import { SearchCriteriaComponent } from "../components/SearchCriteriaComponent";
import { SearchContentComponent } from "../components/SearchContentComponent";
import { SpotlightDetailComponent } from "../components/SpotlightDetailComponents";

export class SearchTemplate extends React.Component {
    state : Search;

    constructor(props) {
        super(props);
        this.state = new Search();
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api/search' + window.location.search);
            this.state.results = response.data.celebrities.length + response.data.content.length;
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    setSelectedContent(content, title) {
        this.state.selectedContent = content;
        this.state.selectedTitle = title;
        this.state.results = title == "" 
            ? this.state.celebrities.length + this.state.content.length
            : content.length;
        this.forceUpdate()
    }

    render() {
        const movies = this.state.content.filter(c => c.type == ContentType.MOVIE);
        const shows = this.state.content.filter(c => c.type == ContentType.SHOW);
        
        return (
        <div className="search page-background-color">
            <hr className="header-hr"/>
            <div className="content">
                
                <SearchCriteriaComponent/>
                <div className="search-results">
                    <h4> {this.state.results} Results found for "{window.location.search.substring(7).replace("%20", " ")}"</h4> <hr/>
                    <ul className="list-inline">
                        <li><button className="btn-link" onClick={() => this.setSelectedContent([], '')}>All</button></li>
                        <li><button className="btn-link" onClick={() => this.setSelectedContent(movies, 'Movies')}>Movies</button></li>		
                        <li><button className="btn-link" onClick={() => this.setSelectedContent(shows, 'Tv Shows')}>TV Shows</button></li>		
                        <li><button className="btn-link" onClick={() => this.setSelectedContent(this.state.celebrities, 'Celebrities')}>Celebrities</button></li>
                    </ul>
                    
                    {this.state.selectedTitle == ''
                    ? <div>
                    <SearchContentComponent data-title='Movies' data-content={this.state.content.filter(content => content.type === ContentType.MOVIE)}/>
                    <SearchContentComponent data-title='TV Shows' data-content={this.state.content.filter(content => content.type === ContentType.SHOW)}/>
                    <SearchContentComponent data-title='Celebrities' data-content={this.state.celebrities}/>
                    </div>
                    : <SearchContentComponent data-title={this.state.selectedTitle} data-content={this.state.selectedContent}/>
                    }
                </div>		
                <div className="clear-both"></div>	
            </div>
        </div>
        );
    }
}
