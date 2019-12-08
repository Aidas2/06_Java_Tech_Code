import React from "react";
import {NavLink} from "react-router-dom";
import "./Navigation.css";

const Navigation = () => {
    return (
        <div className="navigation">
            <ul className="navigation_ul">
                <li>
                    <NavLink to="/holidays">Svenciu sararas</NavLink>
                </li>
                <li>
                    <NavLink to="/countries">Saliu sarasas</NavLink>    
                </li>
                <li>
                    <NavLink to="/admin">Administration</NavLink>    
                </li>
                <li><NavLink to="/">Pradinis puslapis</NavLink></li>
            </ul>
        </div>
    );
};

export  default Navigation;