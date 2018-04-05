import * as React from "react";
import { Mangoes } from "./Mangoes";
import axios from "axios";

console.log("goes into search template");
export class SearchTemplate extends React.Component {
    state = {
        // summaryPhoto: "",
        // photos: [],
        // videos: [],
        // name: "",
        // summary: "",
        // genres: [],
        // mangoScore: 0,
        // audienceScore: 0,
        // releaseDate: "",
        // studioNetwork: "",
        // cast: []
    }

    componentWillMount() {
        let currentComponent = this;
        axios.get('http://localhost:8080/search?query=h')
        .then(function (response) {
            // currentComponent.setState({ 
            //     summaryPhoto: response.data.summaryPhoto,
            //     photos: response.data.media.photos,
            //     videos: response.data.media.videos,
            //     name: response.data.metadata.name,
            //     summary: response.data.metadata.summary,
            //     genres: response.data.metadata.genres,
            //     mangoScore: response.data.metadata.mangoScore,
            //     audienceScore: response.data.metadata.audienceScore,
            //     releaseDate: response.data.metadata.releaseDate,
            //     studioNetwork: response.data.metadata.studioNetwork,
            //     cast: response.data.metadata.cast
            //  });
            console.log(response.data);
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    render() {
        return (
            <div><h1>Search</h1></div>
        );
    }
}