import * as React from "react";

export class NoMatch extends React.Component {
    render() {
        return (
            <div className="content page-background-color">
                
                <div className="white-component center-text">
                <h1>There is nothing here!</h1>
                <h3>How did you end up here? Come, let's go back to the <a href="../">home page</a>.</h3>
                </div>
            </div>
        );
    }
}