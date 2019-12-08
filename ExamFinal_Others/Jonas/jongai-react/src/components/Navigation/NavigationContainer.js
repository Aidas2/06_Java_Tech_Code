import React from 'react';
import NavigationComponent from './NavigationComponent';
import { Route, BrowserRouter, Switch } from "react-router-dom";
import CustomerListContainer from '../CustomerList/CustomerListContainer';
import NewCustomerContainer from '../CustomerAdministration/NewCustomerContainer';
import OneCustomerContainer from '../CustomerList/OneCustomerContainer';


class NavigationContainer extends React.Component {
    //constructor(props) {
        //super(props);
        // this.state = {
        //     user: ""
        // };
    //}

    //Nenaudojamas metodas
    // handleChangeOnName = (event) => {     
    //     this.setState({ user: event.target.value });           
    // }

    render() {
        return (
            //Ankstesnis budas
            //   <NavigationComponent children={this.props.children} userName={this.state.user} handleChangeOnName={this.handleChangeOnName} />
            // Dabar cia atsiranda <BrowserRouter> elementas. Anksciau jis buvo faile App.js
            
            <BrowserRouter>
                {/* Nebūtina siųsti children */}
                <NavigationComponent children={this.props.children} onClickLogoutHandler={this.props.onClickLogoutHandler}>
                    <Switch>
                        <Route path="/" render={props => (
                            <CustomerListContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/newCustomer" render={props => (
                            <NewCustomerContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/customers/:customerCode" render={props => (
                            <OneCustomerContainer {...props} />
                        )}
                        exact
                        />
                        
                        {/* <Route path="/holidays/:code" render={props => (
                            <OneHolidayContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/holidays" render={props => (
                            <HolidayAdministrationListContainer {...props} />
                        )}
                        exact
                        />
                         <Route path="/admin/countries" render={props => (
                            <CountryAdministrationContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/holidays/new" render={props => (
                            <NewHolidayContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/holidays/:code" render={props => (
                            <EditHolidayContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/countries/new" render={props => (
                            <NewCountryContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/countries/:countryCode" render={props => (
                            <EditCountryContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/countries/:countryCode" render={props => (
                            <OneCountryContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/newUser" render={props => (
                            <NewUserContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/carts" render={props => (
                            <CartAdministrationListContainer {...props} />
                        )}
                        exact
                        />
                        <Route path="/admin/carts/new" render={props => (
                            <NewCartContainer {...props} />
                        )}
                        exact
                        /> */}
                    </Switch>    
                </NavigationComponent>
            </BrowserRouter>
            
                   
        );
    }
}

export default NavigationContainer;