import React, { Component } from "react";
import axios from 'axios';
//import OneCountryComponent from "../oneCountry/OneCountryComponent";
import OneCountryContainer from "../oneCountry/OneCountryContainer";

class ListOfCountriesContainer extends Component {

  constructor(props) {
    super(props);
    this.state = {
        countries: []
    };
  }

  componentDidMount() {
    console.log(" === ListOfCountriesContainer, componentDidMount started.");
    console.log(" === axios.get url yra ---> ");
    console.log('http://localhost:8081/api/countries');
      axios
          .get('http://localhost:8081/api/countries')
          .then((response) => {
              this.setState({ countries: response.data });
              console.log(" === axios get'intu saliu sarasas yra ---> ");
              console.log(this.state.countries);
          })
          .catch((error) => {
              console.log(" === Nepavyko. Klaidos pranesimas:")
              console.log(error);
          });
  }

  render() {

    const countriesList = this.state.countries.map((country) => (
      
      <OneCountryContainer
        id={country.id}
        key={country.title} //pagal si key bus istrinama (taip pat updatinima ir nuskaitoma) ?
        title={country.title}
        imageOfFlag={country.imageOfFlag}
        president={country.president}
        area={country.area}
        population={country.population}

      >
      </OneCountryContainer>
    ));

    return (
      <div className="container-fluid">
        <h1>YOUR COUNTRIES</h1>
        <p>Hi, this is ListOfCountrysContainer</p>
        <div className="row">{countriesList}</div>
      </div>
    );

  }



}

export default ListOfCountriesContainer;
