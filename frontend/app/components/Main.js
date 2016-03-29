import React from 'react'

export default React.createClass({
  render() {
    return (
      <div>
        <div className='main-container'></div>
        {this.props.children}
      </div>
    )
  }
})
