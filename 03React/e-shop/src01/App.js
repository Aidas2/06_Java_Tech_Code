import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ProductListComponent from './Produktai/ProductListComponent';
import huawei from './produktai_design/img/huawei.jpg';
import iphone from './produktai_design/img/iphone.jpeg';
import nokia from './produktai_design/img/nokia.jpeg';
import samsung from './produktai_design/img/samsung.jpg';

const all_products = [ 
  {
  pavadinimas: "Huawei P20",
  paveiksliukas: huawei,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 950.06,
  nuoroda: "https://www.huawei.com/en/"
},
{
  pavadinimas: "IPhone 10",
  paveiksliukas: iphone,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 1950.06,
  nuoroda: "https://www.apple.com/lae/iphone/"
},
{
  pavadinimas: "Samsung S9",
  paveiksliukas: samsung,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 680.50,
  nuoroda: "https://www.samsung.com/en/"
},
{
  pavadinimas: "Nokia 3310",
  paveiksliukas: nokia,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 50.26,
  nuoroda: "https://www.nokia.com/"
},
{
  pavadinimas: "Nokia 3320",
  paveiksliukas: nokia,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 22.25,
  nuoroda: "https://www.nokia.com/"
}
]

class App extends Component {
  render() {
    return (
      <div className="App">
      <ProductListComponent products = {all_products}/>
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
        </header>
      </div>
    );
  }
}

export default App;
