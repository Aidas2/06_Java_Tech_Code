import React from 'react';
//import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import '../HolidayList/styles.css';

const OneCountryComponent = (props) => {
    let optionAddedHolidaysList = props.addedHolidays.map(v => (
        <option key={v}>{v}</option>
    ));

    let holidaysPList = props.addedHolidays.map((holiday, index) => <p key={index}>{holiday}</p>);
    return (
        <div className="container">
            <div className="row">
                <div className="col-md-2 col-lg-2">
                    <div className="row">
                        <h5>Country's picture:</h5>
                    </div>
                    <div className="row">
                        <img src={"/img/countries/" + props.image} alt="Country_picture" width="150px"></img>
                    </div>
                </div>
                <div className="col-md-3 col-lg-3">
                    <div className="row">
                        <h5>Country's title:</h5>
                    </div>
                    <div className="row pabraukti" >
                        <p>{props.title}</p>
                    </div>
                    <div className="row">
                        <h5>Country's president:</h5>
                    </div>
                    <div className="row pabraukti">
                        <p>{props.president}</p>
                    </div>
                    <div className="row">
                        <Link to={`/admin/countries`} className="btn btn-dark mt-3">Back</Link>
                    </div>
                </div>
                <div className="col-md-3 col-lg-3">
                    <p>Šalies šventės:</p>
                    <select className="form-control rounded"
                        multiple
                        size="5"
                        onChange={props.countryRemovingHandler}>
                        {optionAddedHolidaysList}
                    </select>
                </div>

                <div className="col-md-3 col-lg-3">
                    <p>TESTAS</p>
                    <div>
                        {holidaysPList}
                    </div>
                </div>
                
            </div>
        </div>
    );
}


export default OneCountryComponent;