import React from 'react';

import {Navbar, Nav} from 'react-bootstrap';

class NavigationBar extends React.Component {
  render() {
    return (
        <Navbar bg="dark" variant="dark">
          <Navbar.Brand href="/">Home</Navbar.Brand>
          <Nav className="mr-auto">
            <Nav.Link href="/banner">Banners</Nav.Link>
            <Nav.Link href="/category">Categories</Nav.Link>
          </Nav>
        </Navbar>
    );
  }
}

export default NavigationBar
