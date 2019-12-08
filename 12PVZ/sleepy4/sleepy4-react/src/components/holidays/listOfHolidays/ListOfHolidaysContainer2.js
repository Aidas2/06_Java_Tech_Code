import React, { Component } from "react";
import axios from 'axios';
import OneHolidayComponent from "../oneHoliday/OneHolidayComponent";
import OneHolidayContainer from "../oneHoliday/OneHolidayContainer";
import ListOfHolidaysContainer from "./ListOfHolidaysContainer"

class ListOfHolidaysContainer2 extends Component {

  constructor() {
    super();
    this.state = {
      sarasiukas: null
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/holidays")
      .then(response =>
        this.setState({
          sarasiukas: response.data
        })
      )
      .catch(error => console.log(error));
  }

  render() {
    if (this.state.holidayList === null) {
      return <p>There is no holidays</p>;
    } else {
      //return <OneHolidayContainer holidayList={this.state.holidayList}></OneHolidayContainer>;
      //return <OneHolidayComponent holidayList={this.state.holidayList}></OneHolidayComponent>;
      return <ListOfHolidaysContainer
      holidayList={this.state.sarasiukas}>KAS CIA VYKSTA ?</ListOfHolidaysContainer>;
    }
  }
}

export default ListOfHolidaysContainer2;
