import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
        <div>
        <h1>Welcome to URL shortener</h1>
      </div>
    );
  }
}

/**
 * Ajax error handler method.
 *
 * @param request - request object.
 * @param textStatus - status.
 */
function handleError (request) {
  if (request.status >= 400 && request.status <= 499) {
   alert("Client error: " + request.status + ' status code!');
 } else if (request.status >= 500 && request.status <= 599) {
   alert("Internal Server Error: " + request.status + " status code!");
 } else if (request.status === 0) {
   alert("Connection is refused!");
 } else {
   alert("Unable to execute request. Please, try again!");
 }
}

export default App;
