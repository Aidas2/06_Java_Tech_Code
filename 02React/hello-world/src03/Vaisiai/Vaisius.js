import React, { Component } from 'react'
import PropTypes from 'prop-types'

const styles = {
    card: {
        width: '18rem'
    },
    image: {
        height: '200px'
    }
}

class Vaisius extends Component {
    render() {
        return (
            <div className="card" style={styles.card}>
                <img className="card-img-top" src={this.props.paveiksliukas} alt={this.props.pavadinimas} style={styles.image} />
                <div className="card-body">
                    <h5 className="card-title">{this.props.pavadinimas}</h5>
                    <p className="card-text">{this.props.aprasymas}</p>
                    <a href={this.props.nuoroda} className="btn btn-primary">Informacija</a>
                </div>
            </div>
                );
    }
}

Vaisius.propTypes = {
    paveiksliukas: PropTypes.string.isRequired,
    pavadinimas: PropTypes.string.isRequired,
    aprasymas: PropTypes.string.isRequired,
    nuoroda: PropTypes.string.isRequired
}

export default Vaisius;