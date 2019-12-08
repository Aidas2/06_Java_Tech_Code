import React from "react";
import {Link} from "react-router-dom" 
import image from '../oneCountry/lietuvabig.jpg';


//VERSION_02
const OneCountryComponent = props => {
  const styles = {
    cardContainer: {
      margin: '20px 0'
    },
    card: {
      padding: '0px'
    },
    image: {
      maxWidth: '100%',
      height: 'auto'
    },
    form: {
      margin: '0px'
    }
  };
  return (
    <div style={styles.cardContainer}>
      <div className="card col-md-12" style={styles.card}>
        <div className="card-header">{props.title}</div>
        <div className="card-body row">
          <div className="col-md-3 col-sm-12">
            <img src={image} alt={props.title} style={styles.image} />
          </div>
          <div className="col-md-9 col-sm-12 row">
            <div className="col-md-7 col-sm-12">
              <p className="card-text">Pavadinimas: {props.title}</p>
              <p className="card-text">Svoris: {props.weight}</p>
              <p className="card-text">Talpinimo sektorius: {props.numberOfSector}</p>
              <p className="card-text">Patalpinimo data: {props.placementDate}</p>
            </div>
            <div className="col-md-5 col-sm-12">
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default OneCountryComponent;
