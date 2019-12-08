import React, {Component} from "react";
import {Link} from "react-router-dom"; 
import axios from "axios";
import OneCountryComponent from "./OneCountryComponent";

class OneCountryContainer extends Component{
    constructor(props){
        super(props);
        this.state = {};
    }

    handleDelete = (event) => {
        event.preventDefault();
        console.log(" === Startavo OneCountryContainer, handleDelete.")
        console.log(" === axios.delete url yra ---> ")
        console.log('http://localhost:8081/api/inventors/delete/' + (this.props.title));
        axios.delete('http://localhost:8081/api/inventors/delete/' + (this.props.title))
        .then((response) => {
            console.log(" === Pavyko ! Istrinta ---> " + this.props.title);
            console.log(response);
            this.props.history.go("/admin"); //this is link where we returning after push
            //this.props.history.go("/holidays"); //this is link where we returning after push
            
        })
        .catch(function (error) {
            console.log(" === Nepavyko. Neistrinta nes ---> ");
            console.log(error);
        });
    }
    
    render(){
        return(
            <div>

                <OneCountryComponent
                    handleDelete={this.handleDelete}
                    
                    title={this.props.title}
                    weight={this.props.weight}
                    numberOfSector={this.props.numberOfSector}
                    placementDate={this.props.placementDate}            
                >
                </OneCountryComponent>

            </div>
        );
    }
}

export default OneCountryContainer;
