import React, { Component } from "react";
import axios from "axios";
import HolidaysComponent_byMB from "./HolidaysComponent_byMB";

// STEP_03. This is also Component+Container (third). But more like List implementation.

class HolidaysContainer_byMB extends Component {
  constructor() {
    super();
    this.state = {
      holidayList: null
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/holidays")
      .then(response =>
        this.setState({
          holidayList: response.data
        })
      )
      .catch(error => console.log(error));
  }

  render() {
    if (this.state.holidayList === null) {
      return <p>There is no holidays</p>;
    } else {
      return <HolidaysComponent_byMB holidayList={this.state.holidayList}></HolidaysComponent_byMB>;
    }
  }
}

export default HolidaysContainer_byMB;
