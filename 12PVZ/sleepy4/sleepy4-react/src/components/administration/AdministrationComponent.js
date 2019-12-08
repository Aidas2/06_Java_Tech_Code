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
                to="/admin/countries/new"
                className="btn btn-success btn-space">Add new Country
            </Link>
            <Link
                to="/admin/holidays/new"
                className="btn btn-success btn-space">Add new Holiday
            </Link>
            <Link
                to="/admin/places/new"
                className="btn btn-success btn-space">Add new Place
            </Link>

            <Link
                to="/admin/flavors/new"
                className="btn btn-success btn-space">Add new Flavor
            </Link>


            </div>

            <h3>Read:</h3>
            <div className="horizontal">
            <Link
                to="/admin/countries/:title"
                className="btn btn-info">Show my Countries
            </Link>
            <Link
                to="/admin/holidays/:title"
                className="btn btn-info">Show my Holidays
            </Link>
            <Link
                to="/admin/places/:title"
                className="btn btn-info">Show may Places
            </Link>
            </div>

            <h3>Update:</h3>
            <div className="horizontal">
            <Link
                to="/admin/countries/:title"
                className="btn btn-warning">Edit Country
            </Link>
            <Link
                to="/admin/holidays/:title"
                className="btn btn-warning">Edit Holiday
            </Link>
            <Link
                to="/admin/places/:title"
                className="btn btn-warning">Edit Place
            </Link>
            </div>

            <h3>Delete:</h3>
            <div className="horizontal">
            <Link
                to="/admin/countries/:title"
                className="btn btn-danger">Delete Country
            </Link>
            <Link
                to="/admin/holiday/:title"
                className="btn btn-danger">Delete Holiday
            </Link>
            <Link
                to="/admin/place/:title"
                className="btn btn-danger">Delete Place
            </Link>

            {/* <HolidayContainer /> */}

            </div>


            {/* <h3>Create:</h3>
            <div className="horizontal">
                <button onClick={props.onDeleteClick(props.title)} >Add new Country</button>
                <button type="button" class="btn btn-success btn-space">Add new Country</button>
                <button type="button" class="btn btn-success btn-space">Add new Holiday</button>
                <button type="button" class="btn btn-success btn-space">Add new Place</button>
            </div>

            <h3>Read:</h3>
            <div className="horizontal">
                <button type="button" class="btn btn-info">Show Country</button>
                <button type="button" class="btn btn-info">Show Holiday</button>
                <button type="button" class="btn btn-info">Show Place</button>
            </div>

            <h3>Update:</h3>
            <div className="horizontal">
                <button type="button" class="btn btn-warning">Edit Country</button>
                <button type="button" class="btn btn-warning">Edit Holiday</button>
                <button type="button" class="btn btn-warning">Edit Place</button>
            </div>

            <h3>Delete:</h3>
            <div className="horizontal">
                <button type="button" class="btn btn-danger">Delete Country</button>
                <button type="button" class="btn btn-danger">Delete Holiday</button>
                <button type="button" class="btn btn-danger">Delete Place</button>
            </div> */}

        </div>
        // </body>
    );
}

export default AdministrationComponent;