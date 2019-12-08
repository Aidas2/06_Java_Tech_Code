import React, {Component} from "react";
import axios from "axios";
import {Link} from "react-router-dom";

class NewPlaceForm extends Component {

    constructor () {
        super();
        this.state = {
            price: 0.0,
        }
    }

    render () {
        return (
            <div className="container-fluid ">
                <h1>Add New Place</h1>


                <div className="form-group mb-2">
                    <input
                    type="number"
                    step="1"
                    placeholder="Distance"
                    className="form-control"
                    name="distance"
                    onChange={this.handleChange}
                    required
                    />
                </div>

                <div className="form-group mb-2">
                    <input
                    type="number"
                    step="0.01"
                    placeholder="Price"
                    className="form-control"
                    name="price"
                    onChange={this.handleChange}
                    required
                    />
                </div>

            </div>

        );
    }
}

export default NewPlaceForm;