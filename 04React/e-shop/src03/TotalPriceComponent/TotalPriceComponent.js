import React, {Component} from 'react';
import PropTypes from 'prop-types';
import img from './img/purse.jpg';

const styles = {
    card: {
        width: '18rem'
    },
    image: {
        height: '200px' 
    }
    }

class TotalPriceComponent extends Component {
    render () {
        return (
            <div className="card" style={styles.card}>
                <img className="card-img-top" src={img} alt={this.props.pavadinimas} style={styles.image}/>
                <div className="card-body">
                <p className="card-text">Total price is: {this.props.totalPrice} Eur</p>
                </div>
            </div>  
        );
    }
}

TotalPriceComponent.propTypes = {
    totalPrice: PropTypes.number.isRequired
}

export default TotalPriceComponent;
