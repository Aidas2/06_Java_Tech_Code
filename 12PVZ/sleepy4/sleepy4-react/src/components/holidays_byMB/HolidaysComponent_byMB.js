import React, { Component } from "react";
import Holiday_byMB from "./Holiday_byMB";

// STEP_02. This is is also Component+Container (second). Looks like just Component ---> NO ! This is LIST of single holidays!

class HolidaysComponent_byMB extends Component {

  // no consructor
  // no methods getAllDataFromServer, componentDidMount, handleDelete, showAllData, etc.
  // right away to render:

  render() {

    let holidaysList =   this.props.holidayList.map(holiday => (
      <Holiday_byMB
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
      />
    ));

    return (
      <div className="container-fluid">
        <h1>YOUR HOLIDAYS_versionByMB</h1>
        <div className="row">{holidaysList}</div>
      </div>
    );
    
  }
}

export default HolidaysComponent_byMB;
