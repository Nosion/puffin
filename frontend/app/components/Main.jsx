import React from 'react';

class Main extends React.Component {
  render() {
    if (!this.props.children) {
      return null;
    }
    return (
      <div className="main-container">
      {this.props.children}
      </div>
    );
  }
}

export default Main;
