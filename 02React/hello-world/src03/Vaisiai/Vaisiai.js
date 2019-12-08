import React, { Component } from 'react';
import Vaisius from './Vaisius';
import PropTypes from 'prop-types'

class Vaisiai extends Component {
    render() {
        var vaisiai = this.props.vaisiai.map(vaisius => {
            return (<div className="col-sm-4" key={vaisius.pavadinimas}>
                <Vaisius paveiksliukas={vaisius.paveiksliukas}
                         pavadinimas={vaisius.pavadinimas}
                         aprasymas={vaisius.aprasymas}
                         nuoroda={vaisius.nuoroda}/>
            </div>);
        })
        return (<div className="container-fluid">
                    <div className="row">
                        {vaisiai}
                    </div>
                </div>);
    }
}

Vaisiai.propTypes = {
    vaisiai: PropTypes.array.isRequired
}

export default Vaisiai;