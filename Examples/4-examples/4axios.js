import PropTypes from 'prop-types';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

class HelloComponent extends React.Component {
              static propTypes = {
                    name: PropTypes.string.isRequired
                  }
    render() {
        return (<div>Hello {this.props.name}</div>);
    }
}

class App extends Component {
  state = { products: null }
  render() {
console.log("render");
console.log(this.state);
    var productsList = <div>Dar kraunama..</div>;
    if (this.state.products !== null) {
	  productsList = this.state.products.map(function (product, index) {
	    return (
	      <div key={index}>{product.title}
		{/*<!--key={index}
		id={product.id}
		image={product.image}
		title={product.title}
		description={product.description}
		price={product.price}-->*/}
	      </div>
	    );
	  });
    }
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React <HelloComponent name="Jane"/>
          </a>
		{productsList}
        </header>
      </div>
    );
  }
  componentDidMount() {
	  axios.get('https://itpro2017.herokuapp.com/api/products')
	    .then((response) => {
	      this.setState({ products: response.data });
	    })
  }

}

export default App;
