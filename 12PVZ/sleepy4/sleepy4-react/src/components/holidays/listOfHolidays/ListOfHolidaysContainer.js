import React, { Component } from "react";
import axios from 'axios';
//import OneHolidayComponent from "../oneHoliday/OneHolidayComponent";
import OneHolidayContainer from "../oneHoliday/OneHolidayContainer";

import image from '../oneHoliday/holiday1.jpg';
import easter from '../oneHoliday/easter.jpg';
import jonines from '../oneHoliday/jonines.jpg';
import christmas from '../oneHoliday/christmas.jpg';

class ListOfHolidaysContainer extends Component {

  constructor(props) {
    super(props);
    this.state = {
        holidays: []
    };
  }

  componentDidMount() {
    console.log(" === ListOfHolidaysContainer, componentDidMount started.");
    console.log(" === axios.get url yra ---> ");
    console.log('http://localhost:8081/api/holidays');
      axios
          .get('http://localhost:8081/api/holidays')
          .then((response) => {
              this.setState({ holidays: response.data });
              console.log(" === axios get'intu svenciu sarasas yra ---> ");
              console.log(this.state.holidays);
          })
          .catch((error) => {
              console.log(" === Nepavyko. Klaidos pranssimas:")
              console.log(error);
          });
  }

  render() {

    // var actualImage = this.state.holidays.map((holiday) => {
    //   var paveiksliukoObjektas = easter;
    //   if (holiday.imageOfHoliday === "jonines") {
    //     paveiksliukoObjektas = jonines;
    //   }
    //   if (holiday.imageOfHoliday === "christmas") {
    //     paveiksliukoObjektas === christmas;
    //   }
    //   return 
    //   imageOfHoliday={actualImage}
    // });
    
    const holidaysList = this.state.holidays.map((holiday) => (
      
      <OneHolidayContainer
        id={holiday.id}
        key={holiday.title} //pagal si key bus istrinama (taip pat updatinima ir nuskaitoma) ?
        title={holiday.title}
        description={holiday.description}
        type={holiday.type}
        imageOfHoliday={holiday.imageOfHoliday}
        isFlagRaised={holiday.isFlagRaised}
        hireDate={holiday.hireDate}
        distance={holiday.distance}
        price={holiday.price}

      >
      </OneHolidayContainer>
    ));


    return (
      <div className="container-fluid">
        <h1>YOUR HOLIDAYS</h1>
        <p>Hi, this is ListOfHolidaysContainer</p>
        <div className="row">{holidaysList}</div>
      </div>
    );

  }



}

export default ListOfHolidaysContainer;
