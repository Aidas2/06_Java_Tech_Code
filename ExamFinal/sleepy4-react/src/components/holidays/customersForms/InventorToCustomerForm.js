import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { submitCustomer } from "../../../api/customers";
import { fetchInventorList } from "../../../api/inventors";

class InventorToCustomerForm extends Component {
  constructor() {
    super();
    this.state = {
      allInventorList: [],
      chosenInventorTitle: ""
    };
  }

  componentDidMount() {
    console.log(" === Startavo InventorToCustomerForm, componentDidMount")
    console.log(" === axios.get url yra_EX ---> ")
    console.log("http://localhost:8081/api/inventors/");
    fetchInventorList()
      .then(data =>
        this.setState(
          {
            allInventorList: data,
            chosenInventorTitle: data[0].title
          },
          console.log(data)
        )
      )
      .catch(error => console.log(error));
  }

  handleInventorChange(event) {
    console.log(" === Startavo InventorToCustomerForm, handleCountryChange")
    this.setState({
      chosenInventorTitle: event.target.value
    });
  }

  handleSubmit(event) {
    console.log(" === Startavo InventorToCustomerForm, handleSubmit_EX")
    event.preventDefault();

    submitCustomer(this.props.match.params.name, this.state.chosenInventorTitle)
      .then(response => {
        console.log(" === Pavyko ! Prijungta " + this.props.match.params.name + " prie " + this.state.chosenInventorTitle);
        console.log(response);
        this.props.history.push("/customers");
      })
      .catch(error => {
        console.log(" === Nepavyko :(. Neprijungta nes --->");
        console.log(error)
      });

  }

  availableInventors() {
    console.log("=== Startavo metodas availableInventors(). Galimi inventoriai yra:");
    console.log(this.state.allInventorList);
    let inventors = this.state.allInventorList.map(i => {
      return (
        <option key={i.title} value={i.title}>
          {i.title}
        </option>
      );
    });
    return inventors;
  }


  render() {

    this.fromMenu = "Hi, this is InventorToCustomerForm."

    return (
      <div className="container-fluid ">
        <h1>ADD INVENTOR TO CUSTOMER</h1>
        fromMenu={this.fromMenu}

        <form className="container" onSubmit={this.handleSubmit.bind(this)}>
          <div className="form-group">
            <label>Choose a inventor</label>
            <select
              type="text"
              className="form-control"
              onChange={this.handleInventorChange.bind(this)}
            >
              {this.availableInventors()}
            </select>
          </div>
          <button type="submit" className="btn btn-info">
            Submit
          </button>
        </form>

      </div>
    );
  }
}

export default InventorToCustomerForm;
