import React from 'react';
//import PropTypes from 'prop-types';
import CountryAdministrationLineComponent from './CountryAdministrationLineComponent';
import axios from 'axios';
import { Link } from 'react-router-dom';

class CountryAdministrationListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            contries: ''
        };
    }

    handleDelete = (countryCode) => {
        axios.delete('http://localhost:8080/api/countries/' + (countryCode))
          .then(response => {
            axios.get('http://localhost:8080/api/countries')
            .then((response) => {
                this.setState({ countries: response.data });
            })
            .catch((error) => {
                console.log(error);
            });
          })
          .catch(function (error) {
            console.log(error);
        });
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/countries')
            .then((response) => {
                this.setState({ countries: response.data });
                //console.log(response.data);
                //console.log("Produktai yra - " + this.state.holidays);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.countries) {
            const countryCards = this.state.countries.map((item, index) => {
                return (
                    <CountryAdministrationLineComponent
                        key={index}
                        countryCode={item.countryCode}
                        title={item.title}
                        image={item.image}
                        handleDelete={this.handleDelete}
                    />
                );
            });
            return (
                <div className="container">
                    <div className="card">
                        <div className="card-header">
                            <h6 className="text-uppercase mb-0">Šalių administravimas</h6>
                        </div>
                        <div className="card-body">
                            <div className="row">
                                <Link className="btn btn-success" to="/admin/countries/new">Add new country</Link>
                            </div>
                            <div className="row">
                                <div className="col-12">
                                    <table
                                        className="table table-striped"
                                        // style={{ width: "100%" }}
                                    >
                                        <thead className="thead-inverse">
                                            <tr>
                                                <th>Country title</th>
                                                <th width="30%">Country's flag</th>
                                                <th>Operation</th>
                                            </tr>
                                        </thead>
                                        <tbody>{countryCards}</tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
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

export default CountryAdministrationListContainer;
