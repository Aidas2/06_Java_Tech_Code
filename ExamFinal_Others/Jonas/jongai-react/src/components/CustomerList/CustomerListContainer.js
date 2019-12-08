import React from 'react';
//import PropTypes from 'prop-types';
import CustomerListComponent from './CustomerListComponent';
import { Link } from 'react-router-dom';
import axios from 'axios';
import '../../index.css';

class CustomerListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            customerList: '',
            loading: 'Loading customers. Please wait...'
        };
    }

    componentDidMount() {
        console.log("Atėjau į čia");
        axios.get('http://localhost:8080/api/customers')
            .then((response) => {
                this.setState({ customerList: response.data });
                console.log("Koks atiduodamas klinetų sąrašas?");
                console.log(this.state.customerList);

                console.log("Ar galiu kažką iš šalių litos ištraukti?");
                console.log(this.state.customerList[0].countries);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.customerList) {
            const customerLines = this.state.customerList.map((customer, index) => {
                return (
                    <CustomerListComponent
                        key={index}
                        customerCode={customer.customerCode}
                        firstName={customer.firstName}
                        lastName={customer.lastName}
                        birthday={customer.birthday}
                        phoneNumber={customer.phoneNumber}
                        customerType={customer.customerType}
                    />
                );
            });
            return (
               /*  <div className="container main-data">
                    <div className="row" >{customerLines}</div>
                </div> */

                <div className="container main-data">
                    <div className="card">
                        <div className="card-header">
                            <h6 className="text-uppercase mb-0">Klientų sąrašas</h6>
                        </div>
                        <div className="card-body">
                            <div className="row">
                                <Link className="btn btn-success" to="/admin/newCustomer">Naujas klientas</Link>
                            </div>
                            <div className="row">
                                <div className="col-12">
                                    <table
                                        className="table table-striped"
                                        // style={{ width: "100%" }}
                                    >
                                        <thead className="thead-inverse">
                                            <tr>
                                                <th>Klientas</th>
                                                <th>Inv. kiekis sandėlyje</th>
                                                <th>Informacija</th>
                                            </tr>
                                        </thead>
                                        <tbody>{customerLines}</tbody>
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

export default CustomerListContainer;