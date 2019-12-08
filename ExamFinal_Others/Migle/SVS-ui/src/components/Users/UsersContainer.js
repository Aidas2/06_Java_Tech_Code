import React, { Component } from "react";
import axios from "axios";
import UsersComponent from "./UsersComponent";

class UsersContainer extends Component {
  constructor() {
    super();
    this.state = {
      userList: null
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8080/api/users")
      .then(response =>
        this.setState({
          userList: response.data
        })
      )
      .catch(error => console.log(error));
  }

  render() {
    if (this.state.userList === null) {
      return <p />;
    } else {
      return (
        <div>
          <h5>USERS</h5>
          <UsersComponent userList={this.state.userList} />
        </div>
      )
    }
  }
}

export default UsersContainer;
