import React, {Component} from 'react';

import {Card, Form, Button} from 'react-bootstrap';

import axios from 'axios';

export default class AddBanner extends Component {

  constructor(props) {
    super(props);
    this.state = this.initialState;
    this.bannerChange = this.bannerChange.bind(this);
    this.submitBanner = this.submitBanner.bind(this);
  }

  initialState = {
    name:'', price:'', category:'', content:''
  }

  submitBanner = event => {
    event.preventDefault();

    const banner = {
      name: this.state.name,
      price: this.state.price,
      category: this.state.category,
      content: this.state.content
    };

    axios.post("http://localhost:8080/banner/addBanner", banner)
      .then(response => {
        if(response.data != null) {
          this.setState(this.initialState);
          alert("Banner added to BannerList");
        }
      });
  }

  bannerChange = event => {
    this.setState({
      [event.target.name]:event.target.value
    });
  }

  resetBanner = () => {
    this.setState(() => this.initialState);
  }

  render() {
    const {name, price, category, content} = this.state;

    return (
      <Card className={"border border-dark bg-dark text-white"} style={{ width: '30rem' }}>
        <Card.Header>Add new Banner</Card.Header>
        <Form onSubmit={this.submitBanner} onReset={this.resetBanner} id="bannerFormId">
          <Card.Body>
            <Form.Group controlId="formBannerName">
              <Form.Label>Banner name</Form.Label>
              <Form.Control autoComplete="off"
                name="name"
                type="test"
                value={name}
                onChange={this.bannerChange}
                className={"bg-dark text-white"}
                placeholder="Enter banner name"
              />
            </Form.Group>

            <Form.Group controlId="formBannerPrice">
              <Form.Label>Banner price</Form.Label>
              <Form.Control autoComplete="off"
                name="price"
                type="number"
                onChange={this.bannerChange}
                value={price}
                step="0.01"
                min="0"
                max="999999"
                className={"bg-dark text-white"}
                placeholder="Enter banner price"
              />
            </Form.Group>

            <Form.Group controlId="formBannerCategory">
              <Form.Label>Banner category</Form.Label>
              <Form.Control
                autoComplete="off"
                name="category"
                type="category"
                value={category}
                className={"bg-dark text-white"}
                as="select"
                defaultValue="Choose..."
                onChange={this.bannerChange}
              >
                <option></option>
              </Form.Control>
            </Form.Group>

            <Form.Group controlId="formBannerText">
              <Form.Label>Banner content</Form.Label>
              <Form.Control
                autoComplete="off"
                name="content"
                value={content}
                as="textarea"
                rows="3"
                onChange={this.bannerChange}
                className={"bg-dark text-white"}
              />
            </Form.Group>
          </Card.Body>

          <Card.Footer style={{"textAlign":"right"}}>
            <Button variant="secondary" href="/banner">Go back</Button>{' '}
            <Button variant="success" type="submit">Submit</Button>{' '}
            <Button variant="info" type="reset">Reset</Button>
          </Card.Footer>
        </Form>
      </Card>
    );
  }
}
