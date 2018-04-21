import * as React from "react";
import {parseMedia, parseDate} from "../../helperFunctions.js";
import {Mangoes} from "../components/Mangoes";

export class EpisodeListComponent extends React.Component {
    render() {
        return (
            <div className="episodes margin-top-bottom">
				<h2> Episodes </h2> <hr/>
				<div className="episode">
					<b>1. Chapter One: MADMAX</b>
					<span className="align-right"><i> Air date: Oct 27, 2017 </i></span> <br/>
					With Hawkins preparing for Halloween, an arcade nemesis has a surprise, and a suspicious Detective Hopper checks out a decaying pumpkin patch.
				</div>
				
				<div className="episode">
					<b>2. Chapter Two: Trick or Treat, Freak</b> 
					<span className="align-right"><i> Air date: Oct 27, 2017 </i></span> <br/>
					Will experiences something horrifying while trick-or-treating, leaving Mike to question if Elevin is still alive somewhere. Nancy struggles with the facts about Barb's disappearance.
				</div>
				
				<div className="episode">
					<b>3. Chapter Three: The Pollywog</b> 
					<span className="align-right"><i> Air date: Oct 27, 2017 </i></span> <br/>
					Dustin takes in a bizarre pet; Eleven becomes more and more restless. Well-intentioned, Bob encourages Will to face his fears.
				</div>
            </div>
        );
    }
}