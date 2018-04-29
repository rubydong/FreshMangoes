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
            console.log(this.state);
        } catch (err) {
            console.log(err);
        }
    }

    deleteReview(reviewId) { 
        axios.delete(window.location.origin + '/api/rating/delete/' + reviewId)
            .then(res => {
            window.location.reload();
        })
    }

    render() {
        
        const reports = this.state.reports;
        console.log(reports);
        console.log(reports.length);
        const r = reports.map((report, i) => {
            return <tr key={i}>
                    <td> <a href={"./profile" + report.user.id}>{report.user.displayName}</a></td>
                    <td> {report.body} </td>
                    <td> <a href={"./" + report.content.type.toLowerCase() + "/" + report.content.id}>{report.content.metadata.name} </a></td>
                    <td> {report.report} </td>
                    <td> <button className="btn" onClick={()=>this.deleteReview(report.id)}> Remove Review </button> </td>
                </tr>
        });

        return (            
            <div>
                <hr/>
                <div className="content">
                    <h2> View Reports </h2>
                    <hr/>
                    <table className="table">
                        <thead className="thead-light">
                            <tr>
                                <th>User</th>
                                <th>Review</th>
                                <th>Content Reviewed</th>
                                <th>Reason for Report</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody>{r}</tbody>
                    </table>
                </div>
            </div>
        )
    }
}