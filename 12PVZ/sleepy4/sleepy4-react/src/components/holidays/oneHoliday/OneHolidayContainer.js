import React, {Component} from "react";
import {Link} from "react-router-dom"; 
import axios from "axios";
import OneHolidayComponent from "./OneHolidayComponent";

class OneHolidayContainer extends Component{
    constructor(props){
        super(props);
        this.state = {
            title: "ThisIsATitleFromConstructor",
            description: "assigned from OHC constructor",
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

    // componentDidMount = () => {
    //     // axios.get('http://localhost:8081/api/holidays/' + (this.props.match.params.title))
    //     //   .then(res => {
    //     //     console.log(res.data);
    //     //     this.setState(res.data);
    //     //   })
    //     //   .catch(err => console.log(err));
    
    //     console.log(" === OneHolidayContainer, componentDidMount method started.");
    //     console.log(" === axios.get url (VIENOS sventes) yra ---> ");
    //     //console.log('http://localhost:8081/api/holidays/' + (this.state.title));
    //     console.log('http://localhost:8081/api/holidays/' + (this.props.match.params.title));

    //     axios.get('http://localhost:8081/api/holidays/' + (this.state.title))
    //     //axios.get('http://localhost:8081/api/holidays/' + (this.props.match.params.title)) // YES !!!!
    //         .then((response) => {
    //             //console.log(response.data);
    //             console.log(" === this. state iki atnaujinimo ---> ");
    //             console.log(this.state);

    //             this.setState({title: response.data.title});
    //             this.setState({description: response.data.description});                
    //             this.setState({type: response.data.type});                
    //             this.setState({imageOfHoliday: response.data.imageOfHoliday});
    //             this.setState({isFlagRaised: response.data.isFlagRaised});
    //             this.setState({hiredate: response.data.hireDate});
    //             this.setState({distance: response.data.distance});
    //             this.setState({price: response.data.price});
                
    //             this.setState({countries: response.data.countries})
    //             this.setState({country:response.data.country})
                
    //             console.log(" === this.state po atnaujinimo ---> ");
    //             console.log(this.state);
    //           })
    //         .catch((error) => {
    //             console.log("axios Update didn't get successfuly :( ---> " + error);
    //           });



    //     axios.get("http://localhost:8081/api/countries")
    //       .then(res => this.setState({ countries: res.data }))
    //       .catch();
    //   };
      

    handleDelete = (event) => {
        event.preventDefault();
        console.log(" === Startavo OneHolidayContainer, handleDelete.")
        console.log(" === axios.delete url yra ---> ")
        console.log('http://localhost:8081/api/holidays/delete/' + (this.props.title));
        axios.delete('http://localhost:8081/api/holidays/delete/' + (this.props.title))
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

    // availableCountry = () => {
    //     let countries = this.state.countries.map(c => {
    //       return (
    //         <option key={c.title} value={c.title}>
    //           {c.title}
    //         </option>
    //       );
    //     });
    //     return countries;
    //   };


    // // @RequestMapping(value = "api/holidays")
    // // @PutMapping("/{titleOfHoliday}/countries/{titleOfCountry}")
    // onClickAddCountry = () => {
    //     console.log(" === OneHolidayContainer, onClickAddCountry() method started.");
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
    
    render() {
        return(
            <div>

                <OneHolidayComponent
                    handleDelete={this.handleDelete}
                    onClickAddCountry={this.onClickAddCountry}

                    title={this.props.title}
                    description={this.props.description}
                    type={this.props.type}
                    imageOfHoliday={this.props.imageOfHoliday}
                    isFlagRaised={this.props.isFlagRaised}
                    hireDate={this.props.hireDate}
                    distance={this.props.distance}
                    price={this.props.price}
                >
                </OneHolidayComponent>
             
                {/* <div>Add Country</div>
                <div className="form-group mb-8">
                <select
                    id="inlineFormCustomSelect"
                    className="form-control"
                    name="country"
                    value={this.state.countries}
                    onChange={this.handleChange}
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

export default OneHolidayContainer;
