import React, { Component } from 'react';
//import ProductCardComponent from './ProductCardComponent/ProductCardComponent';
import ProductListComponent from './ProductListComponent/ProductListComponent';
//import TotalPriceComponent from './TotalPrice/TotalPrice';
//import ProductListComponent from './ProductListComponent/ProductListComponent';
import Produktas from './Produktas/Produktas';
//import OneLine from './OneLine/OneLine';
//import ProductAdministrationComponent from './ProductAdministrationComponent/ProductAdministrationComponent';
import './App.css';
import ServicesContext from './ServicesContext';


var productList = [
  {
    id: 6,
    title: "Smartwatch KingWear KW06",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 56.01,
    quantity: 10
  },
  {
    id: 1,
    title: "Smartwatch KingWear KW01",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW01 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 6.05,
    quantity: 1
  },
  {
    id: 2,
    title: "Smartwatch KingWear KW02",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW02 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 15.15,
    quantity: 8
  },
  {
    id: 3,
    title: "Smartwatch KingWear KW03",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW03 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 116.11,
    quantity: 15
  },
  {
    id: 4,
    title: "Smartwatch KingWear KW04",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW04 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 25.19,
    quantity: 5
  },
  {
    id: 5,
    title: "Smartwatch KingWear KW05",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW05 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 89.89,
    quantity: 6
  },
  {
    id: 7,
    title: "Smartwatch KingWear KW07",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW07 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 1.15,
    quantity: 16
  },
  {
    id: 8,
    title: "Smartwatch KingWear KW08",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW08 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 9.01,
    quantity: 2
  },
  {
    id: 9,
    title: "Smartwatch KingWear KW09",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW09 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 16.01,
    quantity: 10
  },
  {
    id: 10,
    title: "Smartwatch KingWear KW10",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW10 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 4.44,
    quantity: 3
  }
]



/*
class MyProvider extends Component {
  render() {
    return (
      <ServicesContext.Provider value="Jonas">
        {this.props.children}
      </ServicesContext.Provider>)
  }
}
*/
//3 uzduotis. Sumapinti i nauja masyva su NEW PRODUKTAS

//Sumapinu i nauja masyva
var newProductList = productList.map(element => new Produktas(element.title, element.imageUrl, element.description, element.price, element.quantity));
//console.log("-----Kas pavyko----------");
//console.log(newProductList);

//gauta masyva paverciu i Set'a
var productSet = new Set(newProductList);
//productSet = newProductList;
//console.log("Masyvas paverstas i SET'a");
//console.log(productSet instanceof Set);
//console.log(productSet);

//pries tai gauta masyva dar papildomai sudedu i Mapa'a
var productMap = new Map();
for (var i = 0; i < newProductList.length; i++) {
  productMap.set(i, newProductList[i]);
}
//console.log("Masyvas paverstas i MAP'a");
//console.log(productMap);

//is MAP'o padarau masyva ir redukuoju iki vienos eilutes, kurioje yra prekiu pavadinimai ir kainos
var productListFromMap = Array.from(productMap.values());
//console.log("Gautas masyvas is MAPo");
//console.log(productListFromMap);
//console.log(productListFromMap[0]);

var titleAndPrice = productListFromMap.reduce((oneLine, product, index) => oneLine + (index > 0 ? ", " : "") + product.title + " (" + product.price + " Eur.)", "");
//console.log("Viena eilute");
//console.log(titleAndPrice);


//testine
/*
class App extends Component {
  render() {
    return (
      <div className="App">
        testas
      </div>
    );
  }
}
*/

//Cia yra paduodamas atfiltuotas masyvas
var filteredProductList = productList.filter(product => product.price <= 10);

//Cia paskaiciuoju atfiltruotu prekiu esancio kiekio bendra prekiu kaina (kiekis * kaina -> visu prekiu)
var totalPrice = filteredProductList.reduce((sum, product) => sum + (product.quantity * product.price), 0);
//console.log(totalPrice);

class App extends Component {

  goProducts = () => this.props.history.push("products");

  render() {
    return (


      <div className="App">
        <p><button onClick={this.goProducts} className="btn btn-primary" role="button">Go to Products</button></p>
        {/*<ProductAdministrationComponent/>*/}

         <ServicesContext.Provider value={"mano reiksme"}>   
        

          <ProductListComponent products={filteredProductList} />

        </ServicesContext.Provider>


        {/*<TotalPriceComponent totalPrice={totalPrice}/> 
        <OneLine titleAndPrice = {titleAndPrice}/>*/}
      </div>

    );
  }
}

//Cia yra paduodamas visas produktu masyvas
/*
class App extends Component {
  render() {
    return (
      <div className="App">
        <ProductListComponent products={productList}/>
      </div>
    );
  }
}
*/


export default App;
export {ServicesContext};
