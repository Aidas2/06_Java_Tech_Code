import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import App from './App';
import * as serviceWorker from './serviceWorker';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { Switch, Redirect, Route } from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';
import NoMatch from './components/Navigation/NoMatch';
import NavigationComponent from './components/Navigation/NavigationComponent';
import CountryListContainer from './components/CountryList/CountryListContainer';
import CountryAdministrationContainer from './components/CountryAdministration/CountryAdministrationContainer';
import UserContext from './UserContext';

var DemonstruotiNavigacija = (props) => {
    var goHome = () => props.history.push("/");
    return (
        <div>          
            At route: {props.location.pathname}
            <button onClick={goHome}>Go Home</button>
            <pre>             
                {JSON.stringify(props, null, 1)}
                {/*{JSON.stringify(props, null, 2)}*/}
            </pre>
        </div>
    );
};


ReactDOM.render((
    <BrowserRouter>
        <UserContext.Provider value={"User: sleepy"}>
            <NavigationComponent>
                <Switch>
                    <Route exact path='/' component={CountryListContainer} />
                    <Route exact path="/countrys/:id" component={DemonstruotiNavigacija} />
                    <Route exact path="/countrys" component={CountryListContainer} />
                    <Route exact path="/admin/countrys/:id" component={CountryAdministrationContainer} />
                    <Route exact path="/admin/countrys/new" component={CountryAdministrationContainer} />
                    <Route exact path="/help" component={DemonstruotiNavigacija} />
                    <Route path="*" component={NoMatch} />
                    <Route component={NoMatch} />
                </Switch>
            </NavigationComponent>
        </UserContext.Provider>
    </BrowserRouter>
), document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
