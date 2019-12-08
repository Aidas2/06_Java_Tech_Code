import React, { Component } from "react";
import Axios from "axios";

class PerformerForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      firstName: "",
      lastName: "",
      genre: "",
      country: "",
      dob: new Date(),
      picture: ""
    };
  }

  handleChange = event => {
    // console.log("NAME: " + event.target.name + " VALUE: " + event.target.value);
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    console.log(this.state);
    Axios.post("http://localhost:8081/kodas-java/api/performers", this.state)
      .then(res => {
        console.log(this.props.history);
        this.props.history.go("/performers");
      })
      .catch(err => console.log(err));
    //let newStudent = {firstname: this.state.firstname, lastname: this.state.lastname, email: this.state.email};
    //this.props.createStudent(newStudent);
  };

  render() {
    return (
      <div className="panel panel-default my-3">
        <div className="panel-heading">Create new performer</div>
        <div className="panel-body">
          <form className="form-inline" onSubmit={e => this.handleSubmit(e)}>
            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Title"
                className="form-control"
                name="title"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="First Name"
                className="form-control"
                name="firstName"
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Last Name"
                className="form-control"
                name="lastName"
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Genre"
                className="form-control"
                name="genre"
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Country"
                className="form-control"
                name="country"
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Picture"
                className="form-control"
                name="picture"
                onChange={this.handleChange}
              />
            </div>

            <div className="form-group mb-2">
              <input
                type="date"
                placeholder="DOB"
                className="form-control"
                name="dob"
                onChange={this.handleChange}
              />
            </div>

            <div className="form-group mb-2">
              <button className="btn btn-success" type="submit">
                Save
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}

export default PerformerForm;
