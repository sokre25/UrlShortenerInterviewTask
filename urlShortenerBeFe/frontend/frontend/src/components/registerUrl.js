import React from 'react'
class RegisterUrl extends React.Component {
  state = {
    accountIdValue : '',
    passwordValue : '',
    urlValue : ''
  }


  handleChange = (event) => {
    this.setState({accountIdValue: event.target.value})
  }

  handleChange1 = (event) => {
    this.setState({passwordValue: event.target.value})
  }

  handleChange2 = (event) => {
    this.setState({urlValue: event.target.value})
  }
  
  handleSubmit = (event) => {
  event.preventDefault();
  
  var request = new XMLHttpRequest();
  request.open('POST', 'http://localhost:8080/register', true);
  request.setRequestHeader('Content-Type', "application/json; charset=utf-8");
  request.setRequestHeader ("Authorization", "Basic " + btoa(this.state.accountIdValue + ":" + this.state.passwordValue));
  request.setRequestHeader('Access-Control-Allow-Origin', '*');
  request.setRequestHeader('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS');
  request.setRequestHeader('Access-Control-Allow-Headers' ,'Origin, Content-Type, X-Auth-Token');
  request.timeout = 10000;
  
  request.onload = function () {
    var responseData = JSON.parse(request.response);

      if (request.status >= 200 && request.status < 400) {
        alert("url is saved, Your shortUrl is: " + responseData['shortUrl']);      
       } else {
         alert("Status: " + responseData['status'] + " \nCode: " + responseData['code'] + "\nError Msg: " + responseData['AccountId'] + "\nEnter something and then submit");
       }
  };
  
  request.onerror = function () {
    handleError(request);
  };
  
  var data = {"url":this.state.urlValue}
  request.send(JSON.stringify(data));
  
  }

  render() {
    return (
      <div className="RegisterUrlComponent">
      <h1>Register url</h1> 
      <p>Enter accountId, password and desired url</p>
      <form className="RegUrl-Intro" onSubmit={this.handleSubmit}>
        <label> AccountId: </label>
        <input type="text" id="accountId" onChange={this.handleChange}/>
        <label>Password: </label>
        <input type="text" id="password" onChange={this.handleChange1}/>
        <label> Url: </label>
        <input type="text" id="Url" onChange={this.handleChange2}/>
        <input type="submit" value="Sumbit"/>
      </form>
    </div>
    );
  }
}

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
export default RegisterUrl