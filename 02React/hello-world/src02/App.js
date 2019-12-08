//cia yra stilius (inline styles, 54 psl.), kuris bus pritaikytas korteles komponentui
var styles = {
  thumbnail: {
    maxWidth: '242px',
    textAlign: 'center',
    marginLeft: 'auto',
    marginRight: 'auto'
  },
  image: { width: '100%', height: '200px', display: 'block'}
};

// cia yra jau pats korteles komponentas
class ProductCardComponent extends React.Component {
  render() {
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
};

//cia nurodom kokie atributai yra butini (taikoma korteles komponentui)
ProductCardComponent.propTypes = {
  id: PropTypes.number.isRequired,
  id: PropTypes.number.isRequired,
  image: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
};

//cia jau korteliu komponentu sarasas
var ProductListComponent = (props) => {
  var productCards = props.products.map(function (product, index) {
    return (
      <ProductCardComponent
        key={index}
        id={product.id}
        image={product.image}
        title={product.title}
        description={product.description}
        price={product.price}
      />
    );
  });
  return (<div className="row">{productCards}</div>);
};

//cia alternatyvus variantas ?
/*
class ProductListComponentKlase extends React.Component {
  render() {
	  var productCards = this.props.products.map(function (product, index) {
	    return (
	      <ProductCardComponent
		key={index}
		id={product.id}
		image={product.image}
		title={product.title}
		description={product.description}
		price={product.price}
	      />
	    );
	  });
	  return (<div className="row">{productCards}</div>);
 }
};
*/

//cia nurodom kokie atributai yra butini (taikoma sarasui)
ProductListComponent.propTypes = {
  products: PropTypes.array.isRequired,
};

//cia yra masyvas su objektais
var testProducts = [
  {
    id: 1,
    image: 'samsung.jpg',
    title: 'Telephons 1',
    description: 'The Samsung Galaxy S9 is powered by octa-core (4x2.7GHz + 4x1.7GHz) processor and it comes with 4GB of RAM.',
    price:622.5
  },
  {
    id: 2,
    image: 'huawei.jpg',
    title: 'Telephons 2',
    description: 'The Mate 20 Pro is a high-end, powerful smartphone, and is the first in the company’s line-up to sport its 7nm Kirin 980 processor.',
    price:858.7
  },
  {
    id: 3,
    image: 'iphone.jpeg',
    title: 'Telephons 3',
    description: 'The iPhone 8 includes a 4.7-inch display, while the iPhone 8 Plus features a larger 5.5-inch display. ',
    price:967.8
  }
];

//cia paduodam masyva (ir renderinam ji prie elemento su #root)
ReactDOM.render(<ProductListComponent products={testProducts} />, document.getElementById('root'));
