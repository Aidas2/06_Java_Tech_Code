import React from 'react';
import NewUserComponet from './NewUserComponent';
import axios from 'axios';
import { withRouter } from 'react-router';

class NewUserContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      username: '',
      email: '',
      password: '',
      role: 'ROLE_USER'
    };
    //var fromMenu;
  }

  handleChangeOfName = (event) => {
    this.setState({ name: event.target.value });
  }

  handleChangeOfUsername = (event) => {
    this.setState({ username: event.target.value });
  }

  handleChangeOfEmail = (event) => {
    this.setState({ email: event.target.value });
  }

  handleChangeOfPassword = (event) => {
    this.setState({ password: event.target.value });
  }

  handleChangeOfRole = (event) => {
    this.setState({ role: event.target.value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
    axios.post('http://localhost:8080/api/auth/signup', this.state)
      .then(response => this.props.history.push(`/admin/holidays`)) //reikia nurodyti kelią, kur turėtų atsirasti
      .catch(function (error) {
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
    return (
      <NewUserComponet
        name={this.state.name}
        username={this.state.username}
        email={this.state.email}
        password={this.state.password}
        role={this.state.flag}
        handleChangeOfName={this.handleChangeOfName}
        handleChangeOfUsername={this.handleChangeOfUsername}
        handleChangeOfEmail={this.handleChangeOfEmail}
        handleChangeOfPassword={this.handleChangeOfPassword}
        handleChangeOfRole={this.handleChangeOfRole}
        handleSubmit={this.handleSubmit}
      />
    );
  }
}

//TO DO Perdaryti, kad būtų be Rūterio
export default withRouter(NewUserContainer);