import React from "react";
import ReactDOM from "react-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./styles.css";
import { Switch, Route } from "react-router";
import { BrowserRouter } from "react-router-dom";
import App from "./App";
import NewUserForm from "./components/Forms/NewUserForm";
import UsersContainer from "./components/Users/UsersContainer";
import NewItemForm from "./components/Forms/NewItemForm";
import UpdateItemForm from "./components/Forms/UpdateItemForm";
import ItemsContainer from "./components/Items/ItemsContainer"
import UserView from "./components/Users/UserView";

ReactDOM.render(
  <BrowserRouter>
    <App>
      <Switch>
        <Route exact path="/" component={UsersContainer} />
        <Route exact path="/add-item/:id" component={NewItemForm}/>
        <Route exact path="/update-item/:id" component={UpdateItemForm}/>
        <Route exact path="/user/:id" component={UserView} />
        <Route exact path="/new-user" component={NewUserForm} />
        <Route exact path="/items/:id" component={ItemsContainer} />
        <Route exact path="/reports" />
      </Switch>
    </App>
  </BrowserRouter>,
  document.getElementById("root")
);
