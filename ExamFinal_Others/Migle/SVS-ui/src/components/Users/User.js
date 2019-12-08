import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";

class User extends React.Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
    return (
      <div className="card m-2">
        <div className="card-body">
          <h5 className="card-title">{this.props.firstName + ' ' + this.props.lastName}</h5>
          <p className="card-text">Item count: {this.props.itemCount}</p>
          <Link
            to={"/user/" + this.props.id}
            className="btn btn-primary m-2"
          >
            more
          </Link>
        </div>
      </div>
    );
  }
}

export default User;
