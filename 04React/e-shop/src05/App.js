import React, { Component } from 'react';
import './App.css';
import ProductListComponent from './ProductListComponent/ProductListComponent';
import huawei from './produktai_design/img/huawei.jpg';
import iphone from './produktai_design/img/iphone.jpeg';
import nokia from './produktai_design/img/nokia.jpeg';
import samsung from './produktai_design/img/samsung.jpg';
//import TotalPriceComponent from './TotalPriceComponent/TotalPriceComponent';
import Produktas from './Produktas/Produktas';
//import OneLine from './OneLineComponent/OneLineComponent';
import ProductAdministrationComponent from './ProductAdministrationComponent/ProductAdministrationComponent';

var all_products = [ 
  {
  pavadinimas: "Huawei P20",
  paveiksliukas: huawei,
  aprasymas: "An iconic square combining Leica Triple Camera and one flash inherits the Mate series’ central and simple camera design concept to create an aesthetic signature. See through the window, explore the world.",
  kaina: 5.06,
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
  kaina: 5.06,
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
  kaina: 22.25,
  kiekis: 140,
  nuoroda: "https://www.nokia.com/"
}
]
//prekiu masyvo elementus map'inti i nauja masyva, kur elementai butu newProduct(...)
var newProductList = all_products.map(element => new Produktas(element.pavadinimas, element.paveiksliukas, element.aprasymas, element.kaina, element.kiekis, element.nuoroda));
console.log("prekiu masyvo elementus map'inti i nauja masyva, kur elementai butu newProduct(...)");
console.log(newProductList);

//gauta produktu sarasa paversti i objektu aibe (set'a)
//var productSet = new Set(newProductList);
var productSet = new Set();
productSet = newProductList;
console.log("Masyvas pavestas i set'a:");
console.log(productSet);

//gauta produktu sarasa paversti i objektu zemelapi (map'a)
var productMap = new Map();
for (var i = 0; i < newProductList.length; i++) {
  productMap.set(i, newProductList[i]);
}
console.log("Masyvas paverstas i map'a");
console.log(productMap);

// is objektu map'o vel gauti masyva:
var productListFromMap = Array.from(productMap.values());
console.log("Gautas masyvas is map'o");
console.log(productListFromMap);
console.log(productListFromMap[0]);

//kuri suredukuoti iki vienos eilutes, kurioje butu prekes title ir kaina:
//product.pavadinimas, product.kaina <-- neteisingas sufleravimas
var titleAndPrice = productListFromMap.reduce((oneLine, product) => {
  console.log(oneLine);
  console.log(product);
  return oneLine + " " + product.title + " (" + product.price + " Eur"
}, "");
console.log("Suredukuota iki vienos eilutes: ");
console.log(titleAndPrice);

//cia yra paduodamas atfiltruotas masyvas
var filteredProductList = all_products.filter(produktas => produktas.kaina <= 10);
console.log(filteredProductList);

//cia paskaiciuoju atfiltruotu prekiu esancio kiekio bendra prekiu kaina (kieki * kaina -> visu prekiu)
var totalPrice = filteredProductList.reduce((sum, produktas) => {
  console.log(produktas);
  console.log(sum);
  return sum + (produktas.kiekis * produktas.kaina);
  }, 0);
console.log(totalPrice);


class App extends Component {

  goProducts = () => this.props.history.push("products");

  render() {
    return (
      <div className="App">
      <p><button onClick={this.goProducts} className="btn btn-primary" role="button">Go to Products</button></p>
        {/*<ProductAdministrationComponent/>*/}
      	<ProductListComponent products = {filteredProductList}/> 
        {/*<TotalPriceComponent totalPrice = {totalPrice}/>
        <OneLine titleAndPrice = {titleAndPrice}/>*/}
      </div>
    );
  }
}

export default App;
export {all_products};
