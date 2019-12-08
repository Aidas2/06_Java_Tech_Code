import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
//importinam (02 skaidre, 64 psl.)
import Polygon from './Modulis/Modulis';
//importinam (03 skaidre, 2 psl.)
import PropTypes from 'prop-types';


// parasom objekta ir pritaikom metoda (02 skaidre, 64 psl.; 1 variantas):
var polygon = new Polygon();
var plotas = polygon.calcArea();
console.log('Staciakampio plotas yra: ' + plotas);
//((02 skaidre, 64 psl.; 2 variantas)
console.log('Staciakampio plotas yra: ' + new Polygon().calcArea());

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          {/* ikeliam mygtuka (02 skaidre 66 psl.) */}
	<p><button className="btn btn-primary" role="button">Reload MYGTUKAS</button></p>
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
