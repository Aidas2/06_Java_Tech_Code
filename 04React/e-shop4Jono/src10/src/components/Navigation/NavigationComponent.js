import React from 'react';
import { Link } from 'react-router-dom';
import UserContext from '../../UserContext';

var NavigationComponent = (props) => {
    return (

        <div>
            <div>




                <nav className="navbar navbar-expand-lg navbar-light bg-light">

                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active">
                                <Link to='/'>Home</Link> |&nbsp;
                            </li>
                            <li className="nav-item active">
                                <Link to='/admin'>Administration</Link> |&nbsp;
                            </li>
                            <li className="nav-item active">
                                {/*Cia yra nematomi punktai - nezinau ar jie reikalingi, kad navigavimas veiktu*/}
                                <Link to={`/products/${1}`}></Link>

                            </li>
                        </ul>
                        <form className="form-inline">
                            <input type="text" className="form-control mr-sm-2" name="currentUser" placeholder="User"></input>
                      </form>
                      <Link className="btn btn-success" to="/shoppingCart">Shopping cart</Link>
                    </div>
                </nav>



                    {/*<Link to='/'>Home</Link> |&nbsp;
                    <Link to='/products'>Products</Link> |&nbsp;
                   <Link to={`/products/${1}`}>Product by no</Link> |&nbsp;
                   <Link to='/admin/products/new'>Enter new product</Link> |&nbsp;
                   <Link to={`/admin/products/${1}`}>Edit product</Link> |&nbsp;
                   <Link to='/help'>help</Link> |&nbsp;
                   <Link to='/non-existant'>Non Existant</Link> |&nbsp;
                <UserContext.Consumer>
                        {(suteikiuPavadinima) => <span>{suteikiuPavadinima}</span>}
                    </UserContext.Consumer>
                    */}
            </div>
                {props.children}
            </div>);
    
    };
    
    export default NavigationComponent;
    
    
    
    
{/*

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
       </form>
  </div>
</nav>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>

*/}

            {/*

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        
</div>
</nav>

*/}
