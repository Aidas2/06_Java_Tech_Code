import React from 'react';
import { Link } from 'react-router-dom';
//import PropTypes from 'prop-types';

const EditHolidayComponet = (props) => {

    return (
        <div className="container main-data">
            <form onSubmit={props.handleSubmit}>
                <div className="form-row">
                    <div className="col-md-12 col-lg-10 mb-3">
                        <h5>{props.fromMenu}</h5>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="title">Holiday title:&nbsp;</label>
                        <input type="text" className="form-control" id="title" value={props.currentTitle} required
                                onChange={props.handleChangeOfTitle}
                                pattern="^[a-zA-ZÀ-ž\s]+$" maxLength="30" title="Title must contain only letters up to 30 symbols"></input>
                    </div>
                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="image">Image:&nbsp;</label>
                        <input type="text" className="form-control" id="image" value={props.currentImage} required
                                onChange={props.handleChangeOfImage}></input>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-8 col-lg-8 mb-3">
                        <label htmlFor="description">Description:&nbsp;</label>
                        <input type="text" className="form-control" id="description" value={props.currentDescription} required
                                onChange={props.handleChangeOfDescription} pattern="^[a-zA-ZÀ-ž\s]+$" maxLength="50"
                                title="Description must contain only letters up to 50 symbols"></input>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-3 col-lg-3 mb-3">
                        <label htmlFor="type">Type:&nbsp;</label>
                        <select
                            className="form-control-success"
                            id="type"
                            value={props.currentType}
                            required
                            onChange={props.handleChangeOfType}
                        >
                            <option value="" hidden>Choose option</option>
                            <option value="Valstybinė">Valstybinė</option>
                            <option value="Tautinė-religinė">Tautinė-religinė</option>
                            <option value="Atmintina">Atmintina</option>
                            <option value="Netradicinė">Netradicinė</option>
                            {/* Jeigu yra sąrašas paimtas kaip kintamasi, tada rašoma
                            {optionList} */}
                        </select>
                    </div>
                    <div className="col-md-3 col-lg-3 mb-3">
                        <label className="form-check-label" htmlFor="flag">
                            <input className="form-check-input" type="checkbox" id="flag" checked={props.currentFlag} onChange={props.handleChangeOfFlag}></input>
                            Flag rising</label>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-8 col-lg-8 mb-3">
                        <label htmlFor="description">Simple date:&nbsp;</label>
                        <input type="date" className="form-control" id="simpleDate" 
                                value={props.simpleDate} required onChange={props.handleChangeOfSimpleDate}
                        ></input>
                    </div>
                </div>
                <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>&nbsp;
                <button className="btn btn-primary" onClick={props.handleDelete}>Delete</button>&nbsp;
                <Link to={`/admin/holidays`} className="btn btn-dark">Cancel</Link>
                {/* perdaryti pagal sita
            <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onSaveClick}>Save</button>
            */}
            </form>
        </div>

        // <form >
        //     <div className="form-row">
        //         <div className="col-md-12 mb-12">
        //             <p>{props.fromMenu}</p>
        //         </div>
        //     </div>
        //     <div className="form-row">
        //         <div className="col-md-4 mb-3">
        //             <label htmlFor="validationDefault01">Holiday title</label>
        //             <input type="text" className="form-control" id="validationDefault01" placeholder="" value={props.currentTitle} required onChange={props.handleChangeOfTitle}></input>
        //         </div>
        //         <div className="col-md-4 mb-3">
        //             <label htmlFor="validationDefault02">Image</label>
        //             <input type="text" className="form-control" id="validationDefault02" placeholder="" value={props.currentImage} required onChange={props.handleChangeOfImage}></input>
        //         </div>
        //     </div>
        //     <div className="form-row">
        //         <div className="col-md-8 mb-3">
        //             <label htmlFor="validationDefault03">Description</label>
        //             <input type="text" className="form-control" id="validationDefault03" placeholder="" value={props.currentDescription} required onChange={props.handleChangeOfDescription}></input>
        //         </div>
        //     </div>
        //     <div className="form-row">
        //         <div className="col-md-4 mb-3">
        //             <label htmlFor="validationDefault04">Type</label>
        //             <input type="text" className="form-control" id="validationDefault04" placeholder="" value={props.currentType} required onChange={props.handleChangeOfType}></input>
        //         </div>
        //         <div className="col-md-4 mb-3">
        //             <label htmlFor="validationDefault05">Flag</label>
        //             <input type="text" className="form-control" id="validationDefault05" placeholder="" value={props.currentFlag} required onChange={props.handleChangeOfFlag}></input>
        //         </div>
        //     </div>
        //     <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>
        //     <button className="btn btn-primary" onClick={props.handleDelete}>Delete</button>
        // </form>
    );
}

export default EditHolidayComponet;