import React from "react";
import HolidayComponent from "./HolidayComponent";
import Axios from "axios";

class HolidayContainer extends React.Component{
    constructor(props){
        super(props);
        this.state={holidays:[]}
    }

    getAllDataFromServer = () =>{
        Axios.get("http://localhost:8080/api/holidays/")
        
        .then(response=>{
            this.setState({holidays:response.data});
        })
        .catch(error=>{
            console.log(error);
        });
    }

    componentDidMount =() =>{
        this.getAllDataFromServer();
    }

    onDeleteHandler = (title) =>{
        Axios.delete("http://localhost:8080/api/holidays/"+title)
        .then(()=>{
            this.getAllDataFromServer();
        })
        .catch(erro=>{
            console.log(erro);
        })
    }
    
    showAllData = () =>{
        let allholidays = this.state.holidays.map(holiday=>{
            return(
//                <HolidayComponent onDeleteClick={() => this.onDeleteHandler()} key={holiday.title} title={holiday.title} description={holiday.description}></HolidayComponent>
                <HolidayComponent 
                onDeleteClick={() => this.onDeleteHandler()} 
                key={holiday.title} 
                title={holiday.title} 
                description={holiday.description} 
                type={holiday.type}></HolidayComponent>
                );
        });
        return allholidays;
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

export default HolidayContainer;
