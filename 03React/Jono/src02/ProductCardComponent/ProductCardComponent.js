import React from 'react';
import PropTypes from 'prop-types';
import pic from './img/KingWear-KW06.jpg';

const ProductCardComponent = (props) => {
    return (
        <div className="card" style={{ width: "18rem" }}>
            
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                
                <p className="card-text">Price: {props.price} Euro</p>
                <p className="card-text">Quantity: {props.quantity} pcs.</p>
                <a href="#" className="btn btn-primary">Product details</a>
            </div>
        </div>
        );
}


ProductCardComponent.propTypes = {
    title: PropTypes.string.isRequired,
        
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};


export default ProductCardComponent;