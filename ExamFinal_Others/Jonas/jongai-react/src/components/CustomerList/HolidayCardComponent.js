import React from 'react';
import PropTypes from 'prop-types';
import {Link} from 'react-router-dom';

/* var styles = {
    tekstoFonas: { background: 'red' },
    tekstoSpalva: { color: 'green' }
    }; */

const HolidayCardComponent = (props) => {
    var linkas = "/holidays/" + props.code;
    return (
        <div className="card p-3 m-1" style={{ width: "16rem" }}>
            <img className="card-img-top" src={"/img/holidays/" + props.image} alt="Holiday_picture"></img>
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                <p className="card-text">{props.description}</p>
                <p className="card-text">Type: {props.type}</p>
                <p className="card-text">Rise flag: {props.flag}</p>
                <p className="card-text">{props.simpleDate}</p>
                <Link className="btn btn-primary" to={linkas}>Holiday details</Link>
            </div>
        </div>
        );
}


HolidayCardComponent.propTypes = {
    code: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    type: PropTypes.string.isRequired,
    flag: PropTypes.string.isRequired
};

export default HolidayCardComponent;