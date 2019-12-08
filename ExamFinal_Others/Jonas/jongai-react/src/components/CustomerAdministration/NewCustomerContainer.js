import React from 'react';
import NewCustomerComponet from './NewCustomerComponent';
import axios from 'axios';
import { withRouter } from 'react-router';


class NewHolidayContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: '',
      lastName: '',
      birthday: '',
      phoneNumber: '',
      customerType: '',
      customerTypeList: []
    };
    //var fromMenu;
  }

  handleChangeOfFirstName = (event) => {
    this.setState({ firstName: event.target.value });
  }

  handleChangeOfLastName = (event) => {
    this.setState({ lastName: event.target.value });
  }

  handleChangeOfBirthday = (event) => {
    this.setState({ birthday: event.target.value });
  }

  handleChangeOfPhoneNumber = (event) => {
    this.setState({ phoneNumber: event.target.value });
  }

  handleChangeOfCustomerType = (event) => {
    this.setState({ customerType: event.target.value });
  }

  

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
    axios.post('http://localhost:8080/api/customers', this.state)
      .then(response => {
              console.log(response);
              this.props.history.push(`/`)}) //reikia nurodyti kelią, kur turėtų atsirasti
      .catch((error, response) => {
        console.log(response);
        console.log(error.response.data.message);
        alert(error.response.data.message);
      });
  }

  componentDidMount() {
    //Kai Springas gali atiduoti tipų sąrašą, tada galima jį nuskaityti ir panaudoti
    //Čia nuskaito tipus iš serverio ir sudeda juos į typeList
    // axios
    //   .get("http://localhost:8081/api/users/typesList")
    //   .then(response => {
    //     this.setState({ typeList: response.data.map(item => item.title) });
    //   })
    //   .catch(error => {
    //     console.log(error);
    //   }); 
  }


  render() {
    
    this.fromMenu = "Enter new customer data:"

    return (
        <NewCustomerComponet
          firstName={this.state.firstName}
          lastName={this.state.lastName}
          birthday={this.state.birthday}
          phoneNumber={this.state.phoneNumber}
          customerType={this.state.customerType}
          customerTypeList={this.state.customerTypeList}        
          handleChangeOfFirstName={this.handleChangeOfFirstName}
          handleChangeOfLastName={this.handleChangeOfLastName}
          handleChangeOfBirthday={this.handleChangeOfBirthday}
          handleChangeOfPhoneNumber={this.handleChangeOfPhoneNumber}  
          handleChangeOfCustomerType={this.handleChangeOfCustomerType}
          handleSubmit={this.handleSubmit}
          //TO DO Ar reikia šitą perdavinėti?
          fromMenu={this.fromMenu}
        />
    );
  }
}

//TO DO Perdaryti, kad būtų be Rūterio
export default withRouter(NewHolidayContainer);