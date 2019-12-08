import React from "react";

const StudioCard = props => {
  return (
    <div>
      <div className="card text-white bg-dark mb-3" style={{ width: "18rem" }}>
        <img className="card-img-top" src={props.logo} alt={props.title} />
        <div className="card-body">
          <h5 className="card-title">{props.title}</h5>
          <p className="card-text">{props.category}</p>
          <p className="card-text">{props.size}</p>
          <div className="d-flex justify-content-between">{props.children}</div>
        </div>
      </div>
    </div>
  );
};

export default StudioCard;
