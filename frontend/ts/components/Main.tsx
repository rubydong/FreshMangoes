import * as React from "react";
import { Switch, Route } from 'react-router-dom'
import { IndexTemplate } from "./IndexTemplate";
import { MovieTemplate } from "./MovieTemplate";
import { CelebrityTemplate } from "./CelebrityTemplate";

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={IndexTemplate}/>
      <Route path='/movie/:id' component={MovieTemplate}/>
      <Route path="/celebrity" component={CelebrityTemplate}/>
    </Switch>
  </main>
)

export default Main

// To do:
// - ShowTemplate
// - CelebrityTemplate
// - ProfileTemplate
// - SearchTemplate
