import React from "react";
import {Link} from "react-router-dom" 
import image from './customer.png';

const OneCustomerComponent = (props) =>{
    return(
        <div className="col-sm-4">

          <div className="card" style={{width: "18rem"}}>
                <h5 className="card-header">Vardas: {props.name}</h5>          
                <div className="card-body">
                    <img className="card-img-top" src={image} alt={props.title} style={{height: "300px"}}/>
                    <p className="card-text">Pavardė: {props.surname}</p>
                    <p className="card-text">Gimimo data: {props.birthDate}</p>
                    <p className="card-text">Telefono numeris: {props.phoneNumber}</p>
                    <p className="card-text">Tipas: {props.type}</p>  
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
                    to={"/admin/customers/" + props.name}
                    className="btn btn-primary m-2"
                >
                    Update
                </Link>


                <Link
                // this link should be the same as link in index:
                    to={"/admin/customers/inventory/" + props.title}
                    className="btn btn-warning m-2"
                >
                    Add inventory to Customer
                </Link>

                <Link
                // this link should be the same as link in index:
                    to={"/admin/customerDetails/" + props.name}
                    className="btn btn-primary m-2"
                >
                    Customer Details
                </Link>

          </div>
          
        </div>
    );
} 
export default OneCustomerComponent;
