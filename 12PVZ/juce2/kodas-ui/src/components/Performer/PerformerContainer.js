import React, { Component } from "react";
import Axios from "axios";
import Button from "../Button";
import Performer from "./Performer";
import PerformerForm from "./PerformerForm";

class PerformerContainer extends Component {
  constructor(props) {
    super(props);
    this.state = { performers: [] };
  }

  getAllData = () => {
    Axios.get("http://localhost:8081/kodas-java/api/performers")
      .then(res => {
        //console.log(res.data);
        this.setState({ performers: res.data });
      })
      .catch(err => {
        console.log(err);
      });
  };

  onDeleteClickHandler = title => {
    console.log(title);
    Axios.delete("http://localhost:8081/kodas-java/api/performers/" + title)
      .then(res => {
        console.log("Deleting: " + title);
        this.getAllData();
      })
      .catch(err => {
        console.log(err);
      });
  };

  showAllData = () => {
    let data = this.state.performers.map((p, index) => {
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
          picture={p.picture}
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

  componentDidMount = () => {
    this.getAllData();
  };

  render() {
    return (
      <div className="container">
        <div className="row my-3">
          <PerformerForm {...this.props} />
        </div>
        <div className="row">
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

export default PerformerContainer;
