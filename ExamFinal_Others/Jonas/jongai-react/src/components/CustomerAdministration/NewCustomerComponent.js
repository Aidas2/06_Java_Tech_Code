import React from 'react';
import { Link } from 'react-router-dom';
//import PropTypes from 'prop-types';

const NewCustomerComponet = props => {
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
                    <div className="col-md-5 col-lg-5 mb-3">
                        <label htmlFor="firstName">Kliento vardas:&nbsp;</label>
                        <input type="text" className="form-control" id="firstName" placeholder="Vardas"
                                value={props.firstName} required onChange={props.handleChangeOfFirstName}
                                pattern="^[a-zA-ZÀ-ž\s]+$" maxLength="30" title="Turi būti tik raidės iki 15 simbolių"></input>
                    </div>
                    <div className="col-md-5 col-lg-5 mb-3">
                        <label htmlFor="lastName">Kliento pavardė:&nbsp;</label>
                        <input type="text" className="form-control" id="lastName" placeholder="Pavardė"
                                value={props.lastName} required onChange={props.handleChangeOfLastName}
                                pattern="^[a-zA-ZÀ-ž\s]+$" maxLength="50"
                                title="Turi būti tik raidės iki 30 simbolių"></input>
                    </div>
                    
                </div>

                <div className="form-row">
                    <div className="col-md-5 col-lg-5 mb-3">
                        <label htmlFor="birthday">Gimimo data:&nbsp;</label>
                        <input type="date" className="form-control" id="birthday" 
                                value={props.birthday} required onChange={props.handleChangeOfBirthday}
                        ></input>
                    </div>

                    <div className="col-md-4 col-lg-4 mb-3">
                        <label htmlFor="phoneNumber">Telefonas:&nbsp;</label>
                        <input type="text" className="form-control" id="phoneNumber" placeholder="Telefono numeris"
                                value={props.phoneNumber} required onChange={props.handleChangeOfPhoneNumber}></input>
                    </div>
                </div>

                <div className="form-row">
                    <div className="col-md-3 col-lg-3 mb-3">
                        <label htmlFor="type">Kliento tipas:&nbsp;</label>
                        <select
                            className="form-control-success"
                            id="type"
                            value={props.customerType}
                            required
                            onChange={props.handleChangeOfCustomerType}
                        >
                            <option value="" hidden>Choose option</option>
                            <option value="Įprastas">Įprastas</option>
                            <option value="Lojalus">Lojalus</option>
                            {/* Jeigu yra sąrašas paimtas kaip kintamasis, tada rašoma
                            {optionList} */}
                        </select>
                    </div>
                    
                </div>
                
                <button className="btn btn-primary" type="submit">Išsaugoti</button>&nbsp;
                <Link to={`/`} className="btn btn-dark" >Atšaukti</Link>
                {/* perdaryti pagal sita
            <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onSaveClick}>Save</button>
            */}
            </form>
        </div>
    );
}

export default NewCustomerComponet;