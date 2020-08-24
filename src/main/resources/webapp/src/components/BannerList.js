import React, {Component} from 'react';
import axios from 'axios';

import {Card, Table, Button, ButtonGroup} from 'react-bootstrap';

export default class BannerList extends Component {

  constructor(props) {
    super(props);
    this.state = {
      banners : []
    };
  }

  componentDidMount() {
    axios.get("http://localhost:8080/banner")
          .then(response => response.data)
          .then((data) => {
            this.setState({banners: data})
          });
  }

  render() {
    return (
      <Card className={"border border-dark bg-dark text-white"}>
        <Card.Header>Banner List</Card.Header>
        <Card.Body>
          <Table striped bordered hover variant="dark">
            <thead>
              <tr>
                <th>#</th>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Content</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {
                this.state.banners.length === 0 ?
                <tr align="center">
                  <td colSpan="6">Banners Available.</td>
                </tr> :
                this.state.banners.map((banner) => (
                <tr key={banner.id}>
                  <td>{banner.id}</td>
                  <td>{banner.name}</td>
                  <td>{banner.price}</td>
                  <td>#{banner.category.id} : {banner.category.name}</td>
                  <td>{banner.content}</td>
                  <td>
                    <ButtonGroup>
                      <Button size="sm" variant="primary">Edit</Button>{' '}
                      <Button size="sm" variant="danger">Delete</Button>
                    </ButtonGroup>
                  </td>
                </tr>
                ))
              }
            </tbody>
          </Table>
          <Button variant="primary" href="/banner/addBanner">Add new Banner</Button>
        </Card.Body>
      </Card>
    );
  }
}
