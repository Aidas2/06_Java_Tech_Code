import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { withRouter } from "react-router";

class Item extends React.Component {
  constructor() {
    super();
    this.state = {};
  }
  deleteHandler(event) {
    event.preventDefault();
    axios
      .delete("http://localhost:8080/api/items/" + this.props.id)
      .then (response => {
        console.log(response);
        this.props.rerender();    
      },         
      )
      .catch(error => console.log(error));
  }

  render() {
    return (
      <div className="card m-2">
        <h5 className="card-header">Title: {this.props.title}</h5>
        <div className="card-body">
          <p className="card-text">Section number: {this.props.weight}</p>
          <Link
            to={"/update-item/" + this.props.id}
            className="btn btn-primary m-2"
          >
            update
          </Link>
          <form onSubmit={this.deleteHandler.bind(this)}>
            <button type="submit" className="btn btn-primary m-2">
              delete
            </button>
          </form>
        </div>
      </div>
    );
  }
}

export default withRouter(Item);
