import React, { Component } from "react";
import axios from "axios";
import { withRouter } from "react-router";

class UpdateItemForm extends Component {
  constructor() {
    super();
    this.state = {

    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8080/api/items/" + this.props.match.params.id)
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
      .put("http://localhost:8080/api/items/" + this.props.match.params.id, this.state)
      .then(response => {
        console.log(response);
        this.props.history.push("/items/" + this.state.userId);
      })
      .catch(error => console.log(error));
  }

  render() {
    return (
      <div className="container-fluid ">
        <h5>UPDATE YOUR ITEM</h5>
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
            <label>Weight</label>
            <input
              type="number"
              className="form-control"
              value={this.state.weight}
              placeholder="weight"
              onChange={this.handleChange.bind(this, "weight")}
            />
          </div>
          <div className="form-group">
            <label>Section number</label>
            <input
              type="number"
              min="1"
              max="40"
              className="form-control"
              value={this.state.sectionNo}
              placeholder="section number"
              onChange={this.handleChange.bind(this, "sectionNo")}
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

export default withRouter(UpdateItemForm);
