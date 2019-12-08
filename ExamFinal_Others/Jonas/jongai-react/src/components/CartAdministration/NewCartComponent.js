import React from 'react';
import { Link } from 'react-router-dom';
//import PropTypes from 'prop-types';

const NewCartComponet = props => {
    //Jeigu yra pasirinkimo sąrašo nuskaitymas iš serverio, tai čia apsirašau kintamąjį su pasirinkimų variantais
    // let optionList = props.typeList.map(v => (
    //     <option key={v}>{v}</option>
    //   ));
    return (
        <div className="container main-data">
            <form onSubmit={props.handleSubmit}>
                <div className="form-row">
                    <div className="col-md-12 col-lg-12 mb-12">
                        <h5>{props.fromMenu}</h5>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-12 col-lg-12 mb-12">
                        <label htmlFor="title">Order description:&nbsp;</label>
                        <input type="text" className="form-control" id="description" placeholder="Order description" value={props.description} required onChange={props.handleChangeOfDescription}></input>
                    </div>
                </div>
                <div className="form-row">
                    {/* Čia bus pasirinkimas, ką noriu įdėti į krepšelį */}
                </div>
                
                <button className="btn btn-primary" type="submit">Place order</button>&nbsp;
                <Link to={`/admin/carts`} className="btn btn-dark" >Cancel</Link>
                {/* perdaryti pagal sita
            <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onSaveClick}>Save</button>
            */}
            </form>
        </div>
    );
}

export default NewCartComponet;