import * as React from "react";
import * as ReactDOM from "react-dom";
import "../css/bootstrap.css";
import "../css/style.css";
import { Header } from "./components/header";
import { MovieTemplate } from "./components/movieTemplate";
const data = require('../json/index.json');

ReactDOM.render(
    <div>
        <Header/>
        <MovieTemplate/>

    </div>,
    document.getElementById("index")
);
