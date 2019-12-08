import React from 'react';
import PropTypes from 'prop-types';
import pic from './img/KingWear-KW06.jpg';
import { Link } from 'react-router-dom';

const OneProductComponent = (props) => {
    return (
        <div className="container">
            <div className="row">
                <div className="col-2">
                    <img src={pic} alt="Smartphone" width="150px"></img>
                </div>
                <div className="col-3">
                    <h5>{props.title}</h5>
                    <p>{props.description}</p>
                    <p>Price: {props.price} Eur.</p>
                </div>
            </div>
            <div className="row">
                <div className="col-6">
                <Link className="btn btn-primary" to="/admin/products/new">Add to cart</Link> &nbsp;
                <Link className="btn btn-success" to="/">Back</Link>
                </div>

                
            </div>
        </div>
    );
}

/*
OneProductComponent.propTypes = {
    id:PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};*/


export default OneProductComponent;