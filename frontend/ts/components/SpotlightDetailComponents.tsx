import * as React from "react";
import { Mangoes } from "../components/Mangoes";
import { parseMedia }  from "../../HelperFunctions";
import { SPOTLIGHT_CONTENT } from "../../GlobalVariables";

export class SpotlightDetailComponent extends React.Component {
    state = {
        currentContent: this.props['data-content'],
        currentPage: 1,
        contentPerPage: 12
    };
    
    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event) {
        this.setState({
            currentPage: Number(event.target.id)
        });
    }

    render() {
        const last = this.state.currentPage * this.state.contentPerPage;
        const first = last - this.state.contentPerPage;
        const current = this.props['data-content'].slice(first, last);

        const spotlightContent = current.map((content) => {
            const newUrl = parseMedia(content.summaryPhoto);
            return <div className="movieshow" key={content.id}>
                <img src={newUrl}/> <br/>
                <a href={"/" + (content.type != null ? content.type.toLowerCase() : 'movie') + "/" + content.id}> {content.metadata.name}</a> <br/>
                {content.metadata.mangoScore == 0 ? '' 
                : <span><Mangoes data-rating={content.metadata.mangoScore}/> <br/>
                  {content.metadata.mangoScore}%</span>
                }
            </div>  
        })

        const pageNumbers = [];
        for (let i = 1; i <= Math.ceil(this.props['data-content'].length / this.state.contentPerPage); i++) {
          pageNumbers.push(i);
        }

        const renderPageNumbers = pageNumbers.map(number => {
            return (
              <button className="btn-link" key={number} id={number} onClick={this.handleClick}>
                {number}
              </button>
            );
        });
        
        return (<div className="spotlight-content">
        <h2>{this.props['data-title']}</h2>
        <div className="spotlight-page-posters">
            {spotlightContent.length == 0 ? 'There are none right now.' : spotlightContent}
        </div>
        <span className="align-right">{renderPageNumbers}</span>
    </div>);
    }
}