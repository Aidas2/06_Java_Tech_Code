import React from 'react';
import PropTypes from 'prop-types';
import ProductAdministrationLineComponent from './ProductAdministrationLineComponent';
//import MyProvider from '../App';
import axios from 'axios';
import {Link} from 'react-router-dom';

class ProductAdministrationListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            products: '',
            loading: 'Loading products. Please wait...'
        };
    }

    componentDidMount() {
        axios.get('https://itpro2017.herokuapp.com/api/products')
            .then((response) => {
                this.setState({ products: response.data });
                //console.log(response.data);
                //console.log("Produktai yra - " + this.state.products);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.products) {
            const productCards = this.state.products.map((product, index) => {
                return (
                    <ProductAdministrationLineComponent
                        key={index}
                        id={product.id}
                        image={product.image}
                        title={product.title}
                    />
                );
            });
            return (<div className="container">
                         <div className="row">
                         <Link className="btn btn-success" to="/admin/products/new">Add new product</Link>
                         </div>
                         <div className="row">
                            <div className="col-2">
                                <p>Product #</p>
                            </div>
                            <div className="col-2">
                                <p>Product picture</p>
                            </div>
                            <div className="col-8">
                                <p>Product title</p>
                            </div>
                        </div>
                        <div className="row">{productCards}
                        </div>
                    </div>);
        }
        return this.state.loading;
    }
}

export default ProductAdministrationListContainer;
