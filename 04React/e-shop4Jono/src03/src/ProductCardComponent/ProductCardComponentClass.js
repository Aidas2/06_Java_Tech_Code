import React, { Component } from 'react';
import PropTypes from 'prop-types';
import pic from './img/KingWear-KW06.jpg';

class ProductCardComponent extends Component {
    constructor(props){
        super(props);
        this.state = {
            titleState: this.props.title
        }
    }
    
    onClickAction = (event) => {
        event.preventDefault();
        this.setState({titleState: 'Mano nauja preke'});
        console.log("getDerivedStateFromProps");
    }

   


    render() {
        return (
            <div className="card" style={{ width: "18rem" }}>
            <img className="card-img-top" src={pic} alt="Smartwatch"></img>
            <div className="card-body">
                <h5 className="card-title" onClick={this.onClickAction}>{this.state.titleState}</h5>
                <p className="card-text">{this.props.description}</p>
                <p className="card-text">Price: {this.props.price} Euro</p>
                <p className="card-text">Quantity: {this.props.quantity} pcs.</p>
                <a href="#" className="btn btn-primary">Product details</a>
            </div>
        </div>
        );
    }
}

ProductCardComponent.propTypes = {
    title: PropTypes.string.isRequired,
    imageUrl: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};


export default ProductCardComponent;