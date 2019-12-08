import PropTypes from 'prop-types';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Switch, Redirect, Route} from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';

var AppContainer = (props) => {
  return (<div>
    <div>
      <Link to='/'>Home</Link> |&nbsp;
      <Link to='/products'>Products</Link> |&nbsp;
      <Link to={`/products/${127}`}>Products with number</Link> |&nbsp;
      <Link to='/help'>help</Link> |&nbsp;
      <Link to='/non-existant'>Non Existant</Link>
    </div>
    {props.children}
  </div>);
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
      <pre>
        {JSON.stringify(props, null, 2)}
      </pre>
    </div>
  );
};

const App = () =>
  <BrowserRouter>
    <AppContainer>
      <Switch>
        <Route exact path='/' component={Home}/>
        <Route path="/products/:id" component={DemonstruotiNavigacija} />
        <Route path="/products" component={DemonstruotiNavigacija} />
        <Route path="/help" component={DemonstruotiNavigacija} />
        <Route path="*" component={NoMatch}/>
        <Route component={NoMatch}/>
      </Switch>
    </AppContainer>
  </BrowserRouter>

class Home extends Component {
  goProducts = () => this.props.history.push("products");
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
	   <p><button onClick={this.goProducts}
		   className="btn btn-primary"
		   role="button"> Go to Products </button></p>
        </header>
      </div>
    );
  }
}

export default App;
