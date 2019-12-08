import React from 'react';
import { Link } from 'react-router-dom';
import UserContext from '../../UserContext';

var NavigationComponent = (props) => {
    return (

        <div>
            <div>
                <Link to='/'>Home</Link> |&nbsp;
                   <Link to='/countrys'>Countrys</Link> |&nbsp;
                   <Link to={`/countrys/${1}`}>Country by no</Link> |&nbsp;
                   <Link to='/admin/countrys/new'>Enter new country</Link> |&nbsp;
                   <Link to={`/admin/countrys/${1}`}>Edit country</Link> |&nbsp;
                   <Link to='/help'>Help</Link> |&nbsp;
                   <Link to='/non-existant'>Non Existant</Link> |&nbsp;
                <UserContext.Consumer>
                    {(suteikiuPavadinima) => <span>{suteikiuPavadinima}</span>}
                </UserContext.Consumer>
            </div>
            {props.children}
        </div>);

};

export default NavigationComponent;
