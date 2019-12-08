import React from "react";
import PlaceComponent from "./PlaceComponent";
import axios from "axios";

class PlaceContainer extends React.Component{
    constructor(props){
        super(props);
        this.state={places:[]}
    }

    getAllDataFromServer = () =>{
        axios.get("http://localhost:8081/api/places/")
        
        .then(response=>{
            this.setState({places:response.data});
        })
        .catch(error=>{
            console.log(error);
        });
    }

    componentDidMount =() =>{
        this.getAllDataFromServer();
    }

    handleDelete = (title) =>{
        axios.delete("http://localhost:8081/api/places/"+title)
        .then(()=>{
            this.getAllDataFromServer();
        })
        .catch(error=>{
            console.log(error);
        })
    }
    
    showAllData = () =>{
        let allplaces = this.state.places.map(place=>{
            return(
                <PlaceComponent 
                    onDeleteClick={() => this.handleDelete()} 
                    key={place.title} 
                    title={place.title} 
                    description={place.description}
                    imageOfPlace={place.imageOfPlace}
                    address={place.address}
                    distance={place.distance}
                    price={place.price}
                    season={place.season}>
                </PlaceComponent>
            );
        });
        return allplaces;
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

export default PlaceContainer;
