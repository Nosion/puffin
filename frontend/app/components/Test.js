import React from 'react'
import { Link } from 'react-router'

export default React.createClass({
  render() {
    return (
      <div>
        <h1>Puffin - test</h1>
        <p className='lead'>Example test</p>
        <Link to='/home'>
          <button type='button' className='btn btn-lg btn-success'>Home</button>
        </Link>
      </div>
    )
  }
})
