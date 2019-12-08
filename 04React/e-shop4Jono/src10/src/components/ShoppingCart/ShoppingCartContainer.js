import React from 'react';
import PropTypes from 'prop-types';
import ShoppingCartComponent from './ShoppingCartComponent';
//import MyProvider from '../App';
import axios from 'axios';
import { Link } from 'react-router-dom';

class ShoppingCartContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            products: '',
            loading: 'Shopping cart is empty.'
        };
    }

    componentDidMount() {
        axios.get('https://itpro2017.herokuapp.com/api/users/yyyy/cart-products')
            .then((response) => {
                this.setState({ products: response.data });
                //console.log(response.data);
                //console.log("Produktai yra - " + this.state.products);
            })
            .catch((error) => {
                console.log("Ar cia ivyksta klaida?");
                console.log(error);
            });
    }

    handleDeleteItem = (itemId) => {
        //this.setState({ title: event.target.value });
        console.log("Trinu");
        console.log('https://itpro2017.herokuapp.com/api/users/yyyy/cart-products/' + (itemId));
        
        axios.delete('https://itpro2017.herokuapp.com/api/users/yyyy/cart-products/' + (itemId))
            .then(function (response) {
                console.log("Buvo ivykdytas istrynimas");
                console.log(response);
                //this.setState({ products: response.data }); NEVEIKIA, nes THIS cia yra jau nebe klase, o ivykis (ar kazkas tokio)
                window.location.reload();
            })
            .catch(function (error) {
                console.log(error);
            });
            

    }


    render() {
        if (this.state.products) {
            const productList = this.state.products.map((product, index) => {
                return (
                    <ShoppingCartComponent
                        key={index}
                        id={product.id}
                        image={product.image}
                        title={product.title}
                        handleDeleteItem={this.handleDeleteItem}
                    />
                );
            });
            return (<div className="container">

                <div className="row">
                    <div className="col-2">
                        <p>Product picture</p>
                    </div>
                    <div className="col-6">
                        <p>Product title</p>
                    </div>
                    <div className="col-4">
                        <p>Product #</p>
                    </div>
                </div>
                <div className="row">{productList}
                </div>
            </div>);
        }
        return this.state.loading;
    }
}

export default ShoppingCartContainer;
