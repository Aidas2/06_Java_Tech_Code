import React, {Component} from 'react';
import axios from 'axios';
import UpdateHolidayFormComponent from "./UpdateHolidayFormComponent";

class UpdateHolidayFormContainer extends Component {

    constructor (props) {
        super(props);
        this.state = {
            title: "This is a title from constructor",
            description: "updated from UPDATE constructor",
            type: "standart",
            imageOfHoliday: 'nonono',
            isFlagRaised: 'TRUE',
            hireDate: "2019-06-01",
            distance: "10",
            price: "15.05",
            countries: [],
            country: ""
        };
    }

    componentDidMount() {

        console.log(" === UpdateHolidayFormContainer, componentDidMount method started.");
        console.log(" === axios.get url (vienos sventes) yra ---> ");
        console.log('http://localhost:8081/api/holidays/' + (this.state.title));
        console.log('http://localhost:8081/api/holidays/' + (this.props.match.params.title));

        //axios.get('http://localhost:8081/api/holidays/' + (this.state.title))
        axios.get('http://localhost:8081/api/holidays/' + (this.props.match.params.title)) // YES !!!!
            .then((response) => {
                //console.log(response.data);
                console.log(" === this. state iki atnaujinimo ---> ");
                console.log(this.state);

                this.setState({title: response.data.title});
                this.setState({description: response.data.description});                
                this.setState({type: response.data.type});                
                this.setState({imageOfHoliday: response.data.imageOfHoliday});
                this.setState({isFlagRaised: response.data.isFlagRaised});
                this.setState({hiredate: response.data.hireDate});
                this.setState({distance: response.data.distance});
                this.setState({price: response.data.price});
                
                this.setState({countries: response.data.countries})
                this.setState({country:response.data.country})
                
                console.log(" === this.state po atnaujinimo ---> ");
                console.log(this.state);
              })
            .catch((error) => {
                console.log("axios Update didn't get successfuly :( ---> " + error);
              });

        axios.get("http://localhost:8081/api/countries")
          .then(res => this.setState({ countries: res.data }))
          .catch();
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
        console.log(" === UpdateHolidayFormContainer, handleSubmit method started.");       
        console.log(" === axios.PUT url is ---> ");
        console.log('http://localhost:8081/api/holidays/' + (this.state.title));

        axios.put('http://localhost:8081/api/holidays/' + (this.state.title), this.state)
            .then((response) => {
                console.log("axios Update PUT posted successfuly :) ---> Response: ");
                console.log(response);
                this.props.history.go("/holidays"); //this is link where we returning after put
              })
            .catch((error) => {
                console.log("axios Update PUT didn't posted successfuly :( ---> " + error);
              });

    }

    // handleDelete = (event) => {
    //     event.preventDefault();
    //     axios.delete('http://localhost:8081/api/holidays/delete/' + (this.state.title))
    //     .then((response) => {
    //         console.log(response);
    //     })
    //     .catch(function (error) {
    //         console.log(error);
    //     });
    // }

    handleDelete = (event) => {
        event.preventDefault();

        console.log(" === Startavo UpdateHolidayFormContainer, handleDelete.")
        console.log(" === axios.DELETE url yra ---> ")
        console.log('http://localhost:8081/api/holidays/delete/' + (this.state.title));

        axios.delete('http://localhost:8081/api/holidays/delete/' + (this.state.title))
        .then((response) => {
            console.log(" === Pavyko ! Istrinta ---> " + this.state.title);
            console.log(response);
            this.props.history.go("/holidays"); //this is link where we returning after push
        })
        .catch(function (error) {
            console.log(" === Nepavyko. Neistrinta nes ---> ");
            console.log(error);
        });
    }

    // availableCountry = () => {
    //     console.log("=== Galimos salys yra:");
    //     console.log(this.state.countries);
    //     let countries = this.state.countries.map(c => {
    //       return (
    //         <option key={c.title} value={c.title}>
    //           {c.title}
    //         </option>
    //       );
    //     });
    //     return countries;
    //   };


    // @RequestMapping(value = "api/holidays")
    // @PutMapping("/{titleOfHoliday}/countries/{titleOfCountry}")
    // onClickAddCountry = () => {
    //     console.log(" === UpdateHolidayFormContainer, onClickAddCountry() method started.");
    //     console.log(" === axios.put url yra ---> ");
    //     console.log("http://localhost:8081/api/holidays/" + this.state.title + "/countries/" + this.state.country);
    //     //console.log("http://localhost:8081/api/holidays/" + this.props.match.params.title + "/countries/" + this.state.country);

    //     axios.put("http://localhost:8081/api/holidays/" + this.state.title + "/countries/" + this.state.country)
    //       .then(response => {
    //           console.log(" === Pavyko ! Prie " + this.props.match.params.title + " prijungta ---> " + this.state.country);
    //           console.log(response)})
    //       .catch(err => {
    //           console.log(" === Nepavyko. Neprijungta nes ---> ")
    //           console.log(err)});
    //   };

    render () {
        this.fromMenu = "Hi, this is UpdateHolidayFormContainer. Holiday to update:"
        
        return (
            <div>
                <UpdateHolidayFormComponent
                handleChangeOfTitle={this.handleChangeOfTitle}
                handleChangeOfDescription={this.handleChangeOfDescription}
                handleChangeOfType={this.handleChangeOfType}
                handleChangeOfImageOfHoliday={this.handleChangeOfImageOfHoliday}
                handleChangeOfIsFlagRaised={this.handleChangeOfIsFlagRaised}
                handleChangeOfHireDate={this.handleChangeOfHireDate}
                handleChangeOfDistance={this.handleChangeOfDistance}
                handleChangeOfPrice={this.handleChangeOfPrice}

                handleSubmit={this.handleSubmit}
                handleDelete={this.handleDelete}
                fromMenu={this.fromMenu}
                onClickAddCountry={this.onClickAddCountry}

                title={this.state.title}
                description={this.state.description}
                type={this.state.type}
                imageOfHoliday={this.state.imageOfHoliday}
                isFlagRaised={this.state.isFlagRaised}
                hireDate={this.state.hireDate}
                distance={this.state.distance}
                price={this.state.price}

                >
                </UpdateHolidayFormComponent>

                {/* <div>Add Country</div>
                <div className="form-group mb-4">
                <select
                    id="inlineFormCustomSelect"
                    className="form-control"
                    name="country"
                    value={this.state.countries}
                    // onChange={this.handleChange}
                >
                    <option defaultValue hidden>
                    Choose here
                    </option>
                    {this.availableCountry()}
                </select>
                <button
                    className="btn btn-warning"
                    onClick={() => this.onClickAddCountry()}
                >
                    Add Country from List
                </button>
                </div> */}

            </div>

        );
    }
}

export default UpdateHolidayFormContainer;