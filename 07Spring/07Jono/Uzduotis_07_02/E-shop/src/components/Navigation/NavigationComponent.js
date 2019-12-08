import React from 'react';
import { Link } from 'react-router-dom';
import UserContext from '../../UserContext';

var NavigationComponent = (props) => {
    return (

        <div>
            <div>
                <Link to='/'>Home</Link> |&nbsp;
                   <Link to='/products'>Products</Link> |&nbsp;
                   <Link to={`/products/${1}`}>Product by no</Link> |&nbsp;
                   <Link to='/admin/products/new'>Enter new product</Link> |&nbsp;
                   <Link to={`/admin/products/${1}`}>Edit product</Link> |&nbsp;
                   <Link to='/help'>help</Link> |&nbsp;
                   <Link to='/non-existant'>Non Existant</Link> |&nbsp;
                <UserContext.Consumer>
                    {(suteikiuPavadinima) => <span>{suteikiuPavadinima}</span>}
                </UserContext.Consumer>
            </div>
            {props.children}
        </div>);

};

export default NavigationComponent;