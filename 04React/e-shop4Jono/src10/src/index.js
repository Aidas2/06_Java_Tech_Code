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
import ProductListContainer from './components/ProductList/ProductListContainer';
import NewProductContainer from './components/ProductAdministration/NewProductContainer';
import UserContext from './UserContext';
import ProductAdministrationListContainer from './components/ProductAdministration/ProductAdministrationListContainer';
import EditProductContainer from './components/ProductAdministration/EditProductContainer';
import OneProductContainer from './components/ProductList/OneProductContainer';
import ShoppingCartContainer from './components/ShoppingCart/ShoppingCartContainer';

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
        <UserContext.Provider value={"User: Jonas"}>
            <NavigationComponent>
                <Switch>
                    <Route exact path='/' component={ProductListContainer} />
                    <Route exact path="/products/:id" component={OneProductContainer} />
                    <Route exact path='/admin' component={ProductAdministrationListContainer} />
                    
                    {/* Cia anciau ejo i naujo produkto ivedima
                    <Route exact path='/admin' component={NewProductContainer} />
                    */}
                    
                    <Route exact path="/admin/products/new" component={NewProductContainer} />       
                    <Route exact path="/admin/products/:id" component={EditProductContainer} />   

                    <Route exact path="/shoppingCart" component={ShoppingCartContainer} />                              
                    

                    {/*
                    <Route exact path="/products" component={ProductListContainer} />
                    <Route exact path="/admin/products/:id" component={ProductAdministrationContainer} />
                    <Route exact path="/admin/products/new" component={ProductAdministrationContainer} />
                    <Route exact path="/help" component={DemonstruotiNavigacija} />
                    */}

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
