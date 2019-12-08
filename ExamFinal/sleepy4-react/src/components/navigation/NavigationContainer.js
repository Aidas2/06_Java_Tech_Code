import React from "react";
import {Route, BrowserRouter, Switch} from "react-router-dom";
import NavigationComponent from "./NavigationComponent";
import "./NavigationComponent.css";

const NavigationContainer = () => {
    return (
        <div>
            <NavigationComponent class="myborders"/>
        </div>
    );
};

export default NavigationContainer;