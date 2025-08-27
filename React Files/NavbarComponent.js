// src/ReactFiles/NavbarComponent.js

// Import React library
import React from "react";

// Import Bootstrap components for Navbar
import { Navbar, Nav, Container } from "react-bootstrap";

// Import NavLink from react-router-dom for navigation
import { NavLink } from "react-router-dom";

// Define NavbarComponent functional component
function NavbarComponent() {
  // Return JSX for Navbar
  return (
    // Bootstrap Navbar with dark theme and large expand option
    <Navbar bg="dark" variant="dark" expand="lg">
      {/* Container to center and add padding */}
      <Container>
        {/* Navbar Brand linking to home page using NavLink */}
        <Navbar.Brand as={NavLink} to="/">
          Income Tax Dept
        </Navbar.Brand>

        {/* Toggle button for collapsing navbar in small screens */}
        <Navbar.Toggle aria-controls="basic-navbar-nav" />

        {/* Collapsible section of the navbar */}
        <Navbar.Collapse id="basic-navbar-nav">
          {/* Navigation links aligned to the left (me-auto) */}
          <Nav className="me-auto">
            {/* Home link */}
            <Nav.Link as={NavLink} to="/" end>
              Home
            </Nav.Link>

            {/* Add Taxpayer link */}
            <Nav.Link as={NavLink} to="/add-taxpayer">
              Add Taxpayer
            </Nav.Link>

            {/* Taxpayer List link */}
            <Nav.Link as={NavLink} to="/taxpayer-list">
              Taxpayer List
            </Nav.Link>

            {/* Calculate Tax link */}
            <Nav.Link as={NavLink} to="/calculate-tax">
              Calculate Tax
            </Nav.Link>

            {/* Tax Rates link */}
            <Nav.Link as={NavLink} to="/tax-rates">
              Tax Rates
            </Nav.Link>

            {/* Contact link */}
            <Nav.Link as={NavLink} to="/contact">
              Contact
            </Nav.Link>

            {/* About link */}
            <Nav.Link as={NavLink} to="/about">
              About
            </Nav.Link>

            {/* FAQ link */}
            <Nav.Link as={NavLink} to="/faq">
              FAQ
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

// Export NavbarComponent so it can be used in other files
export default NavbarComponent;
