import * as React from "react";
import { Switch, Route } from 'react-router-dom'
import { IndexTemplate } from "./IndexTemplate";
import { MovieTemplate } from "./MovieTemplate";
import { ShowTemplate } from "./ShowTemplate";
import { CelebrityTemplate } from "./CelebrityTemplate";
import { SearchTemplate } from "./SearchTemplate";

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={IndexTemplate}/>
      <Route path='/movie/:id' component={MovieTemplate}/>
      <Route path='/show/:id' component={ShowTemplate}/>
      <Route path="/celebrity" component={CelebrityTemplate}/>
      <Route path="/search?query=:query" component={SearchTemplate}/>
    </Switch>
  </main>
)

export default Main

// To do:
// - ShowTemplate
// - ProfileTemplate
// - SearchTemplate
