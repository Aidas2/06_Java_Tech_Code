import React, { Component } from "react";
import LoginContainer from "./LoginContainer";
import NavigationContainer from '../Navigation/NavigationContainer';
import Axios from "axios";

export default class Authentication extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLogged: false,
      submit: false,
      review: false
    };
  }
  setLoggedState = () => {
    this.setState({ isLogged: true });
    //this.getUserGroups();
  };
  componentDidMount = () => {
    //Axios.defaults.baseURL = "/app";
    //this.getUserGroups();
  };

  // turbūt nereikalingas metodas
  getUserGroups = () => {
    Axios.get("/api/users/action/review/")
      .then(res => {
        this.setState({ review: res.data });
      })
      .catch(err => console.log(err));
    Axios.get("/api/users/action/submit/")
      .then(res => {
        this.setState({ submit: res.data });
      })
      .catch(err => console.log(err));
  };

  onClickLogoutHandler = () => {
    this.setState({ isLogged: false });
    sessionStorage.clear("user"); // sessionStorage pats gi išsivalo. Turbūt nereikia čia šito
    sessionStorage.clear("accessToken"); // sessionStorage pats gi išsivalo. Turbūt nereikia čia šito
    delete Axios.defaults.headers.Authorization;
  };

  render() {
    let localData = JSON.parse(sessionStorage.getItem("user"));
    //this.getUserGroups();
    console.log("localData yra " + localData);
    if (localData === null) {
      return (
        <LoginContainer {...this.props} setLoggedState={this.setLoggedState} />
      );
    } else {
      return (
        <NavigationContainer
          {...this.props}
          onClickLogoutHandler={this.onClickLogoutHandler}
        />
      );
    }
  }
}
