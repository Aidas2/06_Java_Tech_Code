import React, { Component } from "react";
import User from "./User";

class UsersComponent extends Component {
  render() {
    let userList = this.props.userList.map(user => (
      <User
        id={user.userId}
        key={user.userId}
        firstName={user.firstName}
        lastName={user.lastName}
        itemCount={user.itemCount}
      />
    ));
    return (
      <div className="container-fluid">
        <div className="row">{userList}</div>;
      </div>
    );
  }
}

export default UsersComponent;
