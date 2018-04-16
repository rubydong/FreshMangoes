import * as React from "react";
import {parseMedia} from "../../helperFunctions.js";

export class CastComponent extends React.Component {
    render() {
        const cast = this
            .props['data-cast']
            .map((castPerson, i) => {
                let newUrl = parseMedia(castPerson.profilePhoto);
                let role = Object.keys(castPerson.roles[this.props['data-name']])[0];
                return <div className="cast-person" key={i}>
                    <img src={newUrl} className="img-align-left"/>
                    <b>
                        <a href={"../celebrity/" + castPerson.id}>{castPerson.name}</a>
                    </b>
                    <br/>
                    <i>{role}</i>
                </div>
            });

        return (
            <div className="casts margin-top-bottom">
                <h2>Cast</h2>
                <hr/>
                <div className="flex-center">
                    {cast}
                </div>
                <p/>
                <div className="align-right">
                    <a href="">View All Cast</a>
                </div>
            </div>
        );
    }
}