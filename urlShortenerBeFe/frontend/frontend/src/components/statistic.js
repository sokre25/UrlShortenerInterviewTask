import React from 'react'
class Statistic extends React.Component {
  state = {
    accountIdValue : '',
    passwordValue : '',
  }


  handleChange = (event) => {
    this.setState({accountIdValue: event.target.value})
  }

  handleChange1 = (event) => {
    this.setState({passwordValue: event.target.value})
  }

  handleSubmit = (event) => {
  event.preventDefault();
  
  var request = new XMLHttpRequest();
  request.open('GET', 'http://localhost:8080/statistic/'+this.state.accountIdValue, true);
  request.setRequestHeader('Content-Type', "application/json; charset=utf-8");
  request.setRequestHeader ("Authorization", "Basic " + btoa(this.state.accountIdValue + ":" + this.state.passwordValue));
  request.setRequestHeader('Access-Control-Allow-Origin', '*');
  request.setRequestHeader('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS');
  request.setRequestHeader('Access-Control-Allow-Headers' ,'Origin, Content-Type, X-Auth-Token');
  request.timeout = 10000;
  
  request.onload = function () {
    var responseData = JSON.parse(request.response);

    console.log(request.response);


      if (request.status >= 200 && request.status < 400) {        
        var table = document.querySelector('table > tbody');
        
          for(var prop in responseData) {
            var rows = '';
            var trElement = document.createElement('tr');
            rows = '<td>'+prop+'</><br/><td>'+responseData[prop]+'</td><br/>';
            trElement.innerHTML = rows;
            table.appendChild(trElement);
          }

       } else {
    
       }
  };
  
  request.onerror = function () {
    handleError(request);
  };
  
  request.send();
  
  }

  render() {
    return (
      <div className="StatisticComponent">
      <h1>Get statistic</h1> 
      <p>Enter accountId and password to Get Statistic</p>
      <form className="RegUrl-Intro" onSubmit={this.handleSubmit}>
        <label> AccountId: </label>
        <input type="text" id="accountId" onChange={this.handleChange}/>
        <label>Password: </label>
        <input type="text" id="password" onChange={this.handleChange1}/>
        <input type="submit" value="Sumbit"/>
      </form>
      <table>
        <tbody>
        <tr><th>Full Url</th><th>Number of redirects</th></tr>
        </tbody>
      </table>
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

export default Statistic