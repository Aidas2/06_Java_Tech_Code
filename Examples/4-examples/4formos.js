import PropTypes from 'prop-types';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class NameForm extends Component {
  constructor() { super(); this.state = { value: ''}; }
  handleChange = (event) => this.setState({value: event.target.value});
  handleSubmit = (event) => {
    this.setState({value: 'reset after submit'});
    event.preventDefault();
  }
  render() {
    return (<form onSubmit={this.handleSubmit}>
         Name ({this.state.value}):<br/>
         <input type="text" value={this.state.value}
             onChange={this.handleChange} />
         <input type="submit" value="Submit" />
    </form>);
  }
}

var Komponentas = (props) => { // arba ({atributas, kitas}) => {
  var {atributas, kitas} = props; // destructuring assignment
  return (<div>{atributas} {kitas}</div>);
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
          <NameForm/>
          <Komponentas atributas="reiksme" kitas="nieko"/>
        </header>
      </div>
    );
  }
}

export default App;
