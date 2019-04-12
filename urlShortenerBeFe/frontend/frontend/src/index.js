import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import { Route, Link, BrowserRouter as Router } from 'react-router-dom'
import App from './App';
import * as serviceWorker from './serviceWorker';
import RegisterUrl from './components/registerUrl';
import CreateAccount from './components/createAccount';
import Statistic from './components/statistic';
import Help from './components/help';


const routing = (
    <Router>
      <div>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/help">Help</Link>
        </li>
        <li>
          <Link to="/createAccount">Create Account</Link>
        </li>
        <li>
          <Link to="/registerUrl">Register url</Link>
        </li>
        <li>
          <Link to="/statistic">Statistic</Link>
        </li>
      </ul>
        <Route exact path="/" component={App} />
        <Route path="/registerUrl" component={RegisterUrl} />
        <Route path="/createAccount" component={CreateAccount} />
        <Route path="/statistic" component={Statistic} />
        <Route path="/help" component={Help} />
      </div>
    </Router>
  )
ReactDOM.render(routing, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
