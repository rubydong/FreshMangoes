import * as React from "react";
import * as ReactDOM from "react-dom";

export class Mangoes extends React.Component {
    render() {
        let rating = this.props['data-rating'];
        rating = Math.round((rating)/20);
        let mangoes = [];
       
        for (let i = 0; i < rating; i++) {
            mangoes.push(<img src="images/mangocolor.png"/>);
        }

        for (let i = 0; i < 5 - rating; i++) {
            mangoes.push(<img src="images/mangobw.png" />);
        }

        return (
            
            <div className="rating">
                {mangoes}
            </div>
        );
    }
}