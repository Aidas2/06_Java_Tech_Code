import React from 'react';
import PropTypes from 'prop-types';
import picture from './img/KingWear-KW06.jpg'; 

const TotalPriceComponent = (props) => {
    return (
        <div className="card" style={{ width: "18rem" }}>
            
            <div className="card-body">
            <h5 className="card-title">Total price is:</h5>
                <p className="card-text">{props.totalPrice} Euro</p>
                <p className="card-text"></p>
                <p className="card-text"></p>
                
            </div>
        </div>
        );
}

TotalPriceComponent.propTypes = {
    totalPrice: PropTypes.number.isRequired    
};

export default TotalPriceComponent;