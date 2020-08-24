import React from 'react';

import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';

class NavigationBar extends React.Component {
  render() {
    return (
        <Navbar bg="dark" variant="dark">
          <Navbar.Brand href="/">Home</Navbar.Brand>
          <Nav className="mr-auto">
            <Link to={"/banner"} className="nav-link">Banners</Link>
            <Link to={"/category"} className="nav-link">Categories</Link>
            <Link to={"/bid"} className="nav-link">Get random banner</Link>
          </Nav>
        </Navbar>
    );
  }
}

export default NavigationBar
