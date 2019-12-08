import React, { Component } from "react";
import Axios from "axios";

class StudioUpdateForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      logo: "",
      category: "Home",
      size: 0.0,
      performers: [],
      performer: ""
    };
  }

  componentDidMount = () => {
    Axios.get(
      "http://localhost:8081/kodas-java/api/studios/" +
        this.props.match.params.title
    )
      .then(res => {
        console.log(res.data);
        this.setState(res.data);
      })
      .catch(err => console.log(err));

    Axios.get("http://localhost:8081/kodas-java/api/performers")
      .then(res => this.setState({ performers: res.data }))
      .catch();
  };

  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    //console.log(this.state);
    Axios.put(
      "http://localhost:8081/kodas-java/api/studios/" +
        this.props.match.params.title,
      this.state
    )
      .then(res => {
        this.props.history.goBack();
      })
      .catch(err => console.log(err));
  };

  goBack = () => {
    this.props.history.goBack();
  };

  availablePerformance = () => {
    let providers = this.state.performers.map(prov => {
      return (
        <option key={prov.title} value={prov.title}>
          {prov.title}
        </option>
      );
    });
    return providers;
  };

  onClickAddPerformer = () => {
    Axios.put(
      "http://localhost:8081/kodas-java/api/studios/" +
        this.props.match.params.title +
        "/" +
        this.state.performer
    )
      .then(res => console.log(res))
      .catch(err => console.log(err));
  };

  render() {
    return (
      <div className="panel panel-default my-3">
        <div className="panel-heading">Update Service</div>
        <div className="panel-body">
          <form className="form-inline" onSubmit={e => this.handleSubmit(e)}>
            <div className="form-group mb-2">
              <input
                disabled
                type="text"
                placeholder="Title"
                className="form-control"
                name="title"
                value={this.state.title}
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
                value={this.state.logo}
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
                value={this.state.category}
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
                value={this.state.size}
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <button className="btn btn-success" type="submit">
                Save
              </button>
              <button
                className="btn btn-warning mx-3"
                type="button"
                onClick={() => this.goBack()}
              >
                Back
              </button>
            </div>
          </form>
        </div>
        <div>Add Performer</div>
        <div className="form-group mb-8">
          <select
            id="inlineFormCustomSelect"
            className="form-control"
            name="performer"
            value={this.state.performers}
            onChange={this.handleChange}
          >
            <option defaultValue hidden>
              Choose here
            </option>
            {this.availablePerformance()}
          </select>
          <button
            className="btn btn-warning"
            onClick={() => this.onClickAddPerformer()}
          >
            Add
          </button>
        </div>
      </div>
    );
  }
}

export default StudioUpdateForm;
