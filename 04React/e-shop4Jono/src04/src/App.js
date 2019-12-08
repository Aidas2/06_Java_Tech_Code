import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import SelfDestructTimerComponent from './SelfDestructTimerComponent/SelfDestructTimerComponent';

class App extends Component {
  
  
  
  
  
  onMouseOver = (event) =>{
    console.log(event.target);
    event.target.className ="App-logo";
  }

  onMouseOut = (event) =>{
    console.log(event.target);
    event.target.className ="";
  }

  onClick = (event) =>{
    console.log(event.target);
    event.target.style.height = "250px";
  }
  
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} style={{height : 140}} className="" alt="logo" onMouseOver={this.onMouseOver} onMouseOut={this.onMouseOut}
                                                                          onClick={this.onClick}  />
          <p><button className="btn btn-primary" role="button">Reload</button></p>
          <SelfDestructTimerComponent/>
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
        </header>
      </div>
    );
  }
}

export default App;
