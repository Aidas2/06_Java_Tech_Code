//import PropTypes from 'prop-types';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {P1 as Polygon} from './Modulis/Modulis';

console.log(new Polygon().calcArea());

class IncreasingButtonComponent extends Component {
  constructor() { super(); this.state = { count: 0 }; }
  handleClick = (event) => {
    //event.preventDefault();
    event.stopPropagation();
    this.setState({ count: this.state.count + 1});
  }
  render() {
    return (
      <div>
        {this.state.count} &nbsp;
        <button className="btn btn-default"
          onClick={this.handleClick}>Increase</button>
      </div>
    );
  }
}

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React <IncreasingButtonComponent/>
          </a>
        </header>
      </div>
    );
  }
}

export default App;
