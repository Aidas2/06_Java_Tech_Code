import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
//importinam (02 skaidre, 64 psl.)
import Polygon from './Modulis/Modulis';
//importinam (02 skaidre 66 psl.)
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
//importinam (03 skaidre, 2 psl.)
import PropTypes from 'prop-types';


//(02 skaidre, 64 psl.; 2 variantas)
console.log('Staciakampio (index failas) plotas yra: ' + new Polygon().calcArea());

ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
