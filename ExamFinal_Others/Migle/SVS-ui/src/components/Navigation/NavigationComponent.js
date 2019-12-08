import React, { Component } from "react";
import { Link } from "react-router-dom";

class NavigationComponent extends Component {
  render() {
    return (
      <div>
        <nav className="nav justify-content-end">
          <Link to={"/"} className="nav-link">
            home
          </Link>
          <Link to={"/new-user"} className="nav-link">
            create new user
          </Link>
          <Link to={"/reports"} className="nav-link">
            reports
          </Link>
        </nav>
      </div>
    );
  }
}

export default NavigationComponent;
