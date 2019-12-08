import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import App from './App'; //nebereikia, nes importuojam is interneto (https://itpro2017.herokuapp.com/api/products)
import * as serviceWorker from './serviceWorker';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { Switch, Redirect, Route } from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';
import NoMatch from './components/Navigation/NoMatch';
import NavigationComponent from './components/Navigation/NavigationComponent';
import ProductListContainer from './components/ProductList/ProductListContainer';
import ProductAdministrationContainer from './components/ProductAdministration/ProductAdministrationContainer';  

var DemonstruotiNavigacija = (props) => {
    var goHome = () => props.history.push("/");
    return (
        <div>
            At route: {props.location.pathname}
            <button onClick={goHome}>Go Home</button>
            <pre>
                {JSON.stringify(props, null, 1)}
            </pre>
        </div>
    );
};

ReactDOM.render((
    <BrowserRouter>
        <NavigationComponent>
            <Switch>
                <Route exact path='/' component={ProductListContainer} />
                <Route exact path="/products/:id" component={DemonstruotiNavigacija} />
                <Route exact path="/products" component={ProductListContainer} />
                <Route exact path="/admin/products/:id" component={ProductAdministrationContainer}/>
                <Route exact path="/admin/products/new" component={ProductAdministrationContainer}/>
                <Route exact path="/help" component={DemonstruotiNavigacija} />
                <Route path="*" component={NoMatch} />
                <Route component={NoMatch} />
            </Switch>
        </NavigationComponent>
    </BrowserRouter>
), document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
