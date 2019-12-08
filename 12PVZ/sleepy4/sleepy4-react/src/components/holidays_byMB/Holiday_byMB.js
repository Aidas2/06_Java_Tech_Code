import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";

// STEP_1. This is very first SINGLE Component+Container of Holiday (because there is no axios.get ALL)

class Holiday_byMB extends React.Component {
  constructor() {
    super();
    this.state = {};
  }

  deleteHandler(event) {
    event.preventDefault();
    console.log("deleteHandler method started");
    axios
      // .delete("http://localhost:8081/api/holidays/delete/" + this.props.id)
      .delete("http://localhost:8081/api/holidays/delete/" + this.props.title)
      .then(response => {
        console.log("buvo istrinta ---> " + this.props.title);
        console.log("atsakymas po axios sekmingo istrynimo ---> " + response);
      })
      .catch(error => console.log("atsakymas po axios nesekmingo istrynimo ---> " + error));
  }

  render() {
    
    return (
      <div className="card m-2">
        {/* <pre>{ JSON.stringify(this.props) }</pre> */}
        <h5 className="card-header">Pavadinimas: {this.props.title}</h5>
        <div className="card-body">
          <h5 className="card-title">Aprasymas: {this.props.description}</h5>
          <p className="card-text">Tipas: {this.props.type}</p>
          <p className="card-text">Paveiksliukas: {this.props.imageOfHoliday}</p>
          <p className="card-text">Ar veliava pakelta: {this.props.isFlagRaised ? '✔️️' : 'Ne'}</p>
          <p className="card-text">Data: {this.props.hireDate}</p>
          <p className="card-text">Atstumas, km: {this.props.distance}</p>
          <p className="card-text">Kaina, Eur: {this.props.price}</p>

          <Link
            to={"/admin/holidays/" + this.props.title} 
                 // link to update + exactly to this holiday
            className="btn btn-primary m-2"
          >
            Update
          </Link>

          <Link
            to={"/admin/holidays/country/" + this.props.title}
            className="btn btn-warning m-2"
          >
            Add country
          </Link>

          <form onSubmit={this.deleteHandler.bind(this)}>
            <button type="submit" className="btn btn-primary m-2">
              Delete
            </button>
          </form>
          
        </div>
      </div>
    );
  }
}

export default Holiday_byMB;
