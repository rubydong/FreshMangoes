import * as React from "react";
import axios from "axios";
import { Celebrity} from '../types/celebrity';
import { CelebrityInfoComponent } from '../components/CelebrityInfoComponent';
import { PhotoComponent } from '../components/PhotoComponent';
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
            window.location.assign('/404');
        }
    }

    render() {
        return (
            <div className="no-background-image">
                <div className="content" id="celebrity">
                {this.state.name == "" ? '' :
                    <div>
                    <CelebrityInfoComponent data-state={this.state}/>
                    <PhotoComponent data-photos={this.state.media}/>
                    <FilmographyComponent data-roles={this.state.roles}/>
                    </div>
                }
                </div>
            </div>
        )
    }
}
