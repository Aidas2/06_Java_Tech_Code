import React from 'react';
import ProductAdministrationComponentForm from './ProductAdministrationComponentForm';

class ProductAdministrationComponent extends React.Component {
    constructor() {
        super();
        this.state = {title: '',
                        imageUrl: '',
                        description: '',
                        price: 0,
                        quantity:0                
        };
       
      }
      
      
      handleChangeOfTitle = (event) => {
        this.setState({title: event.target.value});
        console.log(this.state.title);
      }

      handleChangeOfImageUrl = (event) => {
        this.setState({imageUrl: event.target.value});
      }

      handleChangeOfDescription = (event) =>{
        this.setState({description: event.target.value});
      }

      handleChangeOfPrice = (event) => {
        this.setState({price: event.target.value});
      }

      handleChangeOfQuantity = (event) => {
        this.setState({quantity: event.target.value});
      }

      handleSubmit = (event) => {
        //alert('A name was submitted: ' + this.state.value);
        event.preventDefault();
        console.log(this.state);

      }

    render() {
        return (
            <ProductAdministrationComponentForm handleChangeOfTitle={this.handleChangeOfTitle}
                                                handleChangeOfImageUrl={this.handleChangeOfImageUrl}
                                                handleChangeOfDescription={this.handleChangeOfDescription}
                                                handleChangeOfPrice={this.handleChangeOfPrice}
                                                handleChangeOfQuantity={this.handleChangeOfQuantity}
                                                handleSubmit={this.handleSubmit}
                                                />
        );
    }
}

export default ProductAdministrationComponent;