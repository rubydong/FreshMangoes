import * as React from "react";
import { Switch, Route } from 'react-router-dom'
import { IndexTemplate } from "./IndexTemplate";
import { MovieTemplate } from "./MovieTemplate";
import { ShowTemplate } from "./ShowTemplate";
import { CelebrityTemplate } from "./CelebrityTemplate";
import { SearchTemplate } from "./SearchTemplate";
import { ProfileTemplate } from "./ProfileTemplate";
import { SpotlightTemplate } from "./SpotlightTemplate";

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={IndexTemplate}/>
      <Route exact path='/index' component={IndexTemplate}/>
      <Route path='/movie/:id' component={MovieTemplate}/>
      <Route path='/show/:id' component={ShowTemplate}/>
      <Route path="/celebrity/:id" component={CelebrityTemplate}/>
      <Route path="/search" component={SearchTemplate}/>
      <Route path="/profile/:id" component={ProfileTemplate}/>
      <Route path="/spotlight" component={SpotlightTemplate}/>
    </Switch>
  </main>
)

export default Main