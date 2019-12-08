import React, {Component} from "react";
import AdministrationComponent from "./AdministrationComponent";

class AdministrationContainer extends React.Component {

  constructor() {
    super();
    this.state = {};
  }

  render() {
    return(

      <div>
        <p>Hi, this is AdministrationContainer</p>
        <AdministrationComponent>
          
        </AdministrationComponent>
      </div>

    );
  }
} 

export default AdministrationContainer;