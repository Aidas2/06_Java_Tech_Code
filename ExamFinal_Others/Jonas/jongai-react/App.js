import React, { Component } from "react";
import Authentication from "./components/Authentication/Authentication";
import { BrowserRouter as Router, Route } from "react-router-dom";
import "./css/style.default.css";
import "./css/custom.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "popper.js";
import "bootstrap";
class App extends Component {
  render() {
    return (
      <Router>
        <Route path="/" render={props => <Authentication {...props} />} />
      </Router>
    );
  }
}

export default App;
