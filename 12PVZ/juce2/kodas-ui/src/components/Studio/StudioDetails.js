import React, { Component } from "react";
import Axios from "axios";
import Studio from "./Studio";
import Button from "../Button";
import Performer from "../Performer/Performer";
import StudioCard from "./StudioCard";

import NoImg from "../../images/no_picture.png";

class StudioDetails extends Component {
  constructor(props) {
    super(props);
    this.state = { studio: "", performers: [] };
  }

  componentDidMount() {
    Axios.get(
      "http://localhost:8081/kodas-java/api/studios/" +
        this.props.match.params.title
    )
      .then(res => {
        console.log(res.data);
        this.setState({ studio: res.data });
      })
      .catch(err => {
        console.log(err);
      });

    this.getAllPerformers();
  }

  getAllPerformers = () => {
    Axios.get(
      "http://localhost:8081/kodas-java/api/studios/" +
        this.props.match.params.title +
        "/all-performers"
    )
      .then(res => {
        console.log(res.data);
        this.setState({ performers: res.data });
      })
      .catch(err => {
        console.log(err);
      });
  };

  onClickGoBackHandler = () => {
    this.props.history.goBack();
  };

  onClickUpdateHandler = () => {
    this.props.history.push("/studios/update/" + this.props.match.params.title);
  };

  onDeleteClickHandler = title => {
    Axios.delete(
      "http://localhost:8081/kodas-java/api/studios/" +
        this.state.service.title +
        "/" +
        title
    )
      .then(res => {
        console.log(res);
        this.getAllPerformers();
      })
      .catch(err => {
        console.log(err);
      });
  };

  showAllData = () => {
    let data = this.state.performers.map((p, index) => {
      let img;
      if (p.picture === "null" || p.picture === null) {
        img = NoImg;
      } else {
        img = p.picture;
      }
      return (
        <Performer
          key={p.title}
          index={index + 1}
          title={p.title}
          firstName={p.firstName}
          lastName={p.lastName}
          genre={p.genre}
          country={p.country}
          dob={p.dob}
          picture={img}
          {...this.props}
        >
          <Button
            title="Delete"
            action={() => this.onDeleteClickHandler(p.title)}
            type="btn-warning"
          />
        </Performer>
      );
    });
    return data;
  };

  render() {
    let img;
    if (this.state.studio.logo === "null" || this.state.studio.logo === null) {
      img = NoImg;
    } else {
      img = this.state.studio.logo;
    }

    let category;
    switch (this.state.studio.category) {
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
      <div className="container my-3">
        <div className="row d-flex justify-content-center">
          <StudioCard
            title={this.state.studio.title}
            category={category}
            size={this.state.studio.size}
            logo={img}
          >
            <Button
              title="Go Back"
              type="btn-warning"
              action={this.onClickGoBackHandler}
            />
            <Button
              title="Update"
              type="btn-warning"
              action={this.onClickUpdateHandler}
            />
          </StudioCard>
        </div>
        <div>
          <table className="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">Genre</th>
                <th scope="col">Country</th>
                <th scope="col">DOB</th>
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

export default StudioDetails;
