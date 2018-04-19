import * as React from "react";
import { Switch, Route } from 'react-router-dom'
import { IndexTemplate } from "./templates/IndexTemplate";
import { MovieTemplate } from "./templates/MovieTemplate";
import { ShowTemplate } from "./templates/ShowTemplate";
import { CelebrityTemplate } from "./templates/CelebrityTemplate";
import { SearchTemplate } from "./templates/SearchTemplate";
import { ProfileTemplate } from "./templates/ProfileTemplate";
import { SpotlightTemplate } from "./templates/SpotlightTemplate";
import { CriticsTemplate } from "./templates/CriticsTemplate";

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
      <Route path="/critics" component={CriticsTemplate}/>
    </Switch>
  </main>
)

export default Main
