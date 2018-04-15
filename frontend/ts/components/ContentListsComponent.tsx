import * as React from "react";
import { parseMedia}  from "../../helperFunctions.js";

export class ContentListsComponent extends React.Component {

    render() {
        const sameUser = ("/profile/" + this.props['data-current-user']) == window.location.pathname;
        const x = sameUser ? <div className="x">X</div> : '';

        const isCelebrity = this.props['data-title'] == 'Celebrities';
        const isSearch = this.props['data-search'] == 'true';
        
        const contentList = this.props['data-content'].map((content, i) => {
            let url = isCelebrity ? "/celebrity/" + content.id : "/" + content.type.toLowerCase() + "/" + content.id;
            let newUrl = !isCelebrity  ? parseMedia(content.summaryPhoto) : parseMedia(content.profilePhoto);
            return <div className="search-item">
                    <img src={newUrl}/> {x}
                    <div className="text"><a href={url}>{isCelebrity ? content.name : content.metadata.name}</a></div>
                </div>
        });
        

        return (
            <div>
                {isSearch 
                    ? <div>
                        <h5 className="search-shows padding-top"> {this.props['data-title']} 
                        <span className="align-right"><a href="">View All</a></span></h5>
                        <div className="search-shows search-content flex-center"> {contentList} </div>
                      </div> 
                    : <div>
                        <h2 className="padding-top"> {this.props['data-title']} </h2>
                        <div className="interests box-shadow">
                            <div className="flex-center"> {contentList} </div>
                            <span className="align-right"><a href="">View All</a></span>
                        </div>
                       </div>
                }
            </div>
        );
    }
}