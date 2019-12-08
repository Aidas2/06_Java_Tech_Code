import React, {Component} from 'react';
import axios from 'axios';
import NewCountryFormComponent from "./NewCountryFormComponent";

class NewCountryFormContainer extends Component {

    constructor (props) {
        super(props);
        this.state = {
            title: "Country_01",
            imageOfFlag: 'iMaGe',
            president: 'Nauseda',
            area: "1000",
            population: "100000"
        };
    }

    handleChangeOfTitle = (event) => {
        this.setState({title: event.target.value});
    }

    handleChangeOfImageOfFlag = (event) => {
        this.setState({imageOfCountry: event.target.value});
    }

    handleChangeOfPresident = (event) => {
        this.setState({president: event.target.value});
    }

    handleChangeOfArea = (event) => {
        this.setState({area: event.target.value});
    }

    handleChangeOfPopulation = (event) => {
        this.setState({population: event.target.value});
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(" === NewCountryFormContainer, handleSubmit method started");
        console.log(" === axios.post url yra: ")        
        console.log('http://localhost:8081/api/countries', this.state);
        axios.post('http://localhost:8081/api/countries', this.state)
            .then(response => {
                console.log(" === axios posted successfuly :)");                
                console.log(response);
                this.props.history.go("/Countries"); //this is link where we returning after push
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
        const fromMenu = "Hi, this is NewCountryFormContainer (as variable)."
        return (
            <div>
                <p>NewCountryFormContainer (as text in paragraph)</p>
                <NewCountryFormComponent
                handleChangeOfTitle={this.handleChangeOfTitle}
                handleChangeOfImageOfFlag={this.handleChangeOfImageOfFlag}
                handleChangeOfPresident={this.handleChangeOfPresident}
                handleChangeOfArea={this.handleChangeOfArea}
                handleChangeOfPopulation={this.handleChangeOfPopulation}
                handleSubmit={this.handleSubmit}
                fromMenu={fromMenu}
            >
            </NewCountryFormComponent>
            </div>
 
        );
    }
}

export default NewCountryFormContainer;