var ProductAdministrationContainer = React.createClass({
  getInitialState: function() {
    return {
      id: this.props.params.id,
      image: '',
      title: '',
      description: '',
      price: 0,
      quantity: 0
    };
  },

  handleSaveClick: function(e) {
    var self = this;
    var body = {
      image: this.state.image,
      title: this.state.title,
      description: this.state.description,
      price: this.state.price,
      quantity: this.state.quantity
    }
    axios.post('https://itpro2017.herokuapp.com/api/products', body)
      .then(function (response) {
        var p = response.data;
        self.setState({
          id: p.id,
          image: p.image,
          title: p.title,
          description: p.description,
          price: p.price,
          quantity: p.quantity
      });
      self.props.router.push('/admin/products/' + p.id);
    });
    e.preventDefault();
  },

  handleTitleChange: function(e) {
    this.setState({ title: e.target.value });
  },

  handleImageChange: function(e) {
    this.setState({ image: e.target.value });
  },

  handleDescriptionChange: function(e) {
    this.setState({ description: e.target.value });
  },

  handlePriceChange: function(e) {
    this.setState({ price: e.target.value });
  },

  handleQuantityChange: function(e) {
    this.setState({ quantity: e.target.value });
  },

  render: function() {
    return (
      <ProductAdministrationComponent
        id={this.state.id}
        image={this.state.image}
        title={this.state.title}
        description={this.state.description}
        price={this.state.price}
        quantity={this.state.quantity}
        onImageChange={this.handleImageChange}
        onTitleChange={this.handleTitleChange}
        onDescriptionChange={this.handleDescriptionChange}
        onPriceChange={this.handlePriceChange}
        onQuantityChange={this.handleQuantityChange}
        onSaveClick={this.handleSaveClick}
      />
    );
  }
});

window.ProductAdministrationContainer = ProductAdministrationContainer;
