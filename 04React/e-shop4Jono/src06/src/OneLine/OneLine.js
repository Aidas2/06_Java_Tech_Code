import React from 'react';
import PropTypes from 'prop-types';

const OneLine = (props) => {
    return (
        <div className="card" style={{ width: "18rem" }}>
            
            <div className="card-body">
                <h5 className="card-title">Product list:</h5>
                <p className="card-text">{props.titleAndPrice}</p>
                
            </div>
        </div>
        );
}


OneLine.propTypes = {
    titleAndPrice: PropTypes.string.isRequired,
};


export default OneLine;