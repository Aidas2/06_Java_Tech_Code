import React from "react";
import image from "../places/Egypt.Giza.Sphinx.02.jpg"

const PlaceComponent = (props) => {
    return(
        <div className="col-sm-4">
        <div className="card" style={{width: "18rem"}}>
          <img className="card-img-top" src={image} alt={props.title} style={{height: "300px"}}/>
          <div className="card-body">
            {/* <h3>Hi, this is PlaceComponent.</h3> */}
            <h5 className="card-title">Pavadinimas: {props.title}</h5>
            <p className="card-text">Aprasymas: {props.description}</p>
            <p className="card-text">Nuotrauka: {props.imageOfPlace}</p>
            <p className="card-text">Adresas: {props.address}</p>
            <p className="card-text">Atstumas: {props.distance}</p>
            <p className="card-text">Kaina: {props.price}</p>
            <div className="form-group">Sezonas: {props.season}</div> 
          </div>
        </div>
        {/* <button onClick={props.onDeleteClick(props.title)} >MYGTUKAS</button> */}
        </div>
    );
}

export default PlaceComponent;