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

      if(this.props.history.location.pathname === "/admin/products/new"){
        this.fromMenu = "Kuriamas naujas produktas";
      } else {
        var pathnameArray = this.props.history.location.pathname.split('/');
        if(pathnameArray[1] === "admin" && pathnameArray[2] === "products"){
          var number = pathnameArray[pathnameArray.length - 1];
          //console.log("Istrauktas numeris yra " + number);
          this.fromMenu = "Atnaujinamas produktas id: " + number;
        }
      }
      //console.log(this.props.history);

        return (
            <ProductAdministrationComponentForm handleChangeOfTitle={this.handleChangeOfTitle}
                                                handleChangeOfImageUrl={this.handleChangeOfImageUrl}
                                                handleChangeOfDescription={this.handleChangeOfDescription}
                                                handleChangeOfPrice={this.handleChangeOfPrice}
                                                handleChangeOfQuantity={this.handleChangeOfQuantity}
                                                handleSubmit={this.handleSubmit}
                                                fromMenu={this.fromMenu}
                                                />
        );
    }
}

export default ProductAdministrationComponent;