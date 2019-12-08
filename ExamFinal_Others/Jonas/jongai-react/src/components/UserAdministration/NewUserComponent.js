import React from 'react';
import { Link } from 'react-router-dom';
//import PropTypes from 'prop-types';

const NewUserComponet = props => {
    //Jeigu yra pasirinkimo sąrašo nuskaitymas iš serverio, tai čia apsirašau kintamąjį su pasirinkimų variantais
    // let optionList = props.typeList.map(v => (
    //     <option key={v}>{v}</option>
    //   ));
    return (
        <div className="container main-data">
            <form onSubmit={props.handleSubmit}>
                <div className="form-row">
                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="title">User full name:&nbsp;</label>
                        <input type="text" className="form-control" id="title" placeholder="User full name"
                                value={props.name} required onChange={props.handleChangeOfName}
                                pattern="^[a-zA-ZÀ-ž\s]+$" maxLength="40" title="Must contain only letters up to 40 symbols"></input>
                    </div>
                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="image">Username:&nbsp;</label>
                        <input type="text" className="form-control" id="image" placeholder="Username"
                                value={props.username} required onChange={props.handleChangeOfUsername}
                                pattern="^[a-zA-Z]+$" minLength="6" maxLength="12" title="Must be min 6 max 12 symbols"></input>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-8 col-lg-8 mb-3">
                        <label htmlFor="description">E-mail:&nbsp;</label>
                        <input type="email" className="form-control" id="description" placeholder="E-mail address"
                                value={props.email} required onChange={props.handleChangeOfEmail}></input>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-8 col-lg-8 mb-3">
                        <label htmlFor="description">Password:&nbsp;</label>
                        <input type="text" className="form-control" id="description" placeholder="Password"
                                value={props.password} required onChange={props.handleChangeOfPassword}
                                minLength="6" title="Password must be minimum of 6 symbols"></input>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-3 col-lg-3 mb-3">
                        <label htmlFor="type">Role:&nbsp;</label>
                        <select
                            className="form-control-success"
                            id="type"
                            value={props.type}
                            required
                            onChange={props.handleChangeOfRole}
                        >
                            {/* <option value="" hidden>Choose option</option> */}
                            <option value="ROLE_USER">User</option>
                            <option value="ROLE_ADMIN">Administrator</option>
                            {/* Jeigu yra sąrašas paimtas kaip kintamasis, tada rašoma
                            {optionList} */}
                        </select>
                    </div>
                </div>
                <button className="btn btn-primary" type="submit">Save</button>&nbsp;
                <Link to={`/`} className="btn btn-dark" >Cancel</Link>
                {/* perdaryti pagal sita
            <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onSaveClick}>Save</button>
            */}
            </form>
        </div>
    );
}

export default NewUserComponet;