import React, { Component } from 'react';
import PropTypes from 'prop-types';
import Vaisius from './Vaisius';

class Vaisiai extends Component {
    render() {
        var vaisiai = this.props.vaisiai.map(vaisius => {
            return (<div className="col-sm-4" key={vaisius.pavadinimas}>
                <Vaisius paveiksliukas = {vaisius.paveiksliukas}
                        pavadinimas = {vaisius.pavadinimas}
                        aprasymas = {vaisius.aprasymas}
                        nuoroda = {vaisius.nuoroda} />
    
                </div>
            );
        })

        return(
            <div className = "container-fluid" >
                <div className="row">
                    {vaisiai}
                </div>
            </div>
            );
    }
}

Vaisiai.PropTypes = {
    vaisiai: PropTypes.array.isRequired
}

export default Vaisiai;