import React, { Component } from "react";
import axios from "axios";
import ItemsComponent from "./ItemsComponent";

class ItemsTableContainer extends Component {
  constructor() {
    super();
    this.state = {
      itemsList: null
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8080/api/users/" + this.props.match.params.id + "/items")
      .then(response =>
        this.setState({
          itemsList: response.data
        })
      )
      .catch(error => console.log(error));
  }

  render() {
    if (this.state.itemsList === null) {
      return <p />;
    } else {
      return (
      <div>
           <h5>USERS ITEMS</h5>
           <ItemsComponent itemsList={this.state.itemsList} rerender={this.rerender} />
        </div>
      )
    }
  }
}

export default ItemsTableContainer;
