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

    approveApplication (id) {
        axios.post(window.location.origin + '/api/admin/approve/' + id)
            .then(res => {
            window.location.reload();
        })
    }

    rejectApplication (id) {
        axios.post(window.location.origin + '/api/admin/dismiss/critic/' + id)
            .then(res => {
            window.location.reload();
        })
    }

    render() {
        const applications = this.state.critics.map((application, i) => {
            return <tr key={i}>
                    <td> <a href={"./profile/" + application.user.id}>{application.user.displayName}</a></td>
                    <td> {application.statement} </td>
                    <td> <button className="btn btn-thinner" onClick={()=>this.approveApplication(application.user.id)}> Approve Application </button></td>
                    <td> <button className="btn btn-thinner" onClick={()=>this.rejectApplication(application.user.id)}> Reject Application </button></td>
                </tr>
        });

        return (
            <div id="critics"> 
                
                <div className="content page-background-color">
                    <div className="white-component">
                        <h2> View Critic Applications </h2>
                        {applications.length == 0 ? <div className="center-text"><hr/>There are no critic applications right now.</div> :
                        (<table className="table">
                            <thead className="thead-light">
                                <tr>
                                    <th>User</th>
                                    <th>Reason</th>
                                    <th>Approve</th>
                                    <th>Deny</th>
                                </tr>
                            </thead>
                            <tbody> {applications} </tbody>
                        </table>)
                        }
                    </div>
                </div>
            </div>
        )
    }
}
