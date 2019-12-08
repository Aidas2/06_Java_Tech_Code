import React from 'react';
import PropTypes from 'prop-types';

const ProductAdministrationComponetForm = (props) => {

    return (
        <form >
            <div className="form-row">
                <div className="col-md-12 mb-12">
                    <p>{props.fromMenu}</p>
                </div>
            </div>
            <div className="form-row">
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault01">Product title</label>
                    <input type="text" className="form-control" id="validationDefault01" placeholder="Product title" required onChange={props.handleChangeOfTitle}></input>
                </div>
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault02">Image URL</label>
                    <input type="text" className="form-control" id="validationDefault02" placeholder="Image URL" required onChange={props.handleChangeOfImageUrl}></input>
                </div>
            </div>
            <div className="form-row">
                <div className="col-md-8 mb-3">
                    <label htmlFor="validationDefault03">Description</label>
                    <input type="text" className="form-control" id="validationDefault03" placeholder="Description" required onChange={props.handleChangeOfDescription}></input>
                </div>
            </div>
            <div className="form-row">
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault04">Price</label>
                    <input type="text" className="form-control" id="validationDefault01" placeholder="Price" required onChange={props.handleChangeOfPrice}></input>
                </div>
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault05">Quantity</label>
                    <input type="text" className="form-control" id="validationDefault02" placeholder="Quantity" required onChange={props.handleChangeOfQuantity}></input>
                </div>
            </div>
            <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>
        </form>
    );
}

export default ProductAdministrationComponetForm;