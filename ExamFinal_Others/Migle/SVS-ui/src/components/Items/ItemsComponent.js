import React, { Component } from "react";
import Item from "./Item";

class ItemsComponent extends Component {
  render() {
    let itemsList = this.props.itemsList.map(item => (
      <Item
        id={item.itemId}
        key={item.itemId}
        title={item.title}
        weight={item.weight}
        sectionNo={item.sectionNo}
        rerender={this.props.rerender}
      />
    ));
    return (
      <div className="container-fluid">
        <div className="row">{itemsList}</div>
      </div>
    );
  }
}

export default ItemsComponent;
