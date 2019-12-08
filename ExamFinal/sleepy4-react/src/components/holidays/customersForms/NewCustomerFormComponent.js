import React from 'react';

const NewCustomerFormComponent = (props) => {

  return (
    <form >
        <div className="form-row">
            <div className="col-md-12 mb-12">
                <p>{props.fromMenu}</p>
            </div>
        </div>

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault01">Customer name</label>
                <input
                    type="text"
                    className="form-control"
                    id="validationDefault01"
                    placeholder="Customer name"
                    value={props.name}  
                    onChange={props.handleChangeOfName}>
                </input>
            </div>
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault03">Customer surname</label>
                <input 
                    type="text"
                    className="form-control" 
                    id="validationDefault03" 
                    placeholder="Customer surname" 
                    value={props.surname} 
                    onChange={props.handleChangeOfSurname}>
                </input>
            </div>
        </div>

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault03">Birth date</label>
                <input 
                    type="date" 
                    className="form-control" 
                    id="validationDefault03" 
                    placeholder="Birth date" 
                    value={props.birthDate} 
                    onChange={props.handleChangeOfBirthDate}>
                </input>
            </div> 
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault04">Phone number</label>
                <input 
                    type="text"
                    className="form-control" 
                    id="validationDefault04" 
                    placeholder="Phone number" 
                    value={props.phoneNumber} 
                    onChange={props.handleChangeOfPhoneNumber}>
                </input>
            </div>
        </div>

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault05">Type</label>
                <select
                    type="text"
                    className="form-control"
                    value={props.type}
                    onChange={props.handleChangeOfType}
                    >
                        <option selected value="USUAL">USUAL</option>
                        <option value="LOYAL">LOYAL</option>
                </select>
            </div>        

        </div>

        <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>
       
    </form>
    );
}

export default NewCustomerFormComponent;