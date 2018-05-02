import * as React from "react";
import axios from "axios";
import { Report } from "../types/rating";

export class ReportsTemplate extends React.Component {
    state : { reports: Report[] };

    constructor(props) {
        super(props);
        this.state = {reports: []};
    }

    async componentWillMount() {
        try {
            const response = await axios.get(window.location.origin + '/api/admin/reports')
            this.setState({reports : response.data});
        } catch (err) {
            //console.log(err);
        }
    }

    deleteReport(reportId) { 
        axios.delete(window.location.origin + '/api/admin/rating/delete/' + reportId)
            .then(res => {
            window.location.reload();
        })
    }

    dismissReport(reportId) { 
        axios.post(window.location.origin + '/api/admin/dismiss/rating/' + reportId)
            .then(res => {
            window.location.reload();
        })
    }

    render() {
        const r = this.state.reports.map((report, i) => {
            return <tr key={i}>
                    <td> <a href={"./profile/" + report.user.id}>{report.user.displayName}</a></td>
                    <td> {report.body} </td>
                    <td> <a href={"./" + report.content.type.toLowerCase() + "/" + report.content.id}>{report.content.metadata.name} </a></td>
                    <td> {report.report} </td>
                    <td> <button className="btn btn-thinner" onClick={()=>this.deleteReport(report.id)}> Remove Review </button> </td>
                    <td> <button className="btn btn-thinner" onClick={()=>this.dismissReport(report.id)}> Dismiss Review </button> </td>
                </tr>
        });

        return (            
            <div>
                
                <div className="content page-background-color">
                    <div className="white-component">
                        <h2> View Reports </h2>
                        {r.length == 0 ? <div className="center-text"><hr/>There are no reports right now.</div> :
                        (<table className="table">
                            <thead className="thead-light">
                                <tr>
                                    <th>User</th>
                                    <th>Review</th>
                                    <th>Content Reviewed</th>
                                    <th>Reason for Report</th>
                                    <th>Remove</th>
                                    <th>Dismiss</th>
                                </tr>
                            </thead>
                            <tbody> {r} </tbody>
                        </table>)
                        }
                    </div>
                </div>
            </div>
        )
    }
}