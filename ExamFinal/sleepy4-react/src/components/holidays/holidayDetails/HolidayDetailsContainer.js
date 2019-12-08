import React, { Component } from "react";
import HolidayDetailsComponent from "./HolidayDetailsComponent";
import axios from "axios";

class HolidayDetailsContainer extends Component {

  state = {
    //holidayDetails: "niera dietaliu :p",
    holidayDetails: "",
    countriesAssignedToHoliday: ""
  };

  componentDidMount() {
    console.log(" === Startavo HolidayDetailsContainer, componentDidMount");
    console.log(" === axios.get VIENOS sventes url  ---> ");
    console.log("http://localhost:8081/api/holidays/" + this.props.match.params.title);

    console.log(" === holidayDetails iki responso yra --->");
    console.log(this.holidayDetails);
    const holidayParam = this.props.match.params.title;
    console.log(this.props.match.params, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    axios({
      url: "http://localhost:8081/api/holidays/" + this.props.match.params.title,
      //url: "http://localhost:8081/api/holidays/" + this.props.match.params.title + "/countries",
      method: "GET"
      //   params: {
      //     username: "username1"
      //   }
    })
      .then(response => {

        console.log(response.data);

        this.setState({
          holidayDetails: response.data
        });
        console.log(" === 111111111111111111111111111111111111111111111111111111111 --->");
        console.log(this.holidayDetails);
      })
      .catch(error => {
        console.log(error);
      });
      // ====================================================================================================================================
      console.log(" === axios.get VIENOS sventes VISU SALIU url  ---> ");
      console.log("http://localhost:8081/api/holidays/" + this.props.match.params.title +"/countries");

      axios({
        //url: "http://localhost:8081/api/holidays/" + this.props.match.params.title,
        url: "http://localhost:8081/api/holidays/" + this.props.match.params.title +"/countries",
        method: "GET"
        //   params: {
        //     username: "username1"
        //   }
      })
        .then(response => {
  
          console.log(response.data);
  
          this.setState({
            countriesAssignedToHoliday: response.data
          });
          console.log(" === 22222222222222222222222222222222222222222222222222 --->");
          console.log(this.countriesAssignedToHoliday);
        })
        .catch(error => {
          console.log(error);
        });
  }

  render() {
    console.log(this.state.holidayDetails, "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5");
     var countriesTitlesToDisplay = null;
    // if (this.state.holidayDetails.countries) {
    //   countriesTitlesToDisplay = this.state.holidayDetails.countries.map(
    //     country => <li key={country}>{country}</li>

    if (this.state.countriesAssignedToHoliday) {
      countriesTitlesToDisplay = this.state.countriesAssignedToHoliday.map(
        country => <li key={country.id}>{country.title}</li>
      );
    }
    return (
      <HolidayDetailsComponent
        holidayDetails={this.state.holidayDetails}
        countries={countriesTitlesToDisplay}
      />
    );
  }
}

export default HolidayDetailsContainer;
