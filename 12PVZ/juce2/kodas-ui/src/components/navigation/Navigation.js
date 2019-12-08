import React from "react";
import { NavLink } from "react-router-dom";

import "./Navigation.css";

const Navigation = () => {
  return (
    <div className="navigation">
      <ul className="navigation_ul">
        <li>
          <NavLink to="/">
            <div>Record Studios</div>
          </NavLink>
        </li>
        <li>
          <NavLink to="/performers">
            <div>Performer</div>
          </NavLink>
        </li>
      </ul>
    </div>
  );
};

export default Navigation;
