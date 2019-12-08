import React from 'react';

var NoMatch = (props) => {
    var goApp = () => props.history.push("/");
    return <div>Route did not match
    <button onClick={goApp}>Go To Home Page</button></div>;
};

export default NoMatch;
