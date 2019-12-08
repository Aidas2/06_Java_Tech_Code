import React from 'react';
//import PropTypes from 'prop-types';
import HolidayCardComponent from './HolidayCardComponent';
import axios from 'axios';
import '../../index.css';

class HolidayListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            holidaysList: '',
            loading: 'Loading holidays. Please wait...'
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/holidays')
            .then((response) => {
                this.setState({ holidaysList: response.data });
                console.log("Koks atiduodamas švenčių sąrašas?");
                console.log(this.state.holidaysList);

                console.log("Ar galiu kažką iš šalių litos ištraukti?");
                console.log(this.state.holidaysList[0].countries);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.holidaysList) {
            const holidayCards = this.state.holidaysList.map((holiday, index) => {
                return (
                    <HolidayCardComponent
                        key={index}
                        code={holiday.code}
                        title={holiday.title}
                        description={holiday.description}
                        image={holiday.image}
                        type={holiday.type}
                        flag={holiday.flag === true ? "Yes" : "No"}
                        simpleDate={holiday.simpleDate}
                    />
                );
            });
            return (
                <div className="container main-data">
                    <div className="row" >{holidayCards}</div>
                </div>
            );
        }
        return (
            <div className="text-center">
                <div className="spinner-border text-danger" role="status">
                    <span className="sr-only">Loading data...</span>
                </div>
            </div>        
        );
    }
}

export default HolidayListContainer;