import React from 'react';
//import PropTypes from 'prop-types';
import CartAdministrationLineComponent from './CartAdministrationLineComponent';
import axios from 'axios';
import { Link } from 'react-router-dom';

class CartAdministrationListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            carts: ''
        };
    }

    //pagal pradinę mintį turėtų būti negalima trinti krepšelių - tik keičiamas jų statusas
    handleDelete = (cartCode) => {
        axios.delete('http://localhost:8080/api/carts/' + (cartCode))
          .then(response => {
            axios.get('http://localhost:8080/api/carts')
            .then((response) => {
                this.setState({ carts: response.data });
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
        var usernameFromStorage = JSON.parse(sessionStorage.getItem("user"));
        
        axios.get('http://localhost:8080/api/carts', {
            params: {
                username: usernameFromStorage.username
            }
        })
            .then((response) => {
                this.setState({ carts: response.data });
                console.log("---------------- Krepšeliai -----------------------")
                console.log(response.data);
                //console.log("Produktai yra - " + this.state.holidays);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.carts) {
            const cartCards = this.state.carts.map((item, index) => {
                return (
                    <CartAdministrationLineComponent
                        key={index}
                        cartCode={item.cartCode}
                        description={item.description}
                        cartStatus={item.status}
                    />
                );
            });
            return (
                <div className="container">
                    <div className="card">
                        <div className="card-header">
                            <h6 className="text-uppercase mb-0">Krepšelių administravimas</h6>
                        </div>
                        <div className="card-body">
                            <div className="row">
                                <Link className="btn btn-success" to="/admin/carts/new">Add new cart</Link>
                            </div>
                            <div className="row">
                                <div className="col-12">
                                    <table
                                        className="table table-striped"
                                        // style={{ width: "100%" }}
                                    >
                                        <thead className="thead-inverse">
                                            <tr>
                                                <th>Cart code</th>
                                                <th>Cart description</th>
                                                <th>Cart status</th>
                                                <th>Operation</th>
                                            </tr>
                                        </thead>
                                        <tbody>{cartCards}</tbody>
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

export default CartAdministrationListContainer;
