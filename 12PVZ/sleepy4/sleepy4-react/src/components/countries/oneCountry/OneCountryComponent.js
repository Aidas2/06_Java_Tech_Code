import React from "react";
import {Link} from "react-router-dom" 
import image from '../oneCountry/lietuvabig.jpg';

// VERSION_01
// const OneCountryComponent = (props) =>{
//     return(
//         <div className="col-sm-4">
//           <div className="card" style={{width: "18rem"}}>
//             <h5 className="card-header">Pavadinimas: {props.title}</h5>
//             <div className="card-body">
//               <img className="card-img-top" src={image} alt={props.title} style={{height: "200px"}}/>
//               <p className="card-text">Prezidentas: {props.president}</p>
//               <p className="card-text">Veliava: {props.imageOfFlag}</p>
//               <p className="card-text">Plotas: {props.area}</p>
//               <p className="card-text">Populiacija: {props.population}</p>
//             </div>

//             <button 
//               type="button"
//               className="btn btn-danger m-2"
//               onClick={props.handleDelete}
//               //onClick={props.handleDelete(props.title)}
//               >
//               Delete
//             </button>

//             <Link
//               to={"/admin/countries/" + props.title}
//               className="btn btn-primary m-2"
//             >
//               Update
//             </Link>

//           </div>

//         </div>
//     );
// } 

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
              <p className="card-text">Prezidentas: {props.president}</p>
              <p className="card-text">Veliava: {props.imageOfFlag}</p>
              <p className="card-text">Plotas: {props.area}</p>
              <p className="card-text">Populiacija: {props.population}</p>
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
