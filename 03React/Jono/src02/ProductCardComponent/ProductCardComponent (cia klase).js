import React, { Component } from 'react';
import PropTypes from 'prop-types';

class ProductCardComponent extends React.Component {
    render() {
        return (<div className="card" style={{ width: "18rem" }}>
            <img className="card-img-top" src="img/KingWear-KW06.jpg" alt="Smartwatch"></img>
            <div className="card-body">
                <h5 className="card-title">{this.props.productName}</h5>
                <p className="card-text">{this.props.productDescription}</p>
                <p className="card-text">Price: {this.props.productPrice} Euro</p>
                <a href="#" className="btn btn-primary">Product details</a>
            </div>
        </div>);
    }
}

ProductCardComponent.propTypes = {
    productId: PropTypes.number.isRequired,
    productName: PropTypes.string.isRequired,
    productImage: PropTypes.string.isRequired,
    productDescription: PropTypes.string.isRequired,
    productPrice: PropTypes.number.isRequired
};


export default ProductCardComponent;