import React from "react";
import CountryComponent from "./CountryComponent";
import Axios from "axios";

class CountryContainer extends React.Component{
    constructor(props){
        super(props);
        this.state={countries:[]}
    }

    getAllDataFromServer = () =>{
        Axios.get("http://localhost:8080/api/countries/")
        
        .then(response=>{
            this.setState({countries:response.data});
        })
        .catch(error=>{
            console.log(error);
        });
    }

    componentDidMount =() =>{
        this.getAllDataFromServer();
    }

    // onDeleteHandler = (title) =>{
    //     Axios.delete("http://localhost:8080/api/holidays/"+title)
    //     .then(()=>{
    //         this.getAllDataFromServer();
    //     })
    //     .catch(erro=>{
    //         console.log(erro);
    //     })
    // }
    
    showAllData = () =>{
        let allcountries = this.state.countries.map(country=>{
            return(
//                <HolidayComponent onDeleteClick={() => this.onDeleteHandler()} key={holiday.title} title={holiday.title} description={holiday.description}></HolidayComponent>
                <CountryComponent 
                key={country.title} 
                title={country.title} 
                president={country.president} 
                imageOfFlag={country.imageOfFlag}></CountryComponent>
            );
        });
        return allcountries;
    }
    
    render(){
        return(
            <div className="container">
                <div className="row">
                    {this.showAllData()}
                </div>
            </div>
        );
    }
}

export default CountryContainer;
