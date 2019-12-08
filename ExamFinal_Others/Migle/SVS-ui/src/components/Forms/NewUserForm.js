import React, { Component } from "react";
import axios from "axios";
import { withRouter } from "react-router";


class NewUserForm extends Component {
  constructor() {
    super();
    this.state = {
      firstName: "",
      lastName: "",
      phoneNo: "",
      userType: "REGULAR",
    };
  }

  handleChange(name, event) {
    let change = {};
    change[name] = event.target.value;
    this.setState(change);
  }

  handleSubmit(event) {
    event.preventDefault();
    axios
      .post("http://localhost:8080/api/users", this.state)
      .then(response => {
        console.log(response);
        this.props.history.push("/");
      })
      .catch(error => console.log(error));
    this.setState({
      firstName: "",
      lastName: "",
      phoneNo: "",
      userType: "REGULAR",
    });
  }

  render() {
    return (
      <div className="container-fluid ">
        <h5>ADD NEW USER</h5>
        <form className="container" onSubmit={this.handleSubmit.bind(this)}>
          <div className="form-group">
            <label>First Name</label>
            <input
              type="text"
              className="form-control"
              value={this.state.firstName}
              placeholder="first name"
              onChange={this.handleChange.bind(this, "firstName")}
            />
          </div>
          <div className="form-group">
            <label>Last Name</label>
            <input
              type="text"
              className="form-control"
              value={this.state.lastname}
              placeholder="last name"
              onChange={this.handleChange.bind(this, "lastName")}
            />
          </div>
          <div className="form-group">
            <label>Phone number</label>
            <input
              type="text"
              className="form-control"
              value={this.state.phoneNo}
              placeholder="phone number"
              onChange={this.handleChange.bind(this, "phoneNo")}
            />
          </div>
          <div className="form-group">
            <label>Type</label>
            <select
              type="text"
              className="form-control"
              onChange={this.handleChange.bind(this, "type")}
            >
              <option selected value="PUBLIC">
                REGULAR
              </option>
              <option value="NATIONAL_RELIGIOUS">LOYAL</option>
            </select>
          </div>
          <button type="submit" className="btn btn-info">
            submit
          </button>
        </form>
      </div>
    );
  }
}

export default withRouter(NewUserForm);
