import React, { Component } from 'react';
import './App.css';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { Switch, Redirect, Route } from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';
import NoMatch from './components/Navigation/NoMatch';
import NavigationContainer from './components/Navigation/NavigationContainer';
import HolidayListContainer from './components/HolidayList/HolidayListContainer';
import CountryAdministrationContainer from './components/CountryAdministration/CountryAdministrationListContainer';
import NewHolidayContainer from './components/HolidayAdministration/NewHolidayContainer';
//import UserContext from './UserContext';
import HolidayAdministrationListContainer from './components/HolidayAdministration/HolidayAdministrationListContainer';
import EditHolidayContainer from './components/HolidayAdministration/EditHolidayContainer';
import OneHolidayContainer from './components/HolidayList/OneHolidayContainer';
import NewCountryContainer from './components/CountryAdministration/NewCountryContainer';
import EditCountryContainer from './components/CountryAdministration/EditCountryContainer';
import Pasimokyti from './Pasimokyti';
import OneCountryContainer from './components/CountryList/OneCountryContainer';
import { getCurrentUser } from './util/APIUtils';
import { ACCESS_TOKEN } from './constants';

import Login from './user/login/Login';
import Signup from './user/signup/Signup';
import Profile from './user/profile/Profile';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      currentUser: null,
      isAuthenticated: false,
      isLoading: false
    }
    //this.handleLogout = this.handleLogout.bind(this);
    this.loadCurrentUser = this.loadCurrentUser.bind(this);
    //this.handleLogin = this.handleLogin.bind(this);
  }

  DemonstruotiNavigacija = (props) => {
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

  loadCurrentUser() {
    this.setState({
      isLoading: true
    });
    getCurrentUser()
    .then(response => {
      this.setState({
        currentUser: response,
        isAuthenticated: true,
        isLoading: false
      });
    }).catch(error => {
      this.setState({
        isLoading: false
      });  
    });
  }

  handleLogout(redirectTo="/", notificationType="success", description="You're successfully logged out.") {
    localStorage.removeItem(ACCESS_TOKEN);

    this.setState({
      currentUser: null,
      isAuthenticated: false
    });

    this.props.history.push(redirectTo);
    
    // notification[notificationType]({
    //   message: 'Polling App',
    //   description: description,
    // });
  }

  handleLogin() {
    // notification.success({
    //   message: 'Polling App',
    //   description: "You're successfully logged in.",
    // });
    this.loadCurrentUser();
    this.props.history.push("/");
  }

  componentDidMount() {
    this.loadCurrentUser();
  }

  render() {
    return (
      <BrowserRouter>
        <div className="app-container">
          <NavigationContainer></NavigationContainer>
          <div className="app-content">
            <div className="container">
            <Switch>
              <Route exact path='/' component={HolidayListContainer} />
              <Route exact path="/holidays/:code" component={OneHolidayContainer} />
              <Route exact path='/admin' component={HolidayAdministrationListContainer} />
              <Route exact path='/admin/country' component={CountryAdministrationContainer} />
              {/* <Route exact path='/pasimokyti' component={Pasimokyti} />           */}
              <Route exact path="/admin/holidays/new" component={NewHolidayContainer} />
              <Route exact path="/admin/holidays/:code" component={EditHolidayContainer} />
              <Route exact path="/admin/countries/new" component={NewCountryContainer} />
              <Route exact path="/admin/countries/:countryCode" component={EditCountryContainer} />
              <Route exact path="/countries/:countryCode" component={OneCountryContainer} />
              {/* <Route exact path="/shopping-Cart/:user" component={ShoppingCartContainer} />                                */}
              <Route path="/login" 
                  render={(props) => <Login onLogin={this.handleLogin} {...props} />}></Route>
                <Route path="/signup" component={Signup}></Route>
                <Route path="/users/:username" 
                  render={(props) => <Profile isAuthenticated={this.state.isAuthenticated} currentUser={this.state.currentUser} {...props}  />}>
                </Route>
              <Route path="*" component={NoMatch} />
              <Route component={NoMatch} />
            </Switch>
            </div>        
          </div>
        </div>     
      </BrowserRouter>
    );
  }
}

export default App;
