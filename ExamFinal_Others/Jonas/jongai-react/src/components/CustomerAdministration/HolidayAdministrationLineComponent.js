import React from 'react';
//import PropTypes from 'prop-types';
import { withRouter } from 'react-router';
import { Link } from 'react-router-dom';

const HolidayAdministrationLineComponent = (props) => {

    var linkas = "/admin/holidays/" + props.code;
    return (
        <tr>
            <td><Link to={linkas}>{props.title}</Link></td>
            <td>
                <img src={"/img/holidays/" + props.image} alt="Holiday_picture" width="30%"></img>
            </td>
            <td>{props.description}</td>
            <td>
                <Link
                    style={{ textDecoration: "none", color: "black", cursor: "default" }}
                    to={`/holidays/${props.code}`}
                >
                    <i
                        className="mygtukas fas fa-info-circle fa-2x"
                        title="Šventės informacija"
                    />
                </Link>&nbsp;
                <Link
                    style={{ textDecoration: "none", color: "black", cursor: "default" }}
                    to={`/admin/holidays/${props.code}`}
                >
                    <i
                        className="mygtukas far fa-edit fa-2x"
                        title="Šventės redagavimas"
                    />
                </Link>&nbsp;
                    <i
                        className="mygtukas fas fa-trash fa-2x"
                        title="Šventės trynimas"
                        onClick={() => {props.handleDelete(props.code);}}
                    />
            </td>
        </tr>
        
        // SENAS DIV METODAS
        // < div className = "container" >
        //     <div className="row">
        //         <div className="col-sm-3 col-md-2 col-lg-2 mb-3">
        //             <Link to={linkas}>{props.title}</Link>
        //         </div>
        //         <div className="col-sm-3 col-md-2 col-lg-2 mb-3">
        //             <img src={pic} alt="Holiday_picture" width="50%"></img>
        //         </div>
        //         <div className="col-sm-6 col-md-8 col-lg-8 mb-3">
        //             <p>{props.description}</p>
        //         </div>
        //     </div>
        // </div >
    );
}



// ProductCardComponent.propTypes = {
//     id: PropTypes.number.isRequired,
//     title: PropTypes.string.isRequired,
//     image: PropTypes.string.isRequired,
//     description: PropTypes.string.isRequired,
//     price: PropTypes.number.isRequired,
//     quantity: PropTypes.number.isRequired
// };


export default withRouter(HolidayAdministrationLineComponent);