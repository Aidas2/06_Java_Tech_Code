var PropTypes = React.PropTypes;

var styles = {
  thumbnail: {
    maxWidth: '242px',
    textAlign: 'center',
    marginLeft: 'auto',
    marginRight: 'auto'
  },
  image: { width: '100%', height: '200px', display: 'block'}
};

var ProductCardComponent = React.createClass({
  render: function() {
    return (
      <div className="col-sm-6 col-md-4">
        <div className="thumbnail" style={styles.thumbnail}>
          <img src={this.props.image} style={styles.image} alt="..."/>
          <div className="caption">
            <h3>{this.props.title}</h3>
            <p>{this.props.description}</p>
            <p>{this.props.price} Eur</p>
            <p><button className="btn btn-primary" role="button">Details</button></p>
          </div>
        </div>
      </div>
    );
  }
});

ProductCardComponent.propTypes = {
  id: PropTypes.number.isRequired,
  image: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
};

window.ProductCardComponent = ProductCardComponent;
