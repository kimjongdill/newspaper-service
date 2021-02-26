import React from 'react';
import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Newspaper from './Newspaper';

function App() {
  return (
    <Router>
        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
          <Route path="/view/random">
            <Newspaper url="http://localhost:8080/random" />
          </Route>
          <Route path="/view/latest">
            <Newspaper url="http://localhost:8080/latest" />
          </Route>
          <Route path="/">
            <Newspaper url="http://localhost:8080/latest" />
          </Route>
        </Switch>
    </Router>
  );
}

export default App;
