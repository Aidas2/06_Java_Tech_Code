import React from 'react';
import NewCartComponent from './NewCartComponent';
import axios from 'axios';
import { withRouter } from 'react-router';

class NewCartContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      description: ''
    };
  }

  handleChangeOfDescription = (event) => {
    this.setState({ description: event.target.value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log("Tai ar yra vartotojas state?")
    console.log(this.state);
    axios.post('http://localhost:8080/api/carts', this.state)
      .then(response => this.props.history.push(`/admin/carts`)) //reikia nurodyti kelią, kur turėtų atsirasti
      .catch(error => {
        alert(error.response.data.message);
        console.log(error);
      });
  }

  componentDidMount() {
    this.usernameToState();
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

  usernameToState() {
    var usernameFromStorage = JSON.parse(sessionStorage.getItem("user"));
    this.setState({ username: usernameFromStorage.username });
  }

  render() {   
    this.fromMenu = "Enter new order data:"
    return (
      <NewCartComponent
        description={this.state.description}
        handleChangeOfDescription={this.handleChangeOfDescription}
        handleSubmit={this.handleSubmit}
        //TO DO Ar reikia šitą perdavinėti?
        fromMenu={this.fromMenu}
      />
    );
  }
}

//TO DO Perdaryti, kad būtų be Rūterio
export default withRouter(NewCartContainer);