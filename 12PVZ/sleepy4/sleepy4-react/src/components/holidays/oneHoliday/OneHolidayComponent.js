import React from "react";
import {Link} from "react-router-dom" 
import image from './holiday1.jpg';
import easter from './easter.jpg';
import jonines from './jonines.jpg';
import christmas from './christmas.jpg';

const OneHolidayComponent = (props) =>{
    return(
        <div className="col-sm-4">

          <div className="card" style={{width: "18rem"}}>
                <h5 className="card-header">Pavadinimas: {props.title}</h5>          
                <div className="card-body">
                    <img className="card-img-top" src={image} alt={props.title} style={{height: "300px"}}/>
                    
                    {/* if ({props.title} === Velykos) {
                        <img className="card-img-top" src={easter} alt={props.title} style={{height: "300px"}}/>
                    }
                    if ({props.title} === Joninės) {
                        <img className="card-img-top" src={jonines} alt={props.title} style={{height: "300px"}}/>
                    }
                    if ({props.title} === Kalėdos) {
                        <img className="card-img-top" src={christmas} alt={props.title} style={{height: "300px"}}/>
                    } */}
                    
                    <p className="card-text">Aprasymas: {props.description}</p>
                    <p className="card-text">Tipas: {props.type}</p> 
                    <p className="card-text">Paveiksliukas: {props.imageOfHoliday}</p>
                    <p className="card-text">Ar veliava pakelta: {props.isFlagRaised ? '✔️️' : 'Ne'}</p>
                    <p className="card-text">Data: {props.hireDate}</p> 
                    <p className="card-text">Atstumas, km: {props.distance}</p>
                    <p className="card-text">Kaina, Eur: {props.price}</p>   
                </div>

                <button 
                    type="button"
                    className="btn btn-danger m-2"
                    onClick={props.handleDelete}
                    //onClick={props.handleDelete(props.title)}
                >
                    Delete
                </button>

                <Link
                    to={"/admin/holidays/" + props.title}
                    className="btn btn-primary m-2"
                >
                    Update
                </Link>


                <Link
                // this link should be the same as link in index:
                //<Route exact path="/admin/holidays/country/:title" component={CountryToHolidayForm} />
                    to={"/admin/holidays/country/" + props.title}
                    className="btn btn-warning m-2"
                >
                    Add country to Holiday
                </Link>

                <Link
                // this link should be the same as link in index:
                //<Route exact path="/admin/holidayDetails/:title" component={HolidayDetailsContainer} />
                    to={"/admin/holidayDetails/" + props.title}
                    className="btn btn-primary m-2"
                >
                    Holiday Details
                </Link>


            
                {/* <div>Add Country</div>
                <div className="form-group mb-8">
                <select
                    id="inlineFormCustomSelect"
                    className="form-control"
                    name="country"
                    value={props.countries}
                    onChange={props.handleChange}
                >
                    <option defaultValue hidden>
                    Choose here
                    </option>
                    {props.availableCountry()}
                </select>
                <button
                    className="btn btn-warning"
                    onClick={() => props.onClickAddCountry()}
                >
                    Add
                </button>
                </div> */}

          </div>
          
        </div>
    );
} 
export default OneHolidayComponent;
