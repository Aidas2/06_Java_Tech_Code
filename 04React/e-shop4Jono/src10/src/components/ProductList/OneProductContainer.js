import React from 'react';
import PropTypes from 'prop-types';
import OneProductComponent from './OneProductComponent';
//import MyProvider from '../App';
import axios from 'axios';

class OneProductContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: 0,
            title: "",
            image: "",
            description: "",
            price: 0,
            quantity: 0
        };
    }

    componentDidMount() {
        var pathnameArray = window.location.href.split('/');
        var position = pathnameArray[pathnameArray.length - 1];
        console.log("Koks kelias gaunasi?");
        console.log('https://itpro2017.herokuapp.com/api/products/' + (position))


        axios.get('https://itpro2017.herokuapp.com/api/products/' + (position))
            .then((response) => {

                this.setState(response.data);
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

    render() {

        return (
            <OneProductComponent title={this.state.title}
                                 description={this.state.description}
                                 price={this.state.price}
            />
            
        );


    }
}

    export default OneProductContainer;