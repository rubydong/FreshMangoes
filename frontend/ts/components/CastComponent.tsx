import * as React from "react";
import { NO_USER_PHOTO, CAST_LIMIT } from "../../GlobalVariables";

export class CastComponent extends React.Component {
    render() {
        const cast = this.props['data-cast'].slice(0, CAST_LIMIT).map((castPerson, i) => {
            return <div className="cast-person" key={i}>
                <img className="img-align-left" src={castPerson.celebrity.profilePicture ? castPerson.celebrity.profilePicture.path : NO_USER_PHOTO}/>
                <b> <a href={"../celebrity/" + castPerson.celebrity.id}>{castPerson.celebrity.name}</a> </b> <br/>
                <i>{castPerson.role}</i>
            </div>
        });

        return (cast == null || cast.length == 0) 
            ? ''
            : <div className="casts margin-top-bottom">
                <h2>Cast</h2>
                <hr/>
                <div className="flex-center">
                    {cast}
                </div>
              </div>
        ;
    }
}