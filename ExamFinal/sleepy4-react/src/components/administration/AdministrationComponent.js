import React, {Component} from "react";
import { Link } from "react-router-dom";
import "./AdministrationComponent.css";

const AdministrationComponent = (props) => {
    return(
        // <body>
        <div>
            <h3>Create:</h3>
            <div className="horizontal">
            <Link
                to="/admin/inventors/new"
                className="btn btn-success btn-space">Add new Inventor
            </Link>
            <Link
                to="/admin/customers/new"
                className="btn btn-success btn-space">Add new Customer
            </Link>
            <Link
                to="/admin/reports/new"
                className="btn btn-success btn-space">Add new Report
            </Link>


            </div>

            <h3>Read:</h3>
            <div className="horizontal">
            <Link
                to="/admin/inventors/:title"
                className="btn btn-info">Show my Inventors
            </Link>
            <Link
                to="/admin/customers/:title"
                className="btn btn-info">Show my Customers
            </Link>
            <Link
                to="/admin/reports/:title"
                className="btn btn-info">Show my Reports
            </Link>
            </div>

            <h3>Update:</h3>
            <div className="horizontal">
            <Link
                to="/admin/inventors/:title"
                className="btn btn-warning">Edit Inventor
            </Link>
            <Link
                to="/admin/customers/:title"
                className="btn btn-warning">Edit Customer
            </Link>
            <Link
                to="/admin/reports/:title"
                className="btn btn-warning">Edit Report
            </Link>
            </div>

            <h3>Delete:</h3>
            <div className="horizontal">
            <Link
                to="/admin/inventors/:title"
                className="btn btn-danger">Delete Inventor
            </Link>
            <Link
                to="/admin/customer/:title"
                className="btn btn-danger">Delete Customer
            </Link>
            <Link
                to="/admin/reports/:title"
                className="btn btn-danger">Delete Report
            </Link>

            </div>

        </div>
        // </body>
    );
}

export default AdministrationComponent;