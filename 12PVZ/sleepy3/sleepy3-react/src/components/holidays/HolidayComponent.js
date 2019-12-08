import React from "react";
import image from '../holidays/Christmas.jpg';

const HolidayComponent = (props) =>{
    return(
        <div className="col-sm-4">
          <div className="card" style={{width: "18rem"}}>
            <img className="card-img-top" src={image} alt={props.title} style={{height: "300px"}}/>
            <div className="card-body">
              <h5 className="card-title">{props.title}</h5>
              <p className="card-text">{props.description}</p>
              <div className="form-group">Tipas: {props.type}</div> 
            </div>
          </div>
          <button onClick={props.onDeleteClick(props.title)} >MYGTUKAS</button>
          </div>
    );
} 
export default HolidayComponent;
