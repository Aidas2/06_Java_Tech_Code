var ProductListContainer = React.createClass({
  getInitialState: function() {
    return { products: [] };
  },

  componentWillMount: function() {
    var self = this;
    axios.get('https://itpro2017.herokuapp.com/api/products')
      .then(function (response) {
        self.setState({ products: response.data });
      })
  },

  render: function() {
    return <ProductListComponent products={this.state.products} />
  }
});

window.ProductListContainer = ProductListContainer;
