import React, { Component } from 'react';
import ProductCardComponent from './ProductCardComponent/ProductCardComponent';
import ProductListComponent from './ProductListComponent/ProductListComponent';
import TotalPriceComponent from './TotalPriceComponent/TotalPriceComponent';
//import ProductListComponent from './ProductListComponent/ProductListComponent';
        
import './App.css';      

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

var anotherProductList = productList.map(productas => (({title, price, quantity}) => ({title, price, quantity}))(productas));


//const object = { a: 5, b: 6, c: 7  };
//const picked = (({ a, c }) => ({ a, c }))(object);



//Cia yra paduodamas atfiltuotas masyvas
var filteredProductList = anotherProductList.filter(product => product.price <= 10);

//Cia paskaiciuoju atfiltruotu prekiu esancio kiekio bendra prekiu kaina (kiekis * kaina -> visu prekiu)
var totalPrice = filteredProductList.reduce((sum, product) => sum + (product.quantity * product.price), 0);
console.log(totalPrice);
                        
class App extends Component {
  render() {
    return (
      <div className="App">
        <ProductListComponent products={filteredProductList}/>
        <TotalPriceComponent totalPrice={totalPrice}/>  
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
