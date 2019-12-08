import React from 'react';
import PropTypes from 'prop-types';
//import ProductCardComponent from '../ProductCardComponent/ProductCardComponent';
import TotalPrice from '../TotalPrice/TotalPrice';
import OneLine from '../OneLine/OneLine';

const ProductListComponent = (props) => {

  var productCards = props.products.map(function (product, index) {
      return (
          <ProductCardComponent
              key={index}
              title={product.title}
              imageUrl={product.imageUrl}
              description={product.description}
              price={product.price}
              quantity={product.quantity}
          />
      );
  });
  return (<div className="row">{productCards}</div>);
};

ProductListComponent.propTypes = {
  products: PropTypes.array.isRequired,
};

export default ProductListComponent;
               