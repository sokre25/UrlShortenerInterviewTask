import React from 'react'

class CreateAccount extends React.Component {
  
  state = {
    accountIdValue : ''
  }

  handleChange = (event) => {
    this.setState({accountIdValue: event.target.value})
  }
  
  handleSubmit = (event) => {
  event.preventDefault();
  
  var request = new XMLHttpRequest();
  request.open('POST', 'http://localhost:8080/account', true);
  request.setRequestHeader('Content-Type', "application/json; charset=utf-8");
  request.timeout = 10000;
  
  request.onload = function () {
    var responseData = JSON.parse(request.response);

      if (request.status >= 200 && request.status < 400) {
        alert("User is saved, Your password is: " + responseData['password']);      
       } else {
         alert("Status: " + responseData['status'] + " \nCode: " + responseData['code'] + "\nError Msg: " + responseData['AccountId'] + "\nEnter something and then submit your accountId.");
       }
  };
  
  request.onerror = function () {
    handleError(request);
  };
  
  var data = {"AccountId":this.state.accountIdValue}
  request.send(JSON.stringify(data));
  
  }
  
  render() {
    return (
      <div className="CreateAccountComponent">
      <h1>Register your account</h1> 
      <p>Enter desired AccountId</p>
      <form className="Reg-Intro" onSubmit={this.handleSubmit}>
        <input type="text" onChange={this.handleChange}/>
        <input type="submit" value="Sumbit"/>
      </form>
    </div>);
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

export default CreateAccount