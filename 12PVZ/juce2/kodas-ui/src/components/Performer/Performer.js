import React from "react";

const Performer = props => {
  return (
    <tr>
      <th scope="row">{props.index}</th>
      <td>{props.title}</td>
      <td>{props.firstName}</td>
      <td>{props.lastName}</td>
      <td>{props.genre}</td>
      <td>{props.country}</td>
      <td>{props.dob}</td>
      <td>
        <img
          height="150px"
          width="200px"
          src={props.picture}
          alt={props.title}
        />
      </td>
      <td className="d-flex justify-content-between">{props.children}</td>
    </tr>
  );
};

export default Performer;
