import React from 'react';
import PropTypes from 'prop-types';
import ProductCardComponent from '../ProductCardComponent/ProductCardComponent';
import MyProvider from '../App';
import axios from 'axios';

class ProductListComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = { products: '',
                        loading: 'Loading products. Please wait...'  };
    }

    componentDidMount() {
        axios.get('https://itpro2017.herokuapp.com/api/products')
            .then((response) => {
                this.setState({ products: response.data });
                console.log(response.data);
                console.log("Produktai yra - " + this.state.products);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.products) {
            const productCards = this.state.products.map((product, index) => {
                return (
                    <ProductCardComponent
                        key={index}
                        id={product.id}
                        title={product.title}
                        image={product.image}
                        description={product.description}
                        price={product.price}
                        quantity={product.quantity}
                    />
                );
            });
            return (<div className="row">{productCards}</div>);
        }
        return this.state.loading;
    }

}

export default ProductListComponent;




/*

//-----Prekiu importavimas is serverio----------
    axios.get('https://itpro2017.herokuapp.com/api/products')
        .then((response) => {
            console.log(response);
            console.log(response.data);
            console.log(response.data[0]);
            var productListOnWeb = response.data[0];
            console.log("Pirmas objektas - " + productListOnWeb);
        })
        .catch((error) => {
            console.log(error);
        });

*/

/*
    productCards = this.props.products.map(function (product, index) {
        return (
            <ProductCardComponent
                key={index}
                id={product.id}
                title={product.title}
                image={product.image}
                description={product.description}
                price={product.price}
                quantity={product.quantity}
            />
        );
    });
    */