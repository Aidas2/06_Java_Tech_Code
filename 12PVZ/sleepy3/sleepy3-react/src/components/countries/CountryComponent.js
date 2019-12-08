import React from "react";
import image from '../countries/Lithuania_flag.jpg';

const CountryComponent = (props) =>{
    return(
        <div className="col-sm-4">
          <div className="card" style={{width: "18rem"}}>
            <img className="card-img-top" src={image} alt={props.title} style={{height: "200px"}}/>
            <div className="card-body">
              <h5 className="card-title">Pavadinimas: {props.title}</h5>
              <p className="card-text">Prezidentas: {props.president}</p>
              <p className="card-text">Veliava: {props.imageOfFlag}</p>
            </div>
          </div>
          {/* <button onClick={props.onDeleteClick(props.title)} ></button> */}
          </div>
    );
} 
export default CountryComponent;
