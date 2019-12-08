import React from "react";
import {Route, BrowserRouter, Switch} from "react-router-dom";

import Navigation from "./Navigation";
import HolidayContainer from "../holidays/HolidayContainer";
import CountryContainer from "../countries/CountryContainer";
import NewHolidayForm from "../Forms/NewHolidayForm";
import LandingPage from "../LandingPage";

const NavigationContainer = () => {
return (
<div>
    <BrowserRouter>
        <div>
            <Navigation />
            <Switch>
                <Route path ="/holidays" exact component={HolidayContainer} />
                <Route path = "/countries" exact component={CountryContainer} />
                <Route path = "/admin" exact component={NewHolidayForm} />
                <Route path ="/" exact component={LandingPage} />
            </Switch>
        </div>
    </BrowserRouter>
</div>
);
};

export default NavigationContainer;