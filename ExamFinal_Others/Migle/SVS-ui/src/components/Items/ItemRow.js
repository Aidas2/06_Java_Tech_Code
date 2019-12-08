import React from "react";

class ItemRow extends React.Component {
  constructor() {
    super();
    this.state = {};
  }
  render() {
    return (
      <tr>
        <th scope="row">1</th>
        <td>{this.props.title}</td>
        <td>{this.props.weight}</td>
        <td>{this.props.sectionNo}</td>
     </tr>
     );
  }
}

export default ItemRow;
