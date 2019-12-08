import React, { Component } from "react";
import axios from 'axios';
//import OneCountryComponent from "../oneCountry/OneCountryComponent";
import OneCountryContainer from "../oneCountry/OneCountryContainer";

class ListOfInventorsContainer extends Component {

  constructor(props) {
    super(props);
    this.state = {
        inventors: []
    };
  }

  componentDidMount() {
    console.log(" === ListOfInventorsContainer, componentDidMount started.");
    console.log(" === axios.get url yra ---> ");
    console.log('http://localhost:8081/api/inventors');
      axios
          .get('http://localhost:8081/api/inventors')
          .then((response) => {
              this.setState({ inventors: response.data });
              console.log(" === axios get'intu inventoriu sarasas yra ---> ");
              console.log(this.state.inventors);
          })
          .catch((error) => {
              console.log(" === Nepavyko. Klaidos pranesimas:")
              console.log(error);
          });
  }

  render() {

    const inventorsList = this.state.inventors.map((inventor) => (
      
      <OneCountryContainer
        id={inventor.id}
        key={inventor.title} //pagal si key bus istrinama (taip pat updatinima ir nuskaitoma) ?
        title={inventor.title}
        weight={inventor.weight}
        numberOFsector={inventor.numberOFsector}
        placementData={inventor.placementData}

      >
      </OneCountryContainer>
    ));

    return (
      <div className="container-fluid">
        <h1>YOUR INVENTOR</h1>
        <p>Hi, this is ListOfInventorsContainer</p>
        <div className="row">{inventorsList}</div>
      </div>
    );

  }



}

export default ListOfInventorsContainer;
