import React, {Component} from 'react';
import PropTypes from 'prop-types';
//import img from './img/huawei.jpg';

const styles = {
    card: {
        width: '18rem'
    },
    image: {
        height: '200px' 
    }
    }

class ProductCardComponent extends Component {
    render () {
        return (
            <div className="card" style={styles.card}>
                <img className="card-img-top" src={this.props.paveiksliukas} alt={this.props.pavadinimas} style={styles.image}/>
                <div className="card-body">
                <h5 className="card-title">{this.props.pavadinimas}</h5>
                <p className="card-text">{this.props.aprasymas}</p>
                <p className="card-text">Price: {this.props.kaina} Eur</p>
                <a href={this.props.nuoroda} className="btn btn-primary">Details</a>
                </div>
            </div>  
        );
    }
}

ProductCardComponent.propTypes = {
    pavadinimas: PropTypes.string.isRequired,
    paveiksliukas: PropTypes.string.isRequired,
    aprasymas: PropTypes.string.isRequired,
    kaina: PropTypes.number.isRequired,
    nuoroda: PropTypes.string.isRequired
}

export default ProductCardComponent;