import React from 'react';

class SelfDestructTimerComponent extends React.Component {
    constructor(){
        super();
        this.state = {
            countDown: 15,
            style: {
                width: "18rem",
                backgroundColor: ''
            }
        }
        this.myInterval = setInterval(this.countItDown, 1000);
    };


 countItDown = () => {
    this.setState({countDown: this.state.countDown - 1});
    if(this.state.countDown === 0){
        this.setState({style :{
            width: "18rem",
            backgroundColor: 'red'
        }});
        clearInterval(this.myInterval);
    }     
}

    render() {
        return (
            <div style={this.state.style}>
                <h5>{this.state.countDown}</h5>
            </div>
        );
    }
}

export default SelfDestructTimerComponent;