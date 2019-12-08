import React, { Component } from "react";
import Axios from "axios";

class StudioForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      logo: "",
      category: "",
      size: 0.0
    };
  }

  handleChange = event => {
    // console.log("NAME: " + event.target.name + " VALUE: " + event.target.value);
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    //console.log(this.state);
    Axios.post("http://localhost:8081/kodas-java/api/studios", this.state)
      .then(res => {
        console.log(this.props.history);
        this.props.history.go("/");
      })
      .catch(err => console.log(err));
  };

  render() {
    return (
      <div className="panel panel-default my-3">
        <div className="panel-heading">Create new Record Studio</div>
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
                placeholder="Logo"
                className="form-control"
                name="logo"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <select
                required
                id="inlineFormCustomSelect"
                placeholder="Category"
                className="form-control"
                name="category"
                onChange={this.handleChange}
              >
                <option defaultValue disabled>
                  Category...
                </option>
                <option value="National">National</option>
                <option value="Home">Home</option>
                <option value="Live">Live</option>
              </select>
            </div>
            <div className="form-group mb-2">
              <input
                type="number"
                step="0.01"
                placeholder="Size"
                className="form-control"
                name="size"
                onChange={this.handleChange}
                required
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

export default StudioForm;
