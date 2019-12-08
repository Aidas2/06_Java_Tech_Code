import React, {Component} from 'react';
import PropTypes from 'prop-types';
import ProductCardComponent from '../ProductCardComponent/ProductCardComponent';

class ProductListComponent extends Component {
    render() {
        var products = this.props.products.map(product => {
            return (<div className="col col-sm-12 col-md-4 col-lg-4" key={product.pavadinimas}> 
                <ProductCardComponent
                pavadinimas = {product.pavadinimas}
                paveiksliukas = {product.paveiksliukas}
                aprasymas = {product.aprasymas}
                kaina = {product.kaina}
                kiekis = {product.kiekis}
                nuoroda = {product.nuoroda}
                />
                </div>
            );
    })

    return (
        <div className = "container">
            <div className = "row">
                {products}
            </div>


        </div>
    );
    }
}

ProductListComponent.propTypes = {
    products: PropTypes.array.isRequired
}

export default ProductListComponent;
