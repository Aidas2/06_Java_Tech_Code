import React from 'react';
import PropTypes from 'prop-types';
import {Link} from 'react-router-dom';

/* var styles = {
    tekstoFonas: { background: 'red' },
    tekstoSpalva: { color: 'green' }
    }; */

const CustomerListComponent = (props) => {
    var linkas = "/customers/" + props.customerCode;
    return (
        <tr>
            <td>{props.firstName} {props.lastName}</td>    
            <td>Čia bus kiekis</td>
            <td>
                <Link
                    style={{ textDecoration: "none", color: "black", cursor: "default" }}
                    to={`/customers/${props.customerCode}`}
                >
                    <i
                        className="mygtukas fas fa-info-circle fa-2x"
                        title="Šventės informacija"
                    />
                </Link>&nbsp;
            </td>
        </tr>
    );    
            
}


export default CustomerListComponent;