import React from "react";
import ReactDOM from "react-dom";
import {App} from "./components/App";

// let rootElement = document.getElementById('react-root');
// if(rootElement === undefined || rootElement === null) {
//     rootElement = document.createElement("div");
//     rootElement.classList.add('react-root');
// }

ReactDOM.render(<App />, document.getElementById('react-root'));