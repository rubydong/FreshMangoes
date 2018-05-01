import * as React from "react";
import {parseMedia} from "../../HelperFunctions.js";
import {SEARCH_SELECTED_LIMIT } from "../../GlobalVariables";

export class SearchContentComponent extends React.Component {
    state: any;

    componentWillMount() {
        this.setState({ currentPage: 0 });
    }

    constructor(props) {
      super(props);
      this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event) {
        this.setState({ currentPage: this.state.currentPage + Number(event.target.value)});
    }

    render() {
        const isCelebrity = this.props['data-title'] == 'Celebrities';
        const first = this.state.currentPage * SEARCH_SELECTED_LIMIT;
        const last = first + SEARCH_SELECTED_LIMIT;
        const contentList = this.props['data-content'].slice(first, last).map((content, i) => {
            let url = isCelebrity
                ? "/celebrity/" + content.id
                : "/" + content.type.toLowerCase() + "/" + content.id;
            let newUrl = !isCelebrity
                ? parseMedia(content.summaryPhoto)
                : parseMedia(content.profilePicture);
            return <div className="search-item">
                <img src={newUrl}/>
                <div className="text">
                    <a href={url}>{isCelebrity ? content.name : content.metadata.name}</a>
                </div>
            </div>
        });

			  const buttons = [];

        if (this.state.currentPage != 0) {
            buttons.push(<button className="btn-link" value={-1} onClick={this.handleClick}>
                             Prev
                         </button>);
				}

				if (this.state.currentPage != Math.ceil(this.props['data-content'].length / SEARCH_SELECTED_LIMIT)) {
            buttons.push(<button className="btn-link" value={1} onClick={this.handleClick}>
                             Next
                         </button>);
        }

        return (
            <div>
                <div>
                    <h5 className="search-shows padding-top">
                        {this.props['data-title']}
                    </h5>
                    <div className="search-shows search-content flex-center">
                        {contentList}
                    </div>
                </div>
                <span className="align-right">{buttons}</span>
            </div>
        );
    }
}
