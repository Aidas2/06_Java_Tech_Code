import React, {Component} from 'react';
import axios from 'axios';
import NewCustomerFormComponent from "./NewCustomerFormComponent";

class NewCustomerFormContainer extends Component {

    constructor (props) {
        super(props);
        this.state = {
            name: "Jonas",
            surname: "Jonaitis",
            birthDate: "2019-06-01",
            phoneNumber: "+37064726288",
            type: "USUAL",
        };
    }

    handleChangeOfName = (event) => {
        this.setState({name: event.target.value});
    }

    handleChangeOfSurname = (event) => {
        this.setState({surname: event.target.value});
    }

    handleChangeOfBirthDate = (event) => {
        this.setState({birthDate: event.target.value});
    }

    handleChangeOfPhoneNumber = (event) => {
        this.setState({phoneNumber: event.target.value});
    }

    handleChangeOfType = (event) => {
        this.setState({type: event.target.value});
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(" === NewCustomerFormContainer, handleSubmit method started");
        console.log(" === axios.post url yra: ")        
        console.log('http://localhost:8081/api/customers', this.state);
        axios.post('http://localhost:8081/api/customers', this.state)
            .then(response => {
                console.log(" === axios posted successfuly :)");                
                console.log(response);
                this.props.history.go("/customers"); //this is link where we returning after push
              })
            .catch(error => {
                console.log(" === axios didn't posted successfuly :(")                
                console.log(error);
              });
    }


    
    componentDidMount() {
        console.log(" === message from EMPTY componentDidMount method. Is he needed at all ? ");
    }

    render () {
        const fromMenu = "Hi, this is NewCustomerFormContainer (as variable)."
        return (
            <div>
                <p>NewCustomerFormContainer (as text in paragraph)</p>
                <NewCustomerFormComponent
                handleChangeOfName={this.handleChangeOfName}
                handleChangeOfSurname={this.handleChangeOfSurname}
                handleChangeOfBirthDate={this.handleChangeOfBirthDate}
                handleChangeOfPhoneNumber={this.handleChangeOfPhoneNumber}
                handleChangeOfType={this.handleChangeOfType}
                handleSubmit={this.handleSubmit}
                fromMenu={fromMenu}
            >
            </NewCustomerFormComponent>
            </div>
 
        );
    }
}

export default NewCustomerFormContainer;