import React from "react";
import {BrowserRouter, Route, Link} from "react-router-dom";
import Home from "./Home"
import Profile from "./Profile"

export class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <BrowserRouter>
                <ul>
                    <li><Link to="/">HOME</Link></li>
                    <li><Link to="/profile">PROFILE</Link></li>
                </ul>

                <Route path="/" component={Home} exact></Route>
                <Route path="/profile" component={Profile} exact></Route>
            </BrowserRouter>
        );
    }
}