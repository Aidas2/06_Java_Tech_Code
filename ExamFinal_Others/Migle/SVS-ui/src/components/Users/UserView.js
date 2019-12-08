import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import ItemsTable from "../Items/ItemsTable"

class UserView extends React.Component {
  constructor() {
    super();
    this.state = {
      user: null
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8080/api/users/" + this.props.match.params.id)
      .then(response =>
        this.setState({
          user: response.data
        })
      )
      .catch(error => console.log(error));
  }

  deleteHandler(event) {
    event.preventDefault();
    axios
      .delete("http://localhost:8080/api/users/delete/" + this.props.match.params.id)
      .then(response => {
        console.log(response);
      })
      .catch(error => console.log(error));
  }

  render() {
    if (this.state.user === null) {
      return <p />;
    } else {
    return (
      <div>
          <h5>USER INFO</h5>
          <p className="card-text">First Name: {this.state.user.firstName}</p>
          <p className="card-text">Last Name: {this.state.user.lastName}</p>
          <p className="card-text">Item count: {this.state.user.itemCount}</p> 
          <ItemsTable userId={this.props.match.params.id}/>
          <Link
            to={"/add-item/" + this.state.user.userId}
            className="btn btn-primary m-2"
          >
            add item
          </Link>
          <Link
            to={"/items/" + this.state.user.userId}
            className="btn btn-primary m-2"
          >
            items
          </Link>
        </div>
    )
    }
  } 
}

export default UserView;
