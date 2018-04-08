import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";

export class CelebrityTemplate extends React.Component {
    state = {
        name: "",
        profilePhoto: "",
        birthday: "",
        birthplace: "",
        biography: "",
        photos: [],
        highestRatedName: "",
        highestRatedScore: 0,
        lowestRatedName: null,
        lowestRatedScore: 0,
        filmsObject:null,
        films: []
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get("http://localhost:9000/api" + window.location.pathname)
        .then(function (response) {
            currentComponent.setState({ 
                name: response.data.name,
                profilePhoto: response.data.profilePhoto,
                birthday: response.data.birthday,
                birthplace: response.data.birthplace,
                biography: response.data.biography,
                photos: response.data.media.photos,
                highestRatedName: response.data.highestRated.metadata.name,
                highestRatedScore: response.data.highestRated.metadata.mangoScore,
                lowestRatedName: response.data.lowestRated.metadata.name,
                lowestRatedScore: response.data.lowestRated.metadata.mangoScore,
                filmsObject: response.data.roles,
                films: Object.keys(response.data.roles)
             });

        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {
        const filmography = this.state.films.map((film) => {
            let title = film;
            let role = Object.keys(this.state.filmsObject[title])[0];
            let content = this.state.filmsObject[title];
            let type = content[role].type;
            let score = content[role].metadata.mangoScore;
            // let year = content[role].metadata.releaseDate;
            
            return <tr>
                    <td>{title}</td>
                    <td>{score}%</td>
                    <td>{type}</td>
                    <td>{role}</td>
                </tr>
        });


        return (
           <div>
           <hr/>
           <div className="content" id="celebrity">
                
                <div className="summary">
                    <img src={this.state.profilePhoto} className="img-align-left"/> <h2>{this.state.name}</h2> <p/>
                    <b>Highest Rated:</b>  {this.state.highestRatedName} 
                    <span className="small-margin-right"></span> 
                    <Mangoes data-rating={this.state.highestRatedScore}/> {this.state.highestRatedScore}%  <br/>
                    
                    <b>Lowest Rated:</b>  {this.state.lowestRatedName}
                    <span className="small-margin-right"></span> 
                    <Mangoes data-rating={this.state.lowestRatedScore}/> {this.state.lowestRatedScore}% <br/>
                    
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

                <div className="filmography margin-top-bottom">
                    <h2> Filmography </h2> <hr/>
                    <table className="table">
                        <thead className="thead-light">
                            <tr>
                                <th>Title</th>
                                <th>Rating</th>
                                <th>Type</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>{filmography}</tbody>
                    </table>                    
                </div>
            </div>
            </div>
        )
    }
}
