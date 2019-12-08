import React, { Component } from 'react';
//import logo from './logo.svg';
import './App.css';
import ProductListComponent from './Produktai/ProductListComponent';
import huawei from './produktai_design/img/huawei.jpg';
import iphone from './produktai_design/img/iphone.jpeg';
import nokia from './produktai_design/img/nokia.jpeg';
import samsung from './produktai_design/img/samsung.jpg';
import TotalPriceComponent from './Produktai/TotalPriceComponent';

const all_products = [ 
  {
  pavadinimas: "Huawei P20",
  paveiksliukas: huawei,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 50.06,
  kiekis: 10,
  nuoroda: "https://www.huawei.com/en/"
},
{
  pavadinimas: "IPhone 10",
  paveiksliukas: iphone,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 90.20,
  kiekis: 18,
  nuoroda: "https://www.apple.com/lae/iphone/"
},
{
  pavadinimas: "Samsung S9",
  paveiksliukas: samsung,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 30.50,
  kiekis: 15,
  nuoroda: "https://www.samsung.com/en/"
},
{
  pavadinimas: "Nokia 3310",
  paveiksliukas: nokia,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 5.26,
  kiekis: 100,
  nuoroda: "https://www.nokia.com/"
},
{
  pavadinimas: "Nokia 3320",
  paveiksliukas: nokia,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 6.25,
  kiekis: 140,
  nuoroda: "https://www.nokia.com/"
},
{
  pavadinimas: "Huawei P10",
  paveiksliukas: huawei,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 40.06,
  kiekis: 10,
  nuoroda: "https://www.huawei.com/en/"
},
{
  pavadinimas: "IPhone 9",
  paveiksliukas: iphone,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 85.06,
  kiekis: 18,
  nuoroda: "https://www.apple.com/lae/iphone/"
},
{
  pavadinimas: "Samsung S8",
  paveiksliukas: samsung,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 9.99,
  kiekis: 15,
  nuoroda: "https://www.samsung.com/en/"
},
{
  pavadinimas: "Nokia 3302",
  paveiksliukas: nokia,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 4.02,
  kiekis: 100,
  nuoroda: "https://www.nokia.com/"
},
{
  pavadinimas: "Nokia 3340",
  paveiksliukas: nokia,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 2.25,
  kiekis: 140,
  nuoroda: "https://www.nokia.com/"
}
]
//sukuriam vaizdini be imageUrl ir be description
//masyva su objektais mapinam
var anotherProductList = all_products.map(produktas => (({pavadinimas, kaina, kiekis}) => ({pavadinimas, kaina, kiekis}))(produktas));
console.log(anotherProductList);

//var anotherProductList2 = all_products.map(produktas => produktas); //variantas kai paduoamos ir grazinamos visos savybes
//console.log(anotherProductList2);

//cia yra paduodamas atfiltruotas masyvas
var filteredProductList = anotherProductList.filter(produktas => produktas.kaina <= 10);
console.log(filteredProductList);

//cia paskaiciuoju atfiltruotu prekiu esancio kiekio bendra prekiu kaina (kieki * kaina -> visu prekiu)
var totalPrice = filteredProductList.reduce((sum, produktas) => sum + (produktas.kiekis * produktas.kaina), 0);
console.log(totalPrice);

class App extends Component {
  render() {
    return (
      <div className="App">
      	<h1>Pradinis sarasas:</h1>
      	<ProductListComponent products = {all_products}/>
      	<h1>Atfiltruotas sarasas:</h1>
      	<ProductListComponent products = {filteredProductList}/>
      	<TotalPriceComponent totalPrice = {totalPrice}/>
      </div>
    );
  }
}

export default App;
