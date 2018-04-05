import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";
import { parseDate } from "../../helperFunctions";

export class CelebrityTemplate extends React.Component {
    state = {
        name: "",
        profilePhoto: "",
        birthday: "",
        birthplace: "",
        biography: "",
        photos: []
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get("https://ca8135fe-1ee0-465a-8147-c5d034840cbf.mock.pstmn.io/" + window.location.pathname)
        .then(function (response) {
            currentComponent.setState({ 
                name: response.data.name,
                profilePhoto: response.data.profilePhoto,
                birthday: parseDate(response.data.birthday),
                birthplace: response.data.birthplace,
                biography: response.data.biography,
                photos: response.data.media.photos
             });

        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {
        return (
           <div>
           <hr/>
           <div className="content" id="celebrity">
                
                <div className="summary">
                    <img src={this.state.profilePhoto} className="img-align-left"/> <h2>{this.state.name}</h2> <p/>
                    <b>Highest Rated:</b>  Ballet Shoes (2008)
                    <span className="tiny-margin-right"></span> 
                    <Mangoes data-rating="100"/> 100%  <br/>
                    
                    <b>Lowest Rated:</b>  Regression (2016) 
                    <span className="tiny-margin-right"></span> 
                    <Mangoes data-rating="15"/> 15% <br/>
                    
                    <b>Birthday:</b> {this.state.birthday} <br/>
                    <b>Birthplace:</b> {this.state.birthplace}
                    <p/><p/>
                    {this.state.biography}
                </div>

                
                <div className="photos margin-top-bottom">
                    <h2> Photos </h2> <p/> <hr/>
                    <div className="photos-inner">
                        {this.state.photos.map((photo, i) => <img src={photo} key={i}/>)}
                    </div>     
                </div>

                {/* <div className="filmography margin-top-bottom">
                    <h2> Filmography </h2>
                    <hr>
                    

                    <h4> Movies </h4>
                    <table className="table">
                        <thead className="thead-light">
                        <tr>
                            <th>Title</th>
                            <th>Year</th>
                            <th>Rating</th>
                            <th>Role</th>
                        </tr>
                        </thead>
                        <tr>
                            <td> The Circle </td>
                            <td> 2017 </td>
                            <td> 16% </td>
                            <td> Actor </td>
                        </tr>
                        
                        <tr>
                            <td> Beauty and the Beast </td>
                            <td> 2017 </td>
                            <td> 71% </td>
                            <td> Belle </td>
                        </tr>
                        
                        <tr>
                            <td> Colonia </td>
                            <td> 2016 </td>
                            <td> 27% </td>
                            <td> Len </td>
                        </tr>
                        
                    </table>

                    
                    <h4> TV </h4>
                    <table className="table">
                        <thead className="thead-light">
                        <tr>
                            <th>Title</th>
                            <th>Year</th>
                            <th>Rating</th>
                            <th>Role</th>
                        </tr>
                        </thead>
                        <tr>
                            <td> Jimmy Kimmel Live </td>
                            <td> 2017 </td>
                            <td> No Score Yet</td>
                            <td> Actor </td>
                        </tr>
                        
                        <tr>
                            <td> The Ellen Degeneres Show </td>
                            <td> 2017 <br/> 2014 <br/> 2012 </td>
                            <td> No Score Yet </td>
                            <td> Guest </td>
                        </tr>
                        
                        <tr>
                            <td> Late Show with David Letterman </td>
                            <td> 2016 </td>
                            <td> No Score Yet </td>
                            <td> Guest </td>
                        </tr>
                        
                    </table> 
                    
                </div>*/}
            </div>
            </div>
        )
    }
}