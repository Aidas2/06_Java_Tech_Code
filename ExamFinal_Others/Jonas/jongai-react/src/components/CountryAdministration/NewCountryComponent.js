import React from 'react';
import { Link } from 'react-router-dom';
//import PropTypes from 'prop-types';

const NewCountryComponet = props => {
    //Jeigu yra pasirinkimo sąrašo nuskaitymas iš serverio, tai čia apsirašau kintamąjį su pasirinkimų variantais
    // let optionList = props.typeList.map(v => (
    //     <option key={v}>{v}</option>
    //   ));
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
                        <label htmlFor="title">Country title:&nbsp;</label>
                        <input type="text" className="form-control" id="title" placeholder="Country title"
                                value={props.title} required onChange={props.handleChangeOfTitle}
                                pattern="^[a-zA-ZÀ-ž\s]+$" maxLength="30"
                                title="Title must contain only letters up to 30 symbols"></input>
                    </div>
                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="image">Flag image:&nbsp;</label>
                        <input type="text" className="form-control" id="image" placeholder="County's flag"
                                value={props.image} required onChange={props.handleChangeOfImage}></input>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-8 col-lg-8 mb-3">
                        <label htmlFor="description">President:&nbsp;</label>
                        <input type="text" className="form-control" id="description" placeholder="Country's president"
                                value={props.president} required onChange={props.handleChangeOfPresident}
                                pattern="^[a-zA-ZÀ-ž\s]+$" maxLength="50"
                                title="President name must contain only letters up to 50 symbols"></input>
                    </div>
                </div>
                
                <button className="btn btn-primary" type="submit">Save</button>&nbsp;
                <Link to={`/admin/countries`} className="btn btn-dark" >Cancel</Link>
                {/* perdaryti pagal sita
            <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onSaveClick}>Save</button>
            */}
            </form>
        </div>
    );
}

export default NewCountryComponet;