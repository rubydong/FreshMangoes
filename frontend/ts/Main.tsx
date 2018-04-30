import * as React from "react";
import { Switch, Route } from 'react-router-dom'
import { IndexTemplate } from "./templates/IndexTemplate";
import { CelebrityTemplate } from "./templates/CelebrityTemplate";
import { SearchTemplate } from "./templates/SearchTemplate";
import { ProfileTemplate } from "./templates/ProfileTemplate";
import { SpotlightTemplate } from "./templates/SpotlightTemplate";
import { CriticsTemplate } from "./templates/CriticsTemplate";
import { CriticApplicationsTemplate } from "./templates/CriticApplicationsTemplate";
import { CreatePagesTemplate } from "./templates/CreatePagesTemplate";
import { ReportsTemplate } from "./templates/ReportsTemplate";
import { VerifyTemplate } from "./templates/VerifyTemplate";
import { NoMatch } from "./templates/NoMatch";
import { TosTemplate } from "./templates/TosTemplate";
import {ResetPasswordTemplate} from "./templates/ResetPasswordTemplate";
import { ContentTemplate } from "./templates/ContentTemplate";

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={IndexTemplate}/>
      <Route exact path='/index' component={IndexTemplate}/>
      <Route path='/movie/:id' component={ContentTemplate}/>
      <Route path='/show/:showid/season/:seasonid/episode/:episodeid' component={ContentTemplate}/>
      <Route path="/show/:showid/season/:seasonid" component={ContentTemplate}/>
      <Route path='/show/:id' component={ContentTemplate}/> 
      <Route path="/celebrity/:id" component={CelebrityTemplate}/>
      <Route path="/search*" component={SearchTemplate}/>
      <Route path="/profile/:id" component={ProfileTemplate}/>
      <Route path="/spotlight" component={SpotlightTemplate}/>
      <Route path="/critics" component={CriticsTemplate}/>
      <Route path="/applications" component={CriticApplicationsTemplate}/>
      <Route path="/create" component={CreatePagesTemplate}/>
      <Route path="/reports" component={ReportsTemplate}/>
      <Route path="/verify/:id" component={VerifyTemplate}/>
      <Route path="/tos" component={TosTemplate}/>
      <Route path="/404" component={NoMatch}/>
     <Route path="/resetpassword" component={ResetPasswordTemplate}/>
      <Route component={NoMatch}/>
    </Switch>
  </main>
)

export default Main
