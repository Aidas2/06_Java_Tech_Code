import React from 'react';
import PropTypes from 'prop-types';
import CountryCardComponent from './CountryCardComponent';
//import MyProvider from '../App';
import axios from 'axios';

class CountryListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = { countrys: '',
                        loading: 'Loading countrys. Please wait...'  };
    }

    componentDidMount() {
	axios.get('http://localhost:8080/countrys')
            .then((response) => {
                this.setState({ countrys: response.data });
                console.log(response.data);
                console.log("Valstybes yra - " + this.state.countrys);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.countrys) {
            const countryCards = this.state.countrys.map((country, index) => {
                return (
                    <CountryCardComponent
                        key={index}
                        id={country.id}
                        title={country.title}
                        image={country.image}
                        description={country.description}
                        nameOfPresident={country.nameOfPresident}
                        dateOfHoliday={country.dateOfHoliday}
                    />
                );
            });
            return (<div className="row">{countryCards}</div>);
        }
        return this.state.loading;
    }

}

export default CountryListContainer;
