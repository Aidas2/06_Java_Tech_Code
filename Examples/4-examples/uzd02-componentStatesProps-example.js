import PropTypes from 'prop-types';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';


function rand(arr) {
  return arr[Math.floor(Math.random() * arr.length)];
}

class ADayInTheLife extends Component {
  state = {
    doing: "isCoding"
  }
  
  handleButtonClick = () => {
    var activities = ["isCoding", "isEating", "isSleeping"];
    var randAct = rand(activities);
    this.setState({
      doing: randAct
    });
  }

  render() {
    return (
      <div>
        <button onClick={this.handleButtonClick}>Next Activity</button>
        <Jake activity={this.state.doing} />
      </div>
    );
  }
  
};

class Jake extends Component {
  state = { 
    thinking: "nothingYet"
  }
  
  static getDerivedStateFromProps(nextProps, prevState) {
    var thoughts = {
      isCoding: "yay, code",
      isEating: "yum, code",
      isSleeping: "where's the code?"
    };
    return { thinking: thoughts[nextProps.activity] };
  }

  render() {
    return <div>Jake: <b>{this.props.activity}</b> and thinking "{this.state.thinking}".</div>;
  }
};

Jake.defaultProps = {
  activity: "nothingYet"
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
            Learn React 
          </a>
	<ADayInTheLife/>
        </header>
      </div>
    );
  }
}

export default App;
