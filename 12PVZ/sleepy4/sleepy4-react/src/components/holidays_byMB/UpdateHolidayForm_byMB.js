import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class UpdateHolidayForm_byMB extends Component {
  constructor() {
    super();
    this.state = {
      title: "From Update Constructor 1",
      description: "",
      type: "PUBLIC",
      imageOfHoliday: "",
      isFlagRaised: "",
      hireDate: "",
      distance: "",
      price: ""
    };
  }

  componentDidMount() {
    console.log(this.props.match.params.title);
    axios
      .get(
        "http://localhost:8081/api/holidays/" + this.props.match.params.title
      )
      .then(response => this.setState(response.data))
      .catch(error => console.log(error));
  }

  handleChange(name, event) {
    let change = {};
    change[name] = event.target.value;
    this.setState(change);
  }

  handleSubmit(event) {
    event.preventDefault();
    axios
      .put("http://localhost:8081/api/holidays/" + this.props.match.params.title, this.state)
      .then(response => {
        console.log(response);
        this.props.history.go("/holidays"); //this is link where we returning after put 
      })
      .catch(error => console.log(error));
    this.setState({
      title: "From Update Constructor 2",
      description: "",
      type: "PUBLIC",
      imageOfHoliday: "",
      isFlagRaised: "",
      hireDate: "",
      distance: "",
      price: ""
    });
  }

  render() {
    return (
      <div className="container-fluid ">
        <h3>UPDATE HOLIDAY</h3>
        <form className="container" onSubmit={this.handleSubmit.bind(this)}>
          <div className="form-group">
            <label>Title</label>
            <input
              type="text"
              className="form-control"
              value={this.state.title}
              placeholder="title"
              onChange={this.handleChange.bind(this, "title")}
            />
          </div>

          <div className="form-group">
            <label>Description</label>
            <textarea
              className="form-control"
              value={this.state.description}
              rows="3"
              onChange={this.handleChange.bind(this, "description")}
            />
          </div>

          <div className="form-group">
            <label>Type</label>
            <select
              type="text"
              className="form-control"
              onChange={this.handleChange.bind(this, "type")}
            >
              <option selected value="PUBLIC">PUBLIC</option>
              <option value="NATIONAL_RELIGIOUS">NATIONAL_RELIGIOUS</option>
              <option value="MEMORIAL">MEMORIAL</option>
              <option value="NON_TRADITIONAL">NON_TRADITIONAL</option>
            </select>
          </div>

          <div className="form-group">
            <label>Image Of Holiday</label>
            <input
              type="imageOfHoliday"
              className="form-control"
              value={this.state.imageOfHoliday}
              placeholder="Image Of Holiday"
              onChange={this.handleChange.bind(this, "imageOfHoliday")}
            />
          </div>

          <div className="form-group">
            <label>Is flagged raised?</label>
            <select
              type="isFlagRaised"
              className="form-control"
              onChange={this.handleChange.bind(this, "isFlagRaised")}
            >
              <option selected value={true}>YES</option>
              <option value={false}>NO</option>
              <option value="OPTIONAL">OPTIONAL</option>
            </select>
          </div>

          <div className="form-group">
            <label>Hire date</label>
              <input
                type="date"
                className="form-control"
                placeholder="Hire date"
                value={this.state.hireDate}
                onChange={this.handleChange.bind(this, "hireDate")}
              />
          </div>

          <div className="form-group mb-2">
            <label>Distance (integer): </label>
                  <input
                    type="number"
                    step="1"
                    placeholder="Distance"
                    className="form-control"
                    name="distance"
                    onChange={this.handleChange.bind(this, "distance")}
                    required
                  />
          </div>

          <div className="form-group mb-2">
            <label>Price (double)</label>
                  <input
                    type="number"
                    step="0.01"
                    placeholder="Price"
                    className="form-control"
                    name="price"
                    onChange={this.handleChange.bind(this, "price")}
                    required
                  />
          </div>

          <button type="submit" className="btn btn-info">
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default UpdateHolidayForm_byMB;
