import * as React from "react";
import axios from "axios";

export class FollowComponent extends React.Component {
    render() {
        const followers = this.props['data-followers'];
        const following = this.props['data-following'];

        const followersFull = followers.map((f, i) => {
            return <li key={i}>
                <a href={"../profile/" + f.id}>{f.displayName}</a>
            </li>
        });

        const followingFull = following.map((f, i) => {
            return <li key={i}>
                <a href={"../profile/" + f.id}>{f.displayName}</a>
            </li>
        });

        return (
            <div>
            <b>Followers:</b> <a href="" data-toggle="modal" data-target="#follower-modal">{followers.length}</a> <br/>
            <b>Following:</b> <a href="" data-toggle="modal" data-target="#following-modal">{following.length}</a>
                    
                <div id="follower-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <h2>Followers</h2>
                            <ul className="follow">
                                {followersFull.length == 0 ? <span>This user is not followed by anyone.</span> : followersFull}
                            </ul>
                        </div>
                    </div>
                </div>

                <div id="following-modal" className="modal fade bd-example-modal-lg" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <h2>Following</h2>
                            <ul className="follow">
                                {followingFull.length == 0 ? <span>This user is not following anyone.</span> : followingFull}
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}