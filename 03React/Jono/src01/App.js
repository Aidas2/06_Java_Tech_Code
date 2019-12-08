import React, { Component } from 'react';
import ProductCardComponent from './ProductCardComponent/ProductCardComponent';
import ProductListComponent from './ProductListComponent/ProductListComponent';
//import ProductListComponent from './ProductListComponent/ProductListComponent';
        
import './App.css';      

var productList = [
  {
      productId: 1,
      productName: "Smartwatch KingWear KW06",
      productImage: "img/KingWear-KW06.jpg",
      productDescription: "KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
      productPrice: 56.01
  },
  {
      productId: 2,
      productName: "Smartwatch KingWear KW08",
      productImage: "img/KingWear-KW06.jpg",
      productDescription: "KingWear KW08 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
      productPrice: 76.09
  },
  {
      productId: 3,
      productName: "Smartwatch KingWear KW10",
      productImage: "img/KingWear-KW06.jpg",
      productDescription: "KingWear KW10 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
      productPrice: 106.99
  },
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


class App extends Component {
  render() {
    return (
      <div className="App">
        <ProductListComponent products={productList}/>
      </div>
    );
  }
}

/*
Cia tik viena preke ikeliu ir veike
class App extends Component {
  render() {
    return (
      <div className="App">
        <ProductCardComponent
            productId={productList[0].productId}
            productName={productList[0].productName}
            productImage={productList[0].productImage}
            productDescription={productList[0].productDescription}
            productPrice={productList[0].productPrice}
            />
      </div>
    );
  }
}
*/

export default App;
