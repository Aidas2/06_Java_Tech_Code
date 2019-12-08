import React from 'react';
//import PropTypes from 'prop-types';
import OneCountryComponent from './OneCountryComponent';
import axios from 'axios';

class OneCountryContainer extends React.Component {
  constructor(props, context) {
    super(props, context);
    this.state = {
      countryCode: "",
      title: "",
      image: "",
      president: '',
      addedHolidays: []
    };
  }

  componentDidMount() {
    this.getOneCountry();
    this.getCountryHolidayList();
  }

  getOneCountry() {
    const position = this.props.match.params.countryCode;
    axios.get('http://localhost:8080/api/countries/' + (position))
      .then((response) => {
        this.setState({
          countryCode: response.data.countryCode,
          title: response.data.title,
          image: response.data.image,
          president: response.data.president
        })
      })
      .catch((error) => {
        console.log(error);
      });
  }

  getCountryHolidayList() {
    const position = this.props.match.params.countryCode;
    axios.get('http://localhost:8080/api/countries/' + position + '/addedHolidays')
      .then((response) => {
        this.setState({ addedHolidays: response.data })
      })
      .catch((error) => {
        console.log(error);
      });
  }

  //nenaudojamas
  availableCountrySelectionHandler = event => {
    this.setState({ countriesToAdd: [...event.target.selectedOptions].map(o => o.value) })
  }

  //nenaudojamas
  countryRemovingHandler = event => {
    this.setState({ countriesToRemove: [...event.target.selectedOptions].map(o => o.value) })
  }

  //nenaudojamas
  showAvailableCountries = () => {
    if (this.state.allCountries.length === 0) {
      return (
        <option value="" disabled>
          Nėra šalių pasirinkimui
            </option>
      );
    } else {
      let countries = this.state.allCountries
        .map((country, index) => {

          let isShown = true;

          this.state.addedCountries.forEach((c, index) => {
            if (c === country) {
              isShown = false;
            }
          });

          if (isShown)
            return (
              <option key={country + index} value={country}>
                {country}
              </option>
            );
          else {
            return null;
          }
        })
        .filter(c => c !== null);
      if (countries.length === 0) {
        return (
          <option value="" disabled>
            Visos šalys jau pasirinktos
              </option>
        );
      } else return countries;
    }
  };

  //nenaudojamas
  addCountriesToHoliday = event => {
    const position = this.props.match.params.code;
    axios.put('http://localhost:8080/api/holidays/' + position + '/addingCountries', this.state.countriesToAdd)
      .then(() => this.getHolidayCountryList())
      .catch(function (error) {
        console.log(error);
      });
  }

  //nenaudojamas
  removeCountriesFromHoliday = event => {
    const position = this.props.match.params.code;
    axios.put('http://localhost:8080/api/holidays/' + position + '/removingCountries', this.state.countriesToRemove)
      .then(() => this.getHolidayCountryList())
      .catch(function (error) {
        console.log(error);
      });
  }

  render() {
    if (this.state.countryCode) {
      return (
        <div>
          <OneCountryComponent
            countryCode={this.state.countryCode}
            title={this.state.title}
            image={this.state.image}
            president={this.state.president}
            addedHolidays={this.state.addedHolidays}
          />
        </div>
      );
    } else {
      return (
        <div className="text-center">
            <div className="spinner-border text-danger" role="status">
                <span className="sr-only">Loading data...</span>
            </div>
        </div>        
      );
    } 
  }
}

export default OneCountryContainer;