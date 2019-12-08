import React from 'react';

const UpdateHolidayFormComponent = (props) => {

  return (
    <form >
        <div className="form-row">
            <div className="col-md-12 mb-12">
                <p>{props.fromMenu}</p>
            </div>
        </div>

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault01">Holiday title</label>
                <input
                    type="text"
                    className="form-control"
                    id="validationDefault01"
                    placeholder="Holiday title"
                    value={props.title}  
                    onChange={props.handleChangeOfName}>
                </input>
            </div>
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault03">Description</label>
                <input 
                    type="text"
                    className="form-control" 
                    id="validationDefault03" 
                    placeholder="Description" 
                    value={props.description} 
                    onChange={props.handleChangeOfDescription}>
                </input>
            </div>
        </div>

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault04">Type</label>
                {/* <input 
                    type="text" 
                    className="form-control" 
                    id="validationDefault04" 
                    placeholder="Type" 
                    value={props.type} 
                    onChange={props.handleChangeOfType}>
                </input> */}
                <select
                    type="text"
                    className="form-control"
                    value={props.type}
                    onChange={props.handleChangeOfType}
                    >
                        <option selected value="PUBLIC">PUBLIC</option>
                        <option value="NATIONAL_RELIGIOUS">NATIONAL_RELIGIOUS</option>
                        <option value="MEMORIAL">MEMORIAL</option>
                        <option value="NON_TRADITIONAL">NON_TRADITIONAL</option>
                </select>

            </div>        
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault02">Image</label>
                <input 
                    type="text" 
                    className="form-control" 
                    id="validationDefault02" 
                    placeholder="Image" 
                    value={props.imageOfHoliday} 
                    onChange={props.handleChangeOfImageOfHoliday}>
                </input>
            </div>

        </div>

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault05">Is Flag raised ?</label>
                {/* <input 
                    type="text" 
                    className="form-control" 
                    id="validationDefault05" 
                    placeholder="True or false" 
                    value={props.isFlagRaised} 
                    onChange={props.handleChangeOfIsFlagRaised}>
                </input> */}
                <select
                    type="isFlagRaised"
                    className="form-control"
                    onChange={props.handleChangeIsFlagRaised}
                    >
                        <option selected value={true}>YES</option>
                        <option value={false}>NO</option>
                </select>
            </div>    
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault06">Hire date</label>
                <input 
                    type="date" 
                    className="form-control" 
                    id="validationDefault06" 
                    placeholder="Hire date" 
                    value={props.hireDate} 
                    onChange={props.handleChangeOfHireDate}>
                </input>
            </div>        
        </div>

        <div className="form-row">
                <div className="col-md-4 mb-3 text-center">
                    <input className="form-check-input" name="flag" type="checkbox" value="" id="defaultCheck1" />
                    <label className="form-check-label" htmlFor="defaultCheck1">Flag raise</label>
                </div>
        </div>        

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault07">Distance</label>
                <input 
                    type="number" 
                    step="1"
                    className="form-control" 
                    id="validationDefault07" 
                    placeholder="Distance" 
                    value={props.distance} 
                    onChange={props.handleChangeOfDistance}>
                </input>

                {/* <input
                    type="number"
                    step="1"
                    placeholder="Distance"
                    className="form-control"
                    name="distance"
                    onChange={this.handleChange.bind(this, "distance")}
                    required
                /> */}

            </div>
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault08">Price</label>
                <input 
                    type="number"
                    step="0.05" 
                    className="form-control" 
                    id="validationDefault08" 
                    placeholder="Price" 
                    value={props.price} 
                    onChange={props.handleChangeOfPrice}>
                </input>

                {/* <input
                    type="number"
                    step="0.05"
                    placeholder="Price"
                    className="form-control"
                    name="price"
                    onChange={this.handleChange.bind(this, "price")}
                    required
                /> */}

            </div>

        </div>
       
       <div className="form-row">
            <div className="col-md-4 m-2">
                <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>
                <button className="btn btn-danger" onClick={props.handleDelete}>Delete</button>
                //<button className="btn btn-warning" onClick={props.onClickAddInventory}>Add Country</button>

{/* 
                <div>Add Country</div>
                <div className="form-group mb-4">
                <select
                    id="inlineFormCustomSelect"
                    className="form-control"
                    name="country"
                    value={props.countries}
                    // onChange={this.handleChange}
                >
                    <option defaultValue hidden>
                    Choose here
                    </option>
                    {props.availableCountry()}
                </select>
                <button
                    className="btn btn-warning"
                    onClick={() => props.onClickAddInventory()}
                >
                    Add Country from List
                </button>
                </div>  */}



            </div>
       </div>


    </form>
    );
}

export default UpdateHolidayFormComponent;