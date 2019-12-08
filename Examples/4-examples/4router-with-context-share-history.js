import PropTypes from 'prop-types';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Switch, Redirect, Route} from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';
import { Router } from "react-router";
import { createBrowserHistory } from "history";

// example

const HistoryContext = React.createContext(null);

var AppContainer = (props) => {
  return (<div>
    <div>
      <Link to='/'>Home</Link> |&nbsp;
      <Link to='/products'>Products</Link> |&nbsp;
      <Link to={`/products/${127}`}>Products with number</Link> |&nbsp;
      <Link to='/help'>help</Link> |&nbsp;
      <Link to='/non-existant'>Non Existant</Link>
      <HistoryContext.Consumer>
          {({userService}) => <span>{userService.name}</span>}
      </HistoryContext.Consumer>
    </div>
    {props.children}
  </div>)
};

var NoMatch = (props) => {
    var goHome = () => props.history.push("/");
    return <div>Route did not match <button onClick={goHome}>Go Home</button></div>;
};

var DemonstruotiNavigacija = (props) => {
  var goHome = () => props.history.push("/");
  return (
    <div>
      At route: {props.location.pathname} 
      <button onClick={goHome}>Go Home</button>
      <HistoryContext.Consumer>
        {({userService}) => <button onClick={() => userService.name = "user1"}>Set user (login) to user1</button>}
      </HistoryContext.Consumer>
      <pre>
        {JSON.stringify(props, null, 2)}
      </pre>
    </div>
  );
};



const DemonstruotiNavigacijaC = (props, context) => {
  var goHome = () => props.history.push("/");
  return (
    <div>
      At route: {props.location.pathname} 
      <button onClick={goHome}>Go Home</button>
        <HistoryContext.Consumer>
          {({userService}) => <div>{userService.name}</div>}
        </HistoryContext.Consumer>
      <HistoryContext.Consumer>
          {({history}) => <button onClick={() => history.push("/")}>Go Home (history context)</button>}
      </HistoryContext.Consumer>
      <pre>
        {JSON.stringify(props, null, 2)}<br/>
        Logged user:
        <HistoryContext.Consumer>
          {({userService}) => <div>{userService.name}</div>}
        </HistoryContext.Consumer>
      </pre>
    </div>
  );
};

var pass;
//var userService = {name: "user is not set yet"};
class UserService {
  constructor() {
    this._name = "anonymous"
  }
  get name() {
    return this._name
  }
  set name(name) {
    this._name = name
  }
}
var userService = new UserService()
const App = (props) => {
  const history = createBrowserHistory(props);
  // {/*<BrowserRouter ref={(browserRouter) => {pass = browserRouter.history;}}>*/}
  // {/*</BrowserRouter>*/})
  return (<Router history={history}>
    <HistoryContext.Provider value={{userService: userService, history: history}}>
      <AppContainer>
        <Switch>
          <Route exact path='/' component={Home}/>
          <Route path="/products/:id" component={DemonstruotiNavigacija} />
          <Route path="/products" component={DemonstruotiNavigacija} />
          <Route path="/help" component={DemonstruotiNavigacijaC} />
          <Route path="*" component={NoMatch}/>
          <Route component={NoMatch}/>
        </Switch>
      </AppContainer>
    </HistoryContext.Provider>
  </Router>)
}

class Home extends Component {
  goProducts = () => this.props.history.push("products");
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
	   <p><button onClick={this.goProducts}
		   className="btn btn-primary"> Go to Products </button></p>
        </header>
      </div>
    );
  }
}

export default App;
