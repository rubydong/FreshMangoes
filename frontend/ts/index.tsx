import * as React from "react";
import * as ReactDOM from "react-dom";
import "../css/bootstrap.css";
import "../css/style.css";
import { BrowserRouter } from 'react-router-dom'
import  App  from './components/App';
import { Header } from "./components/header";
import { Mangoes } from "./components/mangoes";

const data = require('../json/index.json');

ReactDOM.render((
  <BrowserRouter>
    <App />
  </BrowserRouter>
), document.getElementById('root'));
