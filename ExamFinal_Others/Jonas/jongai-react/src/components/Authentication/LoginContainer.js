import React, { Component } from "react";
import Axios from "axios";
import LoginComponent from "./LoginComponent";

export default class LoginContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      wrongUsernameOrPassword: false,
      password: "",
      username: "",
      errorMessage: ""
    };
  }

  componentDidMount = () => {
    this.props.history.push("/");
  };

  onUsernameChange = event => {
    this.setState({
      username: event.target.value,
      wrongUsernameOrPassword: false
    });
  };
  onPassChange = event => {
    this.setState({
      password: event.target.value,
      wrongUsernameOrPassword: false
    });
  };

  onSubmit = event => {
    event.preventDefault();
    let data = {
      usernameOrEmail: this.state.username,
      password: this.state.password
    };

    Axios.post("http://localhost:8080/api/auth/signin", data)
      .then(res => {
        sessionStorage.setItem(
          "accessToken",
          JSON.stringify(res.data.accessToken)
        );
        Axios.defaults.headers.Authorization = `Bearer ${JSON.parse(
          sessionStorage.getItem("accessToken")
        )}`;
        Axios.get("http://localhost:8080/api/users/me")
          .then(ress => {
            sessionStorage.setItem("user", JSON.stringify(ress.data));
            this.props.setLoggedState();
          })
          .catch(err => {
            console.log(err);
          });
      })
      .catch(e => {
        //console.log("Klaida - " + e.response.data.message);
        console.log("Klaida - " + e.response);
        this.setState({
          wrongUsernameOrPassword: true,
          //errorMessage: e.response.data.message
        });
        alert("Bad username or password");
      });
  };

  render() {
    return (
      <LoginComponent
        error={this.state.errorMessage}
        wrongUsernameOrPassword={this.state.wrongUsernameOrPassword}
        username={this.state.username}
        password={this.state.password}
        onUsernameChange={this.onUsernameChange}
        onPassChange={this.onPassChange}
        onSubmit={this.onSubmit}
      />
    );
  }
}
