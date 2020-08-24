import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import NavigationBar from './components/NavigationBar'
import BannerList from './components/BannerList'
import AddBanner from './components/AddBanner'
import CategoryList from './components/CategoryList'
import AddCategory from './components/AddCategory'
import Welcome from './components/Welcome'

function App() {
  const marginTop = {
    marginTop:"20px"
  };

  return (
    <Router>
      <NavigationBar/>
      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
            <Switch>
              <Route path="/" exact component={Welcome}/>
              <Route path="/banner" exact component={BannerList}/>
              <Route path="/banner/addBanner" exact component={AddBanner}/>
              <Route path="/category" exact component={CategoryList}/>
              <Route path="/category/AddCategory" exact component={AddCategory}/>
            </Switch>
          </Col>
        </Row>
      </Container>
    </Router>
  );
}

export default App;
