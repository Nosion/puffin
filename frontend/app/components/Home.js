import React from 'react'
import { Link } from 'react-router'

export default React.createClass({
  render() {
    return (
      <div>
        <h1>Puffin</h1>
        <p className='lead'>Flying!</p>
        <Link to='/test'>
          <button type='button' className='btn btn-lg btn-success'>Test</button>
        </Link>
      </div>
    )
  }
})
