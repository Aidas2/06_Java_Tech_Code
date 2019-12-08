import React from 'react';
import EditCountryComponent from './EditCountryComponent';
import axios from 'axios';
import { withRouter } from 'react-router';

class EditCountryContainer extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      oldTitle: "",
      countryCode: "",
      title: "",
      image: "",
      president: ""
    };
  }

  componentDidMount() {
    const position = this.props.match.params.countryCode;

    axios.get('http://localhost:8080/api/countries/' + (position))
      .then(response => {
        this.setState({ countryCode: response.data.countryCode});
        this.setState({ oldTitle: response.data.title });
        this.setState({ title: response.data.title });
        this.setState({ image: response.data.image });
        this.setState({ president: response.data.president });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleChangeOfTitle = (event) => {
    this.setState({ title: event.target.value });
    console.log(this.state.title);
  }

  handleChangeOfImage = (event) => {
    this.setState({ image: event.target.value });
  }

  handleChangeOfPresident = (event) => {
    this.setState({ president: event.target.president });
  }

  handleSubmit = event => {
    event.preventDefault();
    axios.put('http://localhost:8080/api/countries/' + (this.state.countryCode), this.state)

      .then(response => this.props.history.push(`/admin/countries`))
      .catch(error => {
        console.log(error);
      });

  }

  handleDelete = event => {
    event.preventDefault();
    axios.delete('http://localhost:8080/api/countries/' + (this.state.countryCode))
      .then(() => this.props.history.push(`/admin/countries`))
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    this.fromMenu = "Atnaujinama Šalis:";

    if (this.state.countryCode) {
      return (
        <EditCountryComponent
          currentCountryCode={this.state.countryCode}
          currentTitle={this.state.title}
          currentImage={this.state.image}
          currentPresident={this.state.president}
          handleChangeOfTitle={this.handleChangeOfTitle}
          handleChangeOfImage={this.handleChangeOfImage}
          handleChangeOfPresident={this.handleChangeOfPresident}
          handleSubmit={this.handleSubmit}
          handleDelete={this.handleDelete}
          fromMenu={this.fromMenu}

        />
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

export default withRouter(EditCountryContainer);