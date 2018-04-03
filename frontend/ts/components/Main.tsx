import * as React from "react";
import { Switch, Route } from 'react-router-dom'
import {IndexTemplate} from "./indexTemplate";
import {MovieTemplate} from "./movieTemplate";

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={IndexTemplate}/>
      <Route path='/movie' component={MovieTemplate}/>
    </Switch>
  </main>
)

export default Main
