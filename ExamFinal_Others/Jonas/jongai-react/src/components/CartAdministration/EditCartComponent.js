import React from 'react';
import { Link } from 'react-router-dom';
//import PropTypes from 'prop-types';

const EditCountryComponet = (props) => {

    return (
        <div className="container">
            <form onSubmit={props.handleSubmit}>
                <div className="form-row">
                    <div className="col-md-12 col-lg-10 mb-3">
                        <h5>{props.fromMenu}</h5>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="title">Country title:&nbsp;</label>
                        <input type="text" className="form-control" id="title" value={props.currentTitle} required onChange={props.handleChangeOfTitle}></input>
                    </div>
                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="image">Country's flag:&nbsp;</label>
                        <input type="text" className="form-control" id="image" value={props.currentImage} required onChange={props.handleChangeOfImage}></input>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-8 col-lg-8 mb-3">
                        <label htmlFor="description">Country's president:&nbsp;</label>
                        <input type="text" className="form-control" id="description" value={props.currentPresident} required onChange={props.handleChangeOfPresident}></input>
                    </div>
                </div>
                <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>&nbsp;
                <button className="btn btn-primary" onClick={props.handleDelete}>Delete</button>&nbsp;
                <Link to={`/admin/countries`} className="btn btn-dark">Cancel</Link>
            </form>
        </div>
    );
}

export default EditCountryComponet;