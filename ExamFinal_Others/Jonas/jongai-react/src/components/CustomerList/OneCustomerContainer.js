import React from 'react';
//import PropTypes from 'prop-types';
import OneCustomerComponent from './OneCustomerComponent';
import axios from 'axios';

class OneCustomerContainer extends React.Component {
  constructor(props, context) {
    super(props, context);
    this.state = {
      customerCode: "",
      firstName: "",
      lastName: '',
      birthday: '',
      phoneNumber: "",
      customerType: '',
      
      addedInventory: [],
      allInventory: [],
      inventoryToAdd: [],
      countriesToRemove: []
    }; 
  }

  //  handleAddToCart = (userName) => {      
  //     console.log("--------------vartotojo vardas yra " + userName);
  //     axios.post('http://localhost:8080/api/users/' + userName + '/cart-products', this.state)

  //         .then((response) => {
  //             console.log("Sėkminga" + response);
  //         })
  //         .catch(function (error) {
  //             console.log(error);
  //         });
  // }

  // handleChangeOfQuantity = (event) => {
  //     this.setState({ quantity: event.target.value });
  //     console.log(this.state.quantity);
  //   }

  componentDidMount() {
    this.getOneCustomer();
    this.getCustomerInventoryList();
    this.getInventoryList();
    
    // TODO kitus dalykus nuskaityti 

    //this.getHolidayCountryList();
    //this.getCountryList();
  }

  getOneCustomer() {
    const position = this.props.match.params.customerCode;
    axios.get('http://localhost:8080/api/customers/' + (position))
      .then((response) => {
        //this.setState(response.data);
        console.log("-----------------Response data id yra: " + response.data.id);
        console.log("-----------------Response data title yra: " + response.data.title);
        console.log("-----------------Response data simpleDate yra: " + response.data.simpleDate);
        this.setState({
          customerCode: response.data.customerCode,
          firstName: response.data.firstName,
          lastName: response.data.lastName,
          birthday: response.data.birthday,
          phoneNumber: response.data.phoneNumber,
          customerType: response.data.customerType
        
          

          // addedCountries: response.data.countries
          // aš galėčiau čia jau turėti visas šventės šalis, nes po @JsonIgnore galiu Listą iškart turėti prie šalies objekto
        })
      })
      .catch((error) => {
        console.log(error);
      });
  }

  getCustomerInventoryList() {
    const position = this.props.match.params.customerCode;
    axios.get('http://localhost:8080/api/customers/' + position + '/addedInventory')
      .then((response) => {
        this.setState({ addedInventory: response.data })
      })
      .catch((error) => {
        console.log(error);
      });
  }

  getInventoryList() {
    axios.get('http://localhost:8080/api/inventories')
      .then((response) => {
        this.setState({ allInventory: response.data.map(item => item.inventoryTitle) });
        console.log("Visas inventorius yra:");
        console.log(this.state.allInventory);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  availableInventorySelectionHandler = event => {
    this.setState({ countriesToAdd: [...event.target.selectedOptions].map(o => o.value) });
  }

  countryRemovingHandler = event => {
    this.setState({ countriesToRemove: [...event.target.selectedOptions].map(o => o.value) });
  }

  showAvailableInventory = () => {
    if (this.state.allInventory.length === 0) {
      return (
        <option value="" disabled>
          Nėra inventoriaus pasirinkimui
            </option>
      );
    } else {
      let inventories = this.state.allInventory
        .map((inventory, index) => {

          let isShown = true;

          this.state.addedInventory.forEach((c, index) => {
            if (c === inventory) {
              isShown = false;
            }
          });

          if (isShown)
            return (
              <option key={inventory + index} value={inventory}>
                {inventory}
              </option>
            );
          else {
            return null;
          }
        })
        .filter(c => c !== null);
      if (inventories.length === 0) {
        return (
          <option value="" disabled>
            Visas inventorius jau pasirinktas
              </option>
        );
      } else return inventories;
    }
  };

  addInventoryToCuctomer = event => {
    const position = this.props.match.params.customerCode;
    axios.put('http://localhost:8080/api/customers/' + position + '/addingInventory', this.state.inventoryToAdd)
      .then(() => this.getCustomerInventoryList())
      .catch(function (error) {
        console.log(error);
      });
  }

  removeCountriesFromHoliday = event => {
    const position = this.props.match.params.code;
    axios.put('http://localhost:8080/api/holidays/' + position + '/removingCountries', this.state.countriesToRemove)
      .then(() => this.getCustomerInventoryList())
      .catch(function (error) {
        console.log(error);
      });
  }

  render() {
    if (this.state.customerCode) {
      return (
        <div>
          <OneCustomerComponent
            customerCode={this.state.customerCode}
            firstName={this.state.firstName}
            lastName={this.state.lastName}
            birthday={this.state.birthday}
            phoneNumber={this.state.phoneNumber}
            customerType={this.state.customerType}
            
            
            addedInventory={this.state.addedInventory}
            allInventory={this.state.allInventory}
            showAvailableInventory={this.showAvailableInventory}
            availableInventorySelectionHandler={this.availableInventorySelectionHandler}
            addInventoryToCuctomer={this.addInventoryToCuctomer}
            removeCountriesFromHoliday={this.removeCountriesFromHoliday}
            countryRemovingHandler={this.countryRemovingHandler}
          />
        </div>
      );
    } else {
      return (
        <div className="text-center">
            <div className="spinner-border text-danger" role="status">
                <span className="sr-only">Loading data...</span>
            </div>
        </div>        
      );
    } 
  }
}

export default OneCustomerContainer;