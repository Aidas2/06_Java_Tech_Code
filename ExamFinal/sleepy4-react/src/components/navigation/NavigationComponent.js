import React from "react";
import {NavLink} from "react-router-dom";
import "./NavigationComponent.css";

const NavigationComponent = () => {
    return (
        <div>
            <ul>
                <li><NavLink to="/">Pradinis puslapis</NavLink></li>
                <li>
                    <NavLink to="/customers">Klientų sąrašas</NavLink>
                </li>
                <li>
                    <NavLink to="/inventors">Inventoriaus sąrašas</NavLink>    
                </li>
                <li>
                    <NavLink to="/reports">Ataskaitų sąrašas</NavLink>    
                </li>
                <li>
                    <NavLink to="/admin">Administravimas</NavLink>    
                </li>            
            </ul>
        </div>
    );
};

export  default NavigationComponent;