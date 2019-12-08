import React, { Component } from 'react';
import ProductCardComponent from './ProductCardComponent/ProductCardComponent';
import ProductListComponent from './ProductListComponent/ProductListComponent';
import TotalPriceComponent from './TotalPrice/TotalPrice';
//import ProductListComponent from './ProductListComponent/ProductListComponent';
import Produktas from './Produktas/Produktas';
import OneLine from './OneLine/OneLine';
import ProductAdministrationComponent from './ProductAdministrationComponent/ProductAdministrationComponent';
import './App.css';      

/* Pasibandymas
var newProductList = new Produktas('Smartwatch KingWear KW06', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 56.01, 10);
//var newProductList = 
console.log("Sukurtas Product objektas");
console.log(newProductList);

var productSet = new Set();
productSet.add(new Produktas('Smartwatch KingWear KW06', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 56.01, 10));
productSet.add(new Produktas('Smartwatch KingWear KW01', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 6.05, 1));
productSet.add(new Produktas('Smartwatch KingWear KW02', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 15.15, 8));
productSet.add(new Produktas('Smartwatch KingWear KW03', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 116.11, 15));
productSet.add(new Produktas('Smartwatch KingWear KW04', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 25.19, 5));
productSet.add(new Produktas('Smartwatch KingWear KW05', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 89.89, 6));
productSet.add(new Produktas('Smartwatch KingWear KW07', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 1.15, 16));
productSet.add(new Produktas('Smartwatch KingWear KW08', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 9.01, 2));
productSet.add(new Produktas('Smartwatch KingWear KW09', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 16.01, 10));
productSet.add(new Produktas('Smartwatch KingWear KW10', 'img/KingWear-KW06.jpg', 'KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch', 4.44, 3));

console.log("------------------");
console.log(productSet);
*/

var productList = [
  {
      title: "Smartwatch KingWear KW06",
      imageUrl: "img/KingWear-KW06.jpg",
      description: "KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
      price: 56.01,
      quantity: 10
  },
  {
    title: "Smartwatch KingWear KW01",
    imageUrl: "img/KingWear-KW06.jpg",
    description: "KingWear KW01 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 6.05,
    quantity: 1
},
{
  title: "Smartwatch KingWear KW02",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW02 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 15.15,
  quantity: 8
},
{
  title: "Smartwatch KingWear KW03",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW03 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 116.11,
  quantity: 15
},
{
  title: "Smartwatch KingWear KW04",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW04 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 25.19,
  quantity: 5
},
{
  title: "Smartwatch KingWear KW05",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW05 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 89.89,
  quantity: 6
},
{
  title: "Smartwatch KingWear KW07",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW07 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 1.15,
  quantity: 16
},
{
  title: "Smartwatch KingWear KW08",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW08 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 9.01,
  quantity: 2
},
{
  title: "Smartwatch KingWear KW09",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW09 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 16.01,
  quantity: 10
},
{
  title: "Smartwatch KingWear KW10",
  imageUrl: "img/KingWear-KW06.jpg",
  description: "KingWear KW10 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
  price: 4.44,
  quantity: 3
}
]

//3 uzduotis. Sumapinti i nauja masyva su NEW PRODUKTAS

//Sumapinu i nauja masyva
var newProductList = productList.map(element => new Produktas(element.title, element.imageUrl, element.description, element.price, element.quantity));
console.log("-----Kas pavyko----------");
console.log(newProductList);

//gauta masyva paverciu i Set'a
var productSet = new Set(newProductList);
//productSet = newProductList;
console.log("Masyvas paverstas i SET'a");
console.log(productSet instanceof Set);
console.log(productSet);

//pries tai gauta masyva dar papildomai sudedu i Mapa'a
var productMap = new Map();
for (var i = 0; i < newProductList.length; i++){
  productMap.set(i, newProductList[i]);
}
console.log("Masyvas paverstas i MAP'a");
console.log(productMap);

//is MAP'o padarau masyva ir redukuoju iki vienos eilutes, kurioje yra prekiu pavadinimai ir kainos
var productListFromMap = Array.from(productMap.values());
console.log("Gautas masyvas is MAPo");
console.log(productListFromMap);
console.log(productListFromMap[0]);

var titleAndPrice = productListFromMap.reduce((oneLine, product, index) => oneLine + (index > 0 ? ", ": "") + product.title + " (" + product.price + " Eur.)", "");
console.log("Viena eilute");
console.log(titleAndPrice);


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
  render() {
    return (
      <div className="App">
        <ProductAdministrationComponent/>
        <ProductListComponent products={filteredProductList}/>
        <TotalPriceComponent totalPrice={totalPrice}/> 
        <OneLine titleAndPrice = {titleAndPrice}/>
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
