import * as React from "react";
import { MANGO_COLOR, MANGO_BW } from "../../GlobalVariables";

export class Mangoes extends React.Component {
    render() {
        let rating = this.props['data-rating'];
        rating = Math.round((rating)/20);
        let mangoes = [];
       
        for (let i = 0; i < rating; i++) {
            mangoes.push(<img src={MANGO_COLOR}/>);
        }

        for (let i = 0; i < 5 - rating; i++) {
            mangoes.push(<img src={MANGO_BW} />);
        }

        return (
            <span className="rating mangoes tiny-margin-right">
                {mangoes}
            </span>
        );
    }
}