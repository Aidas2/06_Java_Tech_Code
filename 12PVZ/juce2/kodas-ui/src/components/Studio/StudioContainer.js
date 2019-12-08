import React, { Component } from "react";
import Axios from "axios";
import Studio from "./Studio";
import Button from "../Button";
import StudioForm from "./StudioForm";
import NoPicture from "../../images/no_img.svg";

class StudioContainer extends Component {
  constructor(props) {
    super(props);
    this.state = { studios: [] };
  }

  getAllData = () => {
    Axios.get("http://localhost:8081/kodas-java/api/studios")
      .then(res => {
        console.log(res.data);
        this.setState({ studios: res.data });
      })
      .catch(err => {
        console.log(err);
      });
  };

  onDeleteClickHandler = title => {
    Axios.delete("http://localhost:8081/kodas-java/api/studios/" + title)
      .then(res => {
        console.log(res);
        this.getAllData();
      })
      .catch(err => {
        console.log(err);
      });
  };

  onDetailsClickHandler = title => {
    this.props.history.push("/studios/" + title);
  };

  showAllData = () => {
    let data = this.state.studios.map((s, index) => {
      let category;
      let img;
      if (s.logo === "null" || s.log === null) {
        img = NoPicture;
      } else {
        img = s.logo;
      }
      switch (s.category) {
        case 0:
          category = "National";
          break;
        case 1:
          category = "Home";
          break;
        case 2:
          category = "Live";
          break;
        default:
          break;
      }
      return (
        <Studio
          key={s.title}
          index={index + 1}
          title={s.title}
          category={s.category}
          size={s.size}
          logo={img}
          {...this.props}
        >
          <Button
            title="Details"
            action={() => this.onDetailsClickHandler(s.title)}
            type="btn-success"
          />
          <Button
            title="Delete"
            action={() => this.onDeleteClickHandler(s.title)}
            type="btn-warning"
          />
        </Studio>
      );
    });
    return data;
  };

  componentDidMount() {
    this.getAllData();
  }

  render() {
    return (
      <div className="container">
        <div className="row">
          <StudioForm {...this.props} />
        </div>
        <div className="row">
          <table className="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Category</th>
                <th scope="col">Size</th>
                <th scope="col">Picture</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>{this.showAllData()}</tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default StudioContainer;
