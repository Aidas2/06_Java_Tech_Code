import React, { Component } from "react";
import axios from "axios";
import { withRouter } from "react-router";

class NewItemForm extends Component {
  constructor() {
    super();
    this.state = {
      userId: "",
      sectionNo: "",
      title: "",
      weight: ""
    };
  }

  componentDidMount() {
    this.state.userId = this.props.match.params.id;

  }

  handleChange(name, event) {
    let change = {};
    change[name] = event.target.value;
    this.setState(change);
  }

  handleSubmit(event) {
    event.preventDefault();
    axios
      .post("http://localhost:8080/api/items", this.state)
      .then(response => {
        console.log(response);
        this.props.history.push("/items/" + this.props.match.params.id);
      })
      .catch(error => console.log(error));
    this.setState({
      userId: "",
      sectionNo: "",
      title: "",
      weight: ""
    });
  }

  render() {
    return (
      <div className="container-fluid ">
        <h5>ADD NEW ITEM</h5>
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

export default withRouter(NewItemForm);
