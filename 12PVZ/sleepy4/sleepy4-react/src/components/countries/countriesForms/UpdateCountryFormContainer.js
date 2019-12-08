import React, {Component} from 'react';
import axios from 'axios';
import UpdateCountryFormComponent from "./UpdateCountryFormComponent";

class UpdateCountryFormContainer extends Component {

    constructor (props) {
        super(props);
        this.state = {
            title: "This is a title from constructor",
            imageOfFlag: 'nera',
            president: 'Simonyte',
            area: "1000",
            population: "15.05",

            // countries: [],
            // country: ""
        };
    }

    componentDidMount() {

        console.log(" === UpdateCountryFormContainer, componentDidMount method started.");
        console.log(" === axios.get url (vienos salies) yra ---> ");
        console.log('http://localhost:8081/api/countries/' + (this.state.title));
        console.log('http://localhost:8081/api/countries/' + (this.props.match.params.title));

        //axios.get('http://localhost:8081/api/countries/' + (this.state.title))
        axios.get('http://localhost:8081/api/countries/' + (this.props.match.params.title)) // YES !!!!
            .then((response) => {
                //console.log(response.data);
                console.log(" === this. state iki atnaujinimo ---> ");
                console.log(this.state);

                this.setState({title: response.data.title});                
                this.setState({imageOfFlag: response.data.imageOfFlag});
                this.setState({president: response.data.president});
                this.setState({area: response.data.area});
                this.setState({population: response.data.population});
                
                // this.setState({countries: response.data.countries})
                // this.setState({country:response.data.country})
                
                console.log(" === this.state po atnaujinimo ---> ");
                console.log(this.state);
              })
            .catch((error) => {
                console.log("axios Update didn't get successfuly :( ---> " + error);
              });

        // axios.get("http://localhost:8081/api/countries")
        // .then(res => this.setState({ countries: res.data }))
        // .catch();
    }

    handleChangeOfTitle = (event) => {
        this.setState({title: event.target.value});
    }

    handleChangeOfImageOfFlag = (event) => {
        this.setState({imageOfFlag: event.target.value});
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
        console.log(" === UpdateCountryFormContainer, handleSubmit method started.");       
        console.log(" === axios.PUT url is ---> ");
        console.log('http://localhost:8081/api/countries/' + (this.state.title));

        axios.put('http://localhost:8081/api/countries/' + (this.state.title), this.state)
            .then((response) => {
                console.log("axios Update PUT posted successfuly :) ---> Response: ");
                console.log(response);
                this.props.history.go("/countries"); //this is link where we returning after put
              })
            .catch((error) => {
                console.log("axios Update PUT didn't posted successfuly :( ---> " + error);
              });

    }

    // handleDelete = (event) => {
    //     event.preventDefault();
    //     axios.delete('http://localhost:8081/api/Countrys/delete/' + (this.state.title))
    //     .then((response) => {
    //         console.log(response);
    //     })
    //     .catch(function (error) {
    //         console.log(error);
    //     });
    // }

    handleDelete = (event) => {
        event.preventDefault();

        console.log(" === Startavo UpdateCountryFormContainer, handleDelete.")
        console.log(" === axios.DELETE url yra ---> ")
        console.log('http://localhost:8081/api/countries/delete/' + (this.state.title));

        axios.delete('http://localhost:8081/api/countries/delete/' + (this.state.title))
        .then((response) => {
            console.log(" === Pavyko ! Istrinta ---> " + this.state.title);
            console.log(response);
            this.props.history.go("/countries"); //this is link where we returning after push
        })
        .catch(function (error) {
            console.log(" === Nepavyko. Neistrinta nes ---> ");
            console.log(error);
        });
    }

    // onClickAddCountry = () => {

    //     console.log(" === Startavo UpdateCountryFormContainer, onClickAddCountry.")
    //     console.log(" === axios.PUT url yra ---> ")
    //     console.log("http://localhost:8081/api/Countrys/" + this.props.match.params.title + "/" + this.state.country);
    //     console.log(" === this.state.country --->")
    //     console.log(this.state.country)
    //     console.log(" === virs manes yra this.state.country")

    //     axios.put(
    //       "http://localhost:8081/api/Countrys/" + this.props.match.params.title + "/" + this.state.country
    //     )
    //       .then(response => {console.log(response)
    //         console.log(" === Pavyko ! Prideta ---> " + this.state.country);
    //     })
    //       .catch(err => console.log(err));
    //   };

    render () {
        this.fromMenu = "Hi, this is UpdateCountryFormContainer. Country to update:"
        
        return (
            <UpdateCountryFormComponent
            handleChangeOfTitle={this.handleChangeOfTitle}
            handleChangeOfImageOfFlag={this.handleChangeOfImageOfFlag}
            handleChangeOfPresident={this.handleChangeOfPresident}
            handleChangeOfArea={this.handleChangeOfArea}
            handleChangeOfPopulation={this.handleChangeOfPopulation}

            handleSubmit={this.handleSubmit}
            handleDelete={this.handleDelete}
            fromMenu={this.fromMenu}
            //onClickAddCountry={this.onClickAddCountry}

            title={this.state.title}
            imageOfFlag={this.state.imageOfFlag}
            president={this.state.president}
            area={this.state.area}
            population={this.state.population}

          >
          </UpdateCountryFormComponent>
        );
    }
}

export default UpdateCountryFormContainer;