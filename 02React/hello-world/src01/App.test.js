import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
//importinam (02 skaidre 65 psl.)
import Polygon from './Modulis/Modulis';

//idedam testa (02 skaidre 65 psl.)
it('calculates area correctly', () => {
expect(new Polygon().calcArea()).toEqual(6);
});

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<App />, div);
  ReactDOM.unmountComponentAtNode(div);
});
