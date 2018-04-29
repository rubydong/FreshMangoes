import * as React from "react";
import axios from "axios";
import { CriticsApplication } from '../types/user';

export class CriticApplicationsTemplate extends React.Component {
    state : {critics: CriticsApplication []};

    constructor(props) {
        super(props);
        this.state = {critics: []};
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + "/api/admin/critic/apps");
            this.setState({critics : response.data});
        } catch (err) {
            console.log(err);
        }
    }

    approveReview (id) {
        axios.post(window.location.origin + '/api/admin/approve/' + id)
            .then(res => {
            window.location.reload();
        })
    }
    render() {
        const applications = this.state.critics.map((application, i) => {
            return <tr key={i}>
                    <td> <a href={"./profile/" + application.user.id}>{application.user.displayName}</a></td>
                    <td> {application.statement} </td>
                    <td> <button className="btn btn-thinner" onClick={()=>this.approveReview(application.user.id)}> Approve Application </button></td>
                </tr>
        });

        return (
            <div id="critics"> 
                <hr/>
                <div className="content">
                    <h2> View Reports </h2>
                    {applications.length == 0 ? <div className="center-text"><hr/>There are no critic applications right now.</div> :
                    (<table className="table">
                        <thead className="thead-light">
                            <tr>
                                <th>User</th>
                                <th>Reason</th>
                                <th>Decision</th>
                            </tr>
                        </thead>
                        <tbody> {applications} </tbody>
                    </table>)
                    }
                </div>
            </div>
        )
    }
}
