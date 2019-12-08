import React from 'react';
import { Link } from 'react-router-dom';

var NavigationComponent = (props) => {
    return (
        <div>
            <div className="container my-3">
                <ul className="nav nav-pills justify-content-center">
                    <li className="nav-item">
                        <Link to='/' className="btn btn-success">Home</Link> &nbsp;
                    </li>
                    {/* <li className="nav-item">
                        <Link to='/admin/holidays' className="btn btn-success">Holiday administration</Link> &nbsp;
                    </li>
                    <li className="nav-item">
                        <Link to='/admin/countries' className="btn btn-success">Country administration</Link> &nbsp;
                    </li> */}
                    {/* Login mygtukas yra nereikalingas
                    <li className="nav-item">
                        <Link to='/login' className="btn btn-success">Login</Link> &nbsp;
                    </li> */}

                    {/* Cia yra Link, bet ji perdarau i Button
                    <li className="nav-item">
                        <Link to='/logout' className="btn btn-success">Logout</Link> &nbsp;
                    </li> */}
                    <li className="nav-item">
                        <button className="btn btn-danger" onClick={props.onClickLogoutHandler}>Logout</button>&nbsp;
                    </li>
                    {/* <li className="nav-item">
                        <Link to='/newUser' className="btn btn-primary">Create new user</Link> &nbsp;
                    </li>
                    <li className="nav-item">
                        <Link to='/admin/carts' className="btn btn-info">Cart administration</Link> &nbsp;
                    </li> */}
                </ul>

                {/* <form className="form-inline">
                            <input type="text" className="form-control mr-sm-2" onChange={props.handleChangeOnName}
                                value={props.userName} name="currentUser" placeholder="User"></input>
                        </form>
                        <UserContext.Consumer>
                            {
                                (userNameObject) => {
                                    let linkas = "/shopping-Cart/" + userNameObject.user;
                                    return <Link className="btn btn-success" to={linkas} >Shopping cart</Link>
                                }
                            }
                        </UserContext.Consumer> */}
            </div>
            {props.children}
        </div>
    );

};

export default NavigationComponent;

