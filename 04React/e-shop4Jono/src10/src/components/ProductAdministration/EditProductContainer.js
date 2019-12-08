import React from 'react';
import EditProductComponent from './EditProductComponent';
//import {productList} from '../App';
import axios from 'axios';
import { withRouter } from 'react-router';

/* nieko neduoda
import createHistory from 'history/createBrowserHistory';
const myHistory = createHistory()
*/



class EditProductContainer extends React.Component {
  constructor(props) {
    super(props);

    //var pathnameArray = this.props.history.location.pathname.split('/');
    //var number = pathnameArray[pathnameArray.length - 1];
    //console.log(this.props);      //Cia atspausdina props objeta, kuriame masosi history.path
    //console.log(this.props.path); //Bet cia path jau yra undefined
    //console.log(window.location.href);


    this.state = {
      id: 0,
      title: "",
      image: "",
      description: "",
      price: 0,
      quantity: 0
    };
    //var fromMenu;
  }

  componentDidMount() {
    
    //console.log(this.props.history.path);
    //Issiskaiciuoju prekes koda
    var pathnameArray = window.location.href.split('/');
    var position = pathnameArray[pathnameArray.length - 1];
    console.log("Koks kelias gaunasi?");
    console.log('https://itpro2017.herokuapp.com/api/products/' + (position))


    axios.get('https://itpro2017.herokuapp.com/api/products/' + (position))
      .then((response) => {
        
        this.setState( response.data );
        console.log("Atspausdintu nuskaitytus duomenis");
        console.log(response.data);
        console.log("Atspausdinu state");
        console.log(this.state);
        //console.log("Produktai yra - " + this.state.products);
        //this.selectedProduct(this.state.products);
      })
      .catch((error) => {
        console.log(error);
      });
  


  }

  selectedProduct = (gotListOfProducts) => {
      console.log("Ar spausdina cia " + this.props.history);
      console.log("Ar spausdina cia " + this.props.history.location.path);
            
      //Cia as suteikiu state konkretaus produkto duomenis
      //TIK BEDA, KAD NEZINAU KAIP PAIMTI IS HISTORY REALU PRODUKTO ID
      var pathnameArray = window.location.href.split('/');
      var position = pathnameArray[pathnameArray.length - 1] - 1;
      this.setState({title: gotListOfProducts[position].title});
      this.setState({image: gotListOfProducts[position].image});
      this.setState({description: gotListOfProducts[position].description});
      this.setState({price: gotListOfProducts[position].price});
      this.setState({quantity: gotListOfProducts[position].quantity});

  }


  handleChangeOfTitle = (event) => {
    this.setState({ title: event.target.value });
    console.log(this.state.title);
  }

  handleChangeOfImageUrl = (event) => {
    this.setState({ image: event.target.value });
  }

  handleChangeOfDescription = (event) => {
    this.setState({ description: event.target.value });
  }

  handleChangeOfPrice = (event) => {
    this.setState({ price: event.target.value });
  }

  handleChangeOfQuantity = (event) => {
    this.setState({ quantity: event.target.value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
    console.log("Koks kelias atspausdintas?");
    console.log('https://itpro2017.herokuapp.com/api/products/' + (this.state.id));
    axios.put('https://itpro2017.herokuapp.com/api/products/'+(this.state.id), this.state)
    
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });

  }

    render() {
    /*if (this.props.history.location.pathname === "/admin/products/new") {
      this.fromMenu = "Kuriamas naujas produktas";
    } else {
      var pathnameArray = this.props.history.location.pathname.split('/');
      if (pathnameArray[1] === "admin" && pathnameArray[2] === "products") {
        var number = pathnameArray[pathnameArray.length - 1];
        //console.log("Istrauktas numeris yra " + number);
        this.fromMenu = "Atnaujinamas produktas id: " + number;
      }
    }*/
    this.fromMenu = "Atnaujinamas produktas:"
    //console.log(this.props.history);

    return (
      <EditProductComponent handleChangeOfTitle={this.handleChangeOfTitle}
        handleChangeOfImageUrl={this.handleChangeOfImageUrl}
        handleChangeOfDescription={this.handleChangeOfDescription}
        handleChangeOfPrice={this.handleChangeOfPrice}
        handleChangeOfQuantity={this.handleChangeOfQuantity}
        handleSubmit={this.handleSubmit}
        fromMenu={this.fromMenu}
        currentTitle={this.state.title}
        currentImage={this.state.image}
        currentDescription={this.state.description}
        currentPrice={this.state.price}
        currentQuantity={this.state.quantity}
      />
    );
  }
}

export default withRouter(EditProductContainer);