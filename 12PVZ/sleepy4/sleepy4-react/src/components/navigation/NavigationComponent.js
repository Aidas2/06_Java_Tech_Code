import React from "react";
import {NavLink} from "react-router-dom";
import "./NavigationComponent.css";

const NavigationComponent = () => {
    return (
        <div>
            <ul>
                <li><NavLink to="/">Pradinis puslapis</NavLink></li>
                <li>
                    <NavLink to="/holidays">Svenciu sarasas</NavLink>
                </li>
                <li>
                    <NavLink to="/countries">Saliu sarasas</NavLink>    
                </li>
                <li>
                    <NavLink to="/places">Vietoviu sarasas</NavLink>    
                </li>
                <li>
                    <NavLink to="/admin">Administravimas</NavLink>    
                </li>            
            </ul>
        </div>
    );
};

export  default NavigationComponent;