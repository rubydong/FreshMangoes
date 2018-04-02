import * as React from "react";
import * as ReactDOM from "react-dom";
import "../css/bootstrap.css";
import "../css/style.css";
import { Header } from "./components/header";
import { Mangoes } from "./components/mangoes";
const data = require('../json/index.json');

ReactDOM.render(
    <div>
        <Header/>
        ok this now a movie
    </div>,
    document.getElementById("index")
);
