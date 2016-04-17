import React from 'react';

class Login extends React.Component {
  render() {
    return (
      <form>
        <div className="form-group">
          <label htmlFor="userInputName">User name</label>
          <input
            type="text" className="form-control" id="userInputName" placeholder="User name..."
          />
        </div>
        <div className="form-group">
          <label htmlFor="inputPassword">Password</label>
          <input
            type="password" className="form-control" id="inputPassword" placeholder="Password..."
          />
        </div>
      </form>
    );
  }
}

export default Login;
