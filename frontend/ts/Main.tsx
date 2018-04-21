import * as React from "react";
import { Switch, Route } from 'react-router-dom'
import { IndexTemplate } from "./templates/IndexTemplate";
import { MovieTemplate } from "./templates/MovieTemplate";
import { ShowTemplate } from "./templates/ShowTemplate";
import { SeasonTemplate } from "./templates/SeasonTemplate";
import { EpisodeTemplate } from "./templates/EpisodeTemplate";
import { CelebrityTemplate } from "./templates/CelebrityTemplate";
import { SearchTemplate } from "./templates/SearchTemplate";
import { ProfileTemplate } from "./templates/ProfileTemplate";
import { SpotlightTemplate } from "./templates/SpotlightTemplate";
import { CriticsTemplate } from "./templates/CriticsTemplate";
import { CreatePagesTemplate } from "./templates/CreatePagesTemplate";
import { ReportsTemplate } from "./templates/ReportsTemplate";
import { VerifyTemplate } from "./templates/VerifyTemplate";

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={IndexTemplate}/>
      <Route exact path='/index' component={IndexTemplate}/>
      <Route path='/movie/:id' component={MovieTemplate}/>
      <Route path='/show/:showid/:seasonid/:episodeid' component={EpisodeTemplate}/>
      <Route path="/show/:showid/:seasonid" component={SeasonTemplate}/>
      <Route path='/show/:id' component={ShowTemplate}/> 
      <Route path="/celebrity/:id" component={CelebrityTemplate}/>
      <Route path="/search*" component={SearchTemplate}/>
      <Route path="/profile/:id" component={ProfileTemplate}/>
      <Route path="/spotlight" component={SpotlightTemplate}/>
      <Route path="/critics" component={CriticsTemplate}/>
      <Route path="/create" component={CreatePagesTemplate}/>
      <Route path="/reports" component={ReportsTemplate}/>
      <Route path="/verify/:id" component={VerifyTemplate}/>
      <Route component={NoMatch}/>
    </Switch>
  </main>
)

const NoMatch = ({ location }) => (
  <div>
    <h3>
      404 NOT FOUND <code>{location.pathname}</code>
    </h3>
  </div>
);

export default Main
