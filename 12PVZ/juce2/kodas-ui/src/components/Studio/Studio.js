import React from "react";

const Studio = props => {
  return (
    <tr>
      <th scope="row">{props.index}</th>
      <td>{props.title}</td>
      <td>{props.category}</td>
      <td>{props.size}</td>
      <td>
        <img height="150px" width="200px" src={props.logo} alt={props.title} />
      </td>
      <td className="d-flex justify-content-between">{props.children}</td>
    </tr>
  );
};

export default Studio;
