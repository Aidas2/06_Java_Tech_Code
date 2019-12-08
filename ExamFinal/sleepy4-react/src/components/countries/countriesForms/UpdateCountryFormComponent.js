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
                <label htmlFor="validationDefault01">Country title</label>
                <input
                    type="text"
                    className="form-control"
                    id="validationDefault01"
                    placeholder="Country title"
                    value={props.title}  
                    onChange={props.handleChangeOfTitle}>
                </input>
            </div>
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault02">Image</label>
                <input 
                    type="text" 
                    className="form-control" 
                    id="validationDefault02" 
                    placeholder="Image" 
                    value={props.imageOfFlag} 
                    onChange={props.handleChangeOfImageOfFlag}>
                </input>
            </div>

        </div>

        <div className="form-row">
        
        <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault03">Country title</label>
                <input
                    type="text"
                    className="form-control"
                    id="validationDefault03"
                    placeholder="President"
                    value={props.president}  
                    onChange={props.handleChangeOfPresident}>
                </input>
            </div>      

        </div>     

        <div className="form-row">
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault07">Area</label>
                <input 
                    type="number" 
                    step="10"
                    className="form-control" 
                    id="validationDefault07" 
                    placeholder="Area" 
                    value={props.area} 
                    onChange={props.handleChangeOfArea}>
                </input>

            </div>
            <div className="col-md-4 mb-3">
                <label htmlFor="validationDefault08">Population</label>
                <input 
                    type="number"
                    step="1000" 
                    className="form-control" 
                    id="validationDefault08" 
                    placeholder="Population" 
                    value={props.population} 
                    onChange={props.handleChangeOfPopulation}>
                </input>

            </div>

        </div>
       
       <div className="form-row">
            <div className="col-md-4 m-2">
                <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>
                <button className="btn btn-danger" onClick={props.handleDelete}>Delete</button>
                {/* <button className="btn btn-warning" onClick={props.onClickAddSomething}>Add Something</button>                 */}
            </div>
       </div>


    </form>
    );
}

export default UpdateHolidayFormComponent;