import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { submitHoliday } from "../../../api/holidays";
import { fetchCountryList } from "../../../api/countries";

class CountryToHolidayForm extends Component {
  constructor() {
    super();
    this.state = {
      allCountryList: [],
      chosenCountryTitle: ""
    };
  }

  componentDidMount() {
    console.log(" === Startavo CountryToHolidayForm, componentDidMount")
    console.log(" === axios.get url yra_EX ---> ")
    console.log("http://localhost:8081/api/countries/");
    fetchCountryList()
      .then(data =>
        this.setState(
          {
            allCountryList: data,
            chosenCountryTitle: data[0].title
          },
          console.log(data)
        )
      )
      .catch(error => console.log(error));
  }

  handleCountryChange(event) {
    console.log(" === Startavo CountryToHolidayForm, handleCountryChange")
    this.setState({
      chosenCountryTitle: event.target.value
    });
  }

  handleSubmit(event) {
    console.log(" === Startavo CountryToHolidayForm, handleSubmit_EX")
    event.preventDefault();

    submitHoliday(this.props.match.params.title, this.state.chosenCountryTitle)
      .then(response => {
        console.log(" === Pavyko ! Prijungta " + this.props.match.params.title + " prie " + this.state.chosenCountryTitle);
        console.log(response);
        this.props.history.push("/holidays");
      })
      .catch(error => {
        console.log(" === Nepavyko :(. Neprijungta nes --->");
        console.log(error)
      });

  }

  // availableCountry() {
  //   return this.state.allCountryList.map(country => (
  //     <option value={country.title}>{country.title}</option>
  //   ));
  // }

  availableCountries() {
    console.log("=== Startavo metodas availableCountries(). Galimos salys yra:");
    console.log(this.state.allCountryList);
    let countries = this.state.allCountryList.map(c => {
      return (
        <option key={c.title} value={c.title}>
          {c.title}
        </option>
      );
    });
    return countries;
  }





  render() {

    this.fromMenu = "Hi, this is CountryToHolidayForm."

    return (
      <div className="container-fluid ">
        <h1>ADD COUNTRY TO HOLIDAY</h1>
        fromMenu={this.fromMenu}

        <form className="container" onSubmit={this.handleSubmit.bind(this)}>
          <div className="form-group">
            <label>Choose a country</label>
            <select
              type="text"
              className="form-control"
              onChange={this.handleCountryChange.bind(this)}
            >
              {this.availableCountries()}
            </select>
          </div>
          <button type="submit" className="btn btn-info">
            Submit
          </button>
        </form>

      </div>
    );
  }
}

export default CountryToHolidayForm;
