import React, {Component} from "react";
import {Link} from "react-router-dom"; 
import axios from "axios";
import OneCustomerComponent from "./OneCustomerComponent";

class OneCustomerContainer extends Component{
    constructor(props){
        super(props);
        this.state = {
            name: "ThisIsANameFromConstructor",
            surname: "ThisIsASurnameFromConstructor",
            birthDate: "2019-06-01",
            phoneNumber: "+37064726288",
            type: "USUAL",
            inventories: [],
            inventory: ""
        };
    }
      

    handleDelete = (event) => {
        event.preventDefault();
        console.log(" === Startavo OneCustomerContainer, handleDelete.")
        console.log(" === axios.delete url yra ---> ")
        console.log('http://localhost:8081/api/customers/delete/' + (this.props.name));
        axios.delete('http://localhost:8081/api/customers/delete/' + (this.props.name))
        .then((response) => {
            console.log(" === Pavyko ! Istrinta ---> " + this.props.name);
            console.log(response);
            this.props.history.go("/admin"); //this is link where we returning after push
            
        })
        .catch(function (error) {
            console.log(" === Nepavyko. Neistrinta nes ---> ");
            console.log(error);
        });
    }
    
    render() {
        return(
            <div>

                <OneCustomerComponent
                    handleDelete={this.handleDelete}
                    onClickAddInventory={this.onClickAddInventory}

                    name={this.props.name}
                    surname={this.props.surname}
                    birthDate={this.props.surname}
                    birthDate = {this.props.birthDate}
                    phoneNumber = {this.props.phoneNumber}
                    type = {this.props.type}
                >
                </OneCustomerComponent>
                
            </div>
        );
    }
}

export default OneCustomerContainer;
