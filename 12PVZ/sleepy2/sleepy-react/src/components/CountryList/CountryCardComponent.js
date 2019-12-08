import React from 'react';
import PropTypes from 'prop-types';
import pic from './img/lithuania.jpg';

const CountryCardComponent = (props) => {
    return (
        <div className="card" style={{ width: "18rem" }}>
            <img className="card-img-top" src={pic} alt="FlagOfTheCountry"></img>
            <div className="card-body">
                <h5 className="card-title">Pavadinimas: {props.title}</h5>
                <p className="card-text">Aprasymas: {props.description}</p>
                <p className="card-text">Prezidento vardas: {props.nameOfPresident} .</p>
                <p className="card-text">Sventes data: {props.dateOfHoliday} .</p>
                <a href="#" className="btn btn-primary">Country details</a>
            </div>
        </div>
        );
}


CountryCardComponent.propTypes = {
    id:PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    nameOfPresident: PropTypes.string.isRequired,
    dateOfHoliday: PropTypes.string.isRequired
};


export default CountryCardComponent;
