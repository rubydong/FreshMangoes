import * as React from "react";
import { Mangoes }  from "../components/Mangoes";

export class SearchCriteriaComponent extends React.Component {

    render() {
    
        return (
            <div className="search-criteria">
                <h4>Search Criteria</h4> <hr/>
                <em>**Used for movies and tv shows only**</em> <p/><p/>
                Genres
                <ul>
                    <li><input type="checkbox"/> Romance</li> 
                    <li><input type="checkbox"/> Mystery</li>
                    <li><input type="checkbox"/> Comedy</li>
                    <li><input type="checkbox"/> Horror</li>
                    <li><input type="checkbox"/> Science Fiction & Fantasy</li>
                    <li><input type="checkbox"/> Action & Adventure</li>
                    <li><input type="checkbox"/> Drama</li>
                </ul>

                Years
                <div className="input-group mb-3">
                    <div className="input-group-prepend"> <span className="input-group-text" id="inputGroup-sizing-default">Start</span> </div>
                    <input type="text" className="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"/>
                </div>


                <div className="input-group mb-3">
                    <div className="input-group-prepend"> <span className="input-group-text" id="inputGroup-sizing-default">End</span> </div>
                    <input type="text" className="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"/>
                </div>

                Ratings
                <ul>
                    <li> <input className="small-margin-right" type="radio"/> <Mangoes data-rating="100"/> </li> 
                    <li> <input className="small-margin-right" type="radio"/> <Mangoes data-rating="80"/> & up </li> 
                    <li> <input className="small-margin-right" type="radio"/> <Mangoes data-rating="60"/> & up </li> 
                    <li> <input className="small-margin-right" type="radio"/> <Mangoes data-rating="40"/> & up </li> 
                    <li> <input className="small-margin-right" type="radio"/> <Mangoes data-rating="20"/> & up </li> 
                </ul>
                <p/>

                <div className="criterias-div"> <button className="btn" type="submit">Apply Criterias</button> </div>
            </div>
        );
    
    }
}




