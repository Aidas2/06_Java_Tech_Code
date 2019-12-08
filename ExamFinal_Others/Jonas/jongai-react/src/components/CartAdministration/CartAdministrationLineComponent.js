import React from 'react';
//import PropTypes from 'prop-types';
import { withRouter } from 'react-router';
import { Link } from 'react-router-dom';

const CountryAdministrationLineComponent = (props) => {

    var linkas = "/admin/carts/" + props.cartCode;
    return (
        <tr>
            <td><Link to={linkas}>{props.cartCode}</Link></td>
            <td>
                <p>{props.description}</p>
            </td>
            <td>
                <p>{props.cartStatus}</p>
            </td>
            <td>
                <Link
                    style={{ textDecoration: "none", color: "black", cursor: "default" }}
                    to={`/countries/${props.countryCode}`}
                >
                    <i
                        className="mygtukas fas fa-info-circle fa-2x"
                        title="Šalies informacija"
                    />
                </Link>&nbsp;
                <Link
                    style={{ textDecoration: "none", color: "black", cursor: "default" }}
                    to={`/admin/countries/${props.countryCode}`}
                >
                    <i
                        className="mygtukas far fa-edit fa-2x"
                        title="Šalies redagavimas"
                    />
                </Link>&nbsp;
                    <i
                        className="mygtukas fas fa-trash fa-2x"
                        title="Šalies trynimas"
                        onClick={() => {props.handleDelete(props.countryCode);}}
                    />
            </td>
        </tr>
        
    );
}


export default withRouter(CountryAdministrationLineComponent);