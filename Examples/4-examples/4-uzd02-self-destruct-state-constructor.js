//import PropTypes from 'prop-types';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {P1 as Polygon} from './Modulis/Modulis';

class SelfDestructTimerComponent extends React.Component {

  constructor (props) {
    super(props);
    this.state = {
      countdown: 3,
      intervalId: setInterval(this.countdown, 1000)
    };
  }

  componentWillUnmount() {
    clearInterval(this.state.intervalId);
  }

  countdown = () => {
    var currentCountdown = this.state.countdown;
    if (this.state.countdown > 0) {
      this.setState({ countdown: currentCountdown - 1});
    }
  }

  render() {
    var style = {};
    if (this.state.countdown < 1) {
      style.background = 'red';
    }
    return (<div style={style}>{this.state.countdown}</div>);
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
            Learn React <SelfDestructTimerComponent/>
          </a>
        </header>
      </div>
    );
  }
}

export default App;
