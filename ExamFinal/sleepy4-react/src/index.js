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
import OneCountryContainer from "./components/countries/oneCountry/OneCountryContainer";
import PlaceContainer from "./components/places/PlaceContainer";

import AdministrationContainer from "./components/administration/AdministrationContainer"

import NewCustomerFormContainer from "./components/holidays/customersForms/NewCustomerFormContainer";

import NewPlaceForm from "./components/placesForms/NewPlaceForm";
import NewCountryFormContainer from "./components/countries/countriesForms/NewCountryFormContainer";

import UpdateHolidayFormContainer from "./components/holidays/customersForms/UpdateHolidayFormContainer";
import UpdateCountryFormContainer from "./components/countries/countriesForms/UpdateCountryFormContainer";
import UpdatePlaceForm from "./components/placesForms/UpdatePlaceForm";

import ListOfCustomersContainer from './components/holidays/listOfCustomers/ListOfCustomersContainer';
import OneCustomerContainer from './components/holidays/oneCustomer/OneCustomerContainer';

import LisOfInventorsContainer from './components/countries/listOfCountries/ListOfInventorsContainer';
import InventorToCustomerForm from './components/holidays/customersForms/InventorToCustomerForm';
import HolidayDetailsContainer from "./components/holidays/holidayDetails/HolidayDetailsContainer"

//ReactDOM.render(<App />, document.getElementById('root'));

ReactDOM.render(

    <div>
        <BrowserRouter>
            <div className="container myborders">

                <NavigationContainer />
            
                <Switch>
                <Route path = "/" exact component={LandingPageContainer} />
                <Route path = "/customers" exact component={ListOfCustomersContainer} />
                {/* <Route path = "/customers" exact component={OneCustomerContainer} /> */}

                <Route path = "/inventors" exact component={LisOfInventorsContainer} />
                <Route path = "/reports" exact component={PlaceContainer} />
                <Route path = "/admin" exact component={AdministrationContainer} /> 

                <Route path = "/admin/customers/new" exact component={NewCustomerFormContainer} />

                <Route path = "/admin/inventors/new" exact component={NewCountryFormContainer} />
                <Route path = "/admin/raports/new" exact component={NewPlaceForm} />

                <Route path = "/admin/customers/:name" exact component={UpdateHolidayFormContainer} /> 
                <Route path = "/admin/inventors/:title" exact component={UpdateCountryFormContainer} />
                <Route path = "/admin/reports/:title" exact component={UpdatePlaceForm} />

                <Route exact path="/admin/customers/inventor/:title" component={InventorToCustomerForm} />

                <Route exact path="/admin/customerDetails/:title" component={HolidayDetailsContainer} />

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
