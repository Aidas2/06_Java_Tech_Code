import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

import {Route, BrowserRouter, Switch} from "react-router-dom";

import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import NavigationContainer from "./components/navigation/NavigationContainer";
import FooterContainer from "./components/footer/FooterContainer";

import LandingPageContainer from "./components/landingPage/LandingPageContainer";
import HolidaysComponent_byMB from "./components/holidays_byMB/HolidaysComponent_byMB"
import OneCountryContainer from "./components/countries/oneCountry/OneCountryContainer";
import PlaceContainer from "./components/places/PlaceContainer";

import AdministrationContainer from "./components/administration/AdministrationContainer"

import NewHolidayFormContainer from "./components/holidays/holidaysForms/NewHolidayFormContainer";
import NewHolidayForm_byMB from "./components/holidays_byMB/NewHolidayForm_byMB";

import NewPlaceForm from "./components/placesForms/NewPlaceForm";
import NewCountryFormContainer from "./components/countries/countriesForms/NewCountryFormContainer";

import UpdateHolidayFormContainer from "./components/holidays/holidaysForms/UpdateHolidayFormContainer";
import UpdateCountryFormContainer from "./components/countries/countriesForms/UpdateCountryFormContainer";
import UpdatePlaceForm from "./components/placesForms/UpdatePlaceForm";

import HolidaysContainer_byMB from './components/holidays_byMB/HolidaysContainer_byMB';
import UpdateHolidayForm_byMB from './components/holidays_byMB/UpdateHolidayForm_byMB';
import ListOfHolidaysContainer from './components/holidays/listOfHolidays/ListOfHolidaysContainer';
import ListOfHolidaysContainer2 from './components/holidays/listOfHolidays/ListOfHolidaysContainer2';
import OneHolidayContainer from './components/holidays/oneHoliday/OneHolidayContainer';

import LisOfCountriesContainer from './components/countries/listOfCountries/ListOfCountriesContainer';
import CountryToHolidayForm from './components/holidays/holidaysForms/CountryToHolidayForm';
import HolidayDetailsContainer from "./components/holidays/holidayDetails/HolidayDetailsContainer"

//ReactDOM.render(<App />, document.getElementById('root'));

ReactDOM.render(

    <div>
        <BrowserRouter>
            <div className="container myborders">

                <NavigationContainer />
            
                <Switch>
                <Route path = "/" exact component={LandingPageContainer} />
                {/* <Route path = "/holidays" exact component={HolidaysContainer_byMB} /> */}
                <Route path = "/holidays" exact component={ListOfHolidaysContainer} />
                {/* <Route path = "/holidays" exact component={ListOfHolidaysContainer2} /> */}
                {/* <Route path = "/holidays" exact component={OneHolidayContainer} /> */}

                <Route path = "/countries" exact component={LisOfCountriesContainer} />
                <Route path = "/places" exact component={PlaceContainer} />
                <Route path = "/admin" exact component={AdministrationContainer} /> 

                <Route path = "/admin/holidays/new" exact component={NewHolidayFormContainer} />
                {/* <Route path = "/admin/holidays/new" exact component={NewHolidayForm_byMB} /> */}

                <Route path = "/admin/countries/new" exact component={NewCountryFormContainer} />
                <Route path = "/admin/places/new" exact component={NewPlaceForm} />

                <Route path = "/admin/holidays/:title" exact component={UpdateHolidayFormContainer} /> 
                {/* <Route path = "/admin/holidays/:title" exact component={UpdateHolidayForm_byMB} />  */}
                <Route path = "/admin/countries/:title" exact component={UpdateCountryFormContainer} />
                <Route path = "/admin/places/:title" exact component={UpdatePlaceForm} />

                <Route exact path="/admin/holidays/country/:title" component={CountryToHolidayForm} />

                <Route exact path="/admin/holidayDetails/:title" component={HolidayDetailsContainer} />

                </Switch>

                <FooterContainer className="myfooter" />
            </div>
        </BrowserRouter>
    </div>,
    
    document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
