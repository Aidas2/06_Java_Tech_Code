import React from 'react';
import PropTypes from 'prop-types';
import pic from './img/KingWear-KW06.jpg';
import {Link} from 'react-router-dom';

const ProductCardComponent = (props) => {
    var linkas = "/products/" + props.id;
    return (
        <div className="card" style={{ width: "18rem" }}>
            <img className="card-img-top" src={pic} alt="Smartwatch"></img>
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                <p className="card-text">{props.description}</p>
                <p className="card-text">Price: {props.price} Euro</p>
                <p className="card-text">Quantity: {props.quantity} pcs.</p>
                <Link className="btn btn-primary" to={linkas}>Product details</Link>
                {/*<a href="#" className="btn btn-primary">Product details</a>*/}
            </div>
        </div>
        );
}


ProductCardComponent.propTypes = {
    id:PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};


export default ProductCardComponent;