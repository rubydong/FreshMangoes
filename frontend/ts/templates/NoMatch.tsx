import * as React from "react";

export class NoMatch extends React.Component {
    render() {
        return (
            <div>
                <hr/>
                <div className="content center-text">
                <h1>There is nothing here!</h1>
                <h2>How did you end up here? <br/>
                Come, let's go back to the <a href="../">home page</a>.</h2>
                </div>
            </div>
        );
    }
}