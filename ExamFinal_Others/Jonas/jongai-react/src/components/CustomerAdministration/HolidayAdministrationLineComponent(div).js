import React from 'react';
//import PropTypes from 'prop-types';
import pic from '../HolidayList/img/KingWear-KW06.jpg';
import { withRouter } from 'react-router';

//ar reikia jo? Ar pades jis? 
import { Link } from 'react-router-dom';

const HolidayAdministrationLineComponent = (props) => {
    
    var linkas = "/admin/holidays/" + props.title;
    return (
        <div className="container">
            <div className="row">
                <div className="col-sm-3 col-md-2 col-lg-2 mb-3">
                <Link to={linkas}>{props.title}</Link>       
                </div>
                <div className="col-sm-3 col-md-2 col-lg-2 mb-3">
                    <img src={pic} alt="Holiday_picture" width="50%"></img>
                </div>
                <div className="col-sm-6 col-md-8 col-lg-8 mb-3">
                    <p>{props.description}</p>
                </div>
            </div>
        </div>
    );
}


{/*
ProductCardComponent.propTypes = {
    id: PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};
*/}

export default withRouter(HolidayAdministrationLineComponent);