import React from 'react';
import { Link } from 'react-router';
import Login from '../components/Login';

class Test extends React.Component {
  render() {
    return (
      <div>
        <h1>Puffin - test</h1>
        <p className="lead">Example test</p>
        <Link to="/home">
          <button type="button" className="btn btn-lg btn-success">Home</button>
        </Link>
        <h1>Test components:</h1>
        <Login />
      </div>
    );
  }
}

export default Test;
