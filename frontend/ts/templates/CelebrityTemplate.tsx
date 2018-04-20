import * as React from "react";
import axios from "axios";
import { Celebrity} from '../types/celebrity';
import { CelebrityInfoComponent } from '../components/CelebrityInfoComponent'
import { PhotoComponent } from '../components/PhotoComponent'
import { FilmographyComponent } from '../components/FilmographyComponent';

export class CelebrityTemplate extends React.Component {
    state : Celebrity;

    constructor(props) {
        super(props);
        this.state = new Celebrity();
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api' + window.location.pathname)
            this.setState(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    render() {
        return (
            <div>
                <hr/>
                <div className="content" id="celebrity">
                    <CelebrityInfoComponent data-image={this.state.profilePhoto} data-name={this.state.name}
                                    data-highest-name={this.state.highestRated.metadata.name} data-highest-score={this.state.highestRated.metadata.mangoScore}
                                    data-lowest-name={this.state.lowestRated.metadata.name} data-lowest-score={this.state.lowestRated.metadata.mangoScore}
                                    data-birthday={this.state.birthday} data-birthplace={this.state.birthplace} data-biography={this.state.biography}/>
                    <PhotoComponent data-photos={this.state.media.photos} data-actual-url="true"/> 
                    <FilmographyComponent data-roles={this.state.roles}/>
                    
                </div>
            </div>
        )
    }
}
