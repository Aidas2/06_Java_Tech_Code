import React, { Component } from "react";
import axios from "axios";
import ItemRow from "./ItemRow";

class ItemsContainer extends Component {
  constructor() {
    super();
    this.state = {
      itemsList: null
    };
  }

  rerender() {
  }

  componentDidMount() {
    axios
      .get("http://localhost:8080/api/users/" + this.props.userId + "/items")
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
      let itemsList = this.state.itemsList.map(item => (
        <ItemRow
          key={item.itemId}
          title={item.title}
          weight={item.weight}
          sectionNo={item.sectionNo}
      />));
      return (
        <div>
           <h5>USERS ITEMS TABLE</h5>
           <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Title</th>
      <th scope="col">Weight</th>
      <th scope="col">Section number</th>
    </tr>
  </thead>
  <tbody>
  <div>{itemsList}</div>

   
  </tbody>
</table>        
</div>
      )
    }
  }
}

export default ItemsContainer;
