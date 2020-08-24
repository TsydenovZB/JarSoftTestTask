import React from 'react';

import {Jumbotron} from 'react-bootstrap';

class Welcome extends React.Component {
  render() {
    return (
      <Jumbotron className="bg-dark text-white">
        <h1>Welcome to Advertising App</h1>
        <p>
          Java developer test assignment by Jarsoft
        </p>
      </Jumbotron>
    );
  }
}

export default Welcome
