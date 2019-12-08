import React from 'react';
import NewCountryComponent from './NewCountryComponent';
import axios from 'axios';
import { withRouter } from 'react-router';

class NewCountryContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      title: '',
      image: '',
      president: ''
    };
  }

  handleChangeOfTitle = (event) => {
    this.setState({ title: event.target.value });
  }

  handleChangeOfImage = (event) => {
    this.setState({ image: event.target.value });
  }

  handleChangeOfPresident = (event) => {
    this.setState({ president: event.target.value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
    axios.post('http://localhost:8080/api/countries', this.state)
      .then(response => this.props.history.push(`/admin/countries`)) //reikia nurodyti kelią, kur turėtų atsirasti
      .catch(error => {
        alert(error.response.data.message);
        console.log(error);
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
    
    this.fromMenu = "Enter new country data:"

    return (
      <NewCountryComponent
        title={this.state.title}
        image={this.state.image}
        president={this.state.president}
        handleChangeOfTitle={this.handleChangeOfTitle}
        handleChangeOfImage={this.handleChangeOfImage}
        handleChangeOfPresident={this.handleChangeOfPresident}
        handleSubmit={this.handleSubmit}
        //TO DO Ar reikia šitą perdavinėti?
        fromMenu={this.fromMenu}
      />
    );
  }
}

//TO DO Perdaryti, kad būtų be Rūterio
export default withRouter(NewCountryContainer);