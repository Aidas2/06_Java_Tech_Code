import React, {Component} from 'react';
import axios from 'axios';
import NewHolidayFormComponent from "./NewHolidayFormComponent";

class NewHolidayFormContainer extends Component {

    constructor (props) {
        super(props);
        this.state = {
            title: "HOLIDAY_01",
            description: "added from NEW constructor",
            type: "standart",
            imageOfHoliday: 'iMaGe',
            isFlagRaised: 'TRUE',
            hireDate: "2019-06-25",
            distance: "100",
            price: "99.95"
        };
    }

    handleChangeOfTitle = (event) => {
        this.setState({title: event.target.value});
    }
    
    handleChangeOfType = (event) => {
        this.setState({type: event.target.value});
    }

    handleChangeOfDescription = (event) => {
        this.setState({description: event.target.value});
    }

    handleChangeOfImageOfHoliday = (event) => {
        this.setState({imageOfHoliday: event.target.value});
    }

    handleChangeOfIsFlagRaised = (event) => {
        this.setState({isFlagRaised: event.target.value});
    }

    handleChangeOfHireDate = (event) => {
        this.setState({hireDate: event.target.value});
    }

    handleChangeOfDistance = (event) => {
        this.setState({distance: event.target.value});
    }

    handleChangeOfPrice = (event) => {
        this.setState({price: event.target.value});
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(" === NewHolidayFormContainer, handleSubmit method started");
        console.log(" === axios.post url yra: ")        
        console.log('http://localhost:8081/api/holidays', this.state);
        axios.post('http://localhost:8081/api/holidays', this.state)
            .then(response => {
                console.log(" === axios posted successfuly :)");                
                console.log(response);
                this.props.history.go("/holidays"); //this is link where we returning after push
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
        const fromMenu = "Hi, this is NewHolidayFormContainer (as variable)."
        return (
            <div>
                <p>NewHolidayFormContainer (as text in paragraph)</p>
                <NewHolidayFormComponent
                handleChangeOfTitle={this.handleChangeOfTitle}
                handleChangeOfDescription={this.handleChangeOfDescription}
                handleChangeOfType={this.handleChangeOfType}
                handleChangeOfImageOfHoliday={this.handleChangeOfImageOfHoliday}
                handleChangeOfIsFlagRaised={this.handleChangeOfIsFlagRaised}
                handleChangeOfHireDate={this.handleChangeOfHireDate}
                handleChangeOfDistance={this.handleChangeOfDistance}
                handleChangeOfPrice={this.handleChangeOfPrice}
                handleSubmit={this.handleSubmit}
                fromMenu={fromMenu}
            >
            </NewHolidayFormComponent>
            </div>
 
        );
    }
}

export default NewHolidayFormContainer;