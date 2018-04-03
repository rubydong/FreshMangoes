import * as React from "react";

export class Mangoes extends React.Component {
    render() {
        let rating = this.props['data-rating'];
        rating = Math.round((rating)/20);
        let mangoes = [];
       
        for (let i = 0; i < rating; i++) {
            mangoes.push(<img src="http://i67.tinypic.com/lazqr.jpg"/>);
        }

        for (let i = 0; i < 5 - rating; i++) {
            mangoes.push(<img src="http://i63.tinypic.com/2gxecgl.png" />);
        }

        return (
            
            <span className="rating">
                {mangoes}
            </span>
        );
    }
}