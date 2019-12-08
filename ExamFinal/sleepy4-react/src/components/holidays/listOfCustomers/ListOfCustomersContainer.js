import React, { Component } from "react";
import axios from 'axios';
//import OneCustomerComponent from "../oneCustomer/OneCustomerComponent";
import OneCustomerContainer from "../oneCustomer/OneCustomerContainer";

import image from '../oneCustomer/customer.png';

class ListOfCustomersContainer extends Component {

  constructor(props) {
    super(props);
    this.state = {
        customers: []
    };
  }

  componentDidMount() {
    console.log(" === ListOfCustomersContainer, componentDidMount started.");
    console.log(" === axios.get url yra ---> ");
    console.log('http://localhost:8081/api/customers');
      axios
          .get('http://localhost:8081/api/customers')
          .then((response) => {
              this.setState({ customers: response.data });
              console.log(" === axios get'intu klientu sarasas yra ---> ");
              console.log(this.state.customers);
          })
          .catch((error) => {
              console.log(" === Nepavyko. Klaidos pranesimas:")
              console.log(error);
          });
  }

  render() {
    
    const customersList = this.state.customers.map((customer) => (
      
      <OneCustomerContainer
        id={customer.id}
        key={customer.name} //pagal si key bus istrinama (taip pat updatinima ir nuskaitoma) ?
        name={customer.name}
        surname={customer.surname}
        birthDate={customer.birthDate}
        phoneNumber={customer.phoneNumber}
        type={customer.type}
      >
      </OneCustomerContainer>
    ));


    return (
      <div className="container-fluid">
        <h1>KLIENTŲ SĄRAŠAS</h1>
        <p>Hi, this is ListOfCustomersContainer</p>
        <div className="row">{customersList}</div>
      </div>
    );

  }



}

export default ListOfCustomersContainer;
