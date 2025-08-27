import React from 'react';

// Importing Formik components for form handling
import { Formik, Form, Field, ErrorMessage } from 'formik';

// Importing Bootstrap components for UI layout
import { Button, Row, Col } from 'react-bootstrap';

// Importing Yup for schema-based form validation
import * as Yup from 'yup';

// Defining validation schema using Yup
// Each field has rules like min/max length, required, number/email validation
const schema = Yup.object({
  name: Yup.string().min(3, 'Min 3 characters').required('Required'), 
  age: Yup.number().typeError('Must be a number').min(16).max(40).required('Required'),
  position: Yup.string()
    .oneOf(['Forward', 'Midfielder', 'Defender', 'Goalkeeper'], 'Select a valid position')
    .required('Required'),
  club: Yup.string().required('Required'),
  nationality: Yup.string().required('Required'),
  goals: Yup.number().typeError('Must be a number').min(0).required('Required'),
  matchesPlayed: Yup.number().typeError('Must be a number').min(0).required('Required'),
  jerseyNumber: Yup.number().typeError('Must be a number').min(1).max(99).required('Required'),
  email: Yup.string().email('Invalid email').required('Required'),
  contactNumber: Yup.string().matches(/^\d{10}$/, 'Must be 10 digits').required('Required'),
});

// Functional component: PlayerForm
// Props:
//  - initialValues → default values for form fields
//  - isEditing → true if editing an existing player
//  - onSubmit → function to handle form submission
//  - onCancelEdit → function to cancel editing
const PlayerForm = ({ initialValues, isEditing, onSubmit, onCancelEdit }) => {
  return (
    <div className="card p-4 mb-4">
      {/* Title changes dynamically based on Add/Edit mode */}
      <h4 className="mb-3">{isEditing ? 'Edit Player' : 'Add Player'}</h4>

      {/* Formik wrapper for handling form state, validation, and submission */}
      <Formik
        enableReinitialize // allows form to reset when initialValues change
        initialValues={initialValues} // form default values
        validationSchema={schema} // validation schema
        onSubmit={onSubmit} // callback on form submit
      >
        {/* Formik provides <Form> wrapper */}
        <Form>
          {/* First Row: Name, Age, Jersey Number */}
          <Row className="mb-3">
            <Col md={6}>
              <label className="form-label">Name</label>
              <Field name="name" className="form-control" />
              {/* Display validation error */}
              <div className="text-danger small"><ErrorMessage name="name" /></div>
            </Col>

            <Col md={3}>
              <label className="form-label">Age</label>
              <Field name="age" type="number" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="age" /></div>
            </Col>

            <Col md={3}>
              <label className="form-label">Jersey #</label>
              <Field name="jerseyNumber" type="number" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="jerseyNumber" /></div>
            </Col>
          </Row>

          {/* Second Row: Position and Club */}
          <Row className="mb-3">
            <Col md={6}>
              <label className="form-label">Position</label>
              <Field as="select" name="position" className="form-select">
                <option value="">-- Select --</option>
                <option value="Forward">Forward</option>
                <option value="Midfielder">Midfielder</option>
                <option value="Defender">Defender</option>
                <option value="Goalkeeper">Goalkeeper</option>
              </Field>
              <div className="text-danger small"><ErrorMessage name="position" /></div>
            </Col>

            <Col md={6}>
              <label className="form-label">Club</label>
              <Field name="club" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="club" /></div>
            </Col>
          </Row>

          {/* Third Row: Nationality, Goals, Matches Played */}
          <Row className="mb-3">
            <Col md={6}>
              <label className="form-label">Nationality</label>
              <Field name="nationality" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="nationality" /></div>
            </Col>

            <Col md={3}>
              <label className="form-label">Goals</label>
              <Field name="goals" type="number" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="goals" /></div>
            </Col>

            <Col md={3}>
              <label className="form-label">Matches Played</label>
              <Field name="matchesPlayed" type="number" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="matchesPlayed" /></div>
            </Col>
          </Row>

          {/* Fourth Row: Email and Contact Number */}
          <Row className="mb-3">
            <Col md={6}>
              <label className="form-label">Email</label>
              <Field name="email" type="email" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="email" /></div>
            </Col>

            <Col md={6}>
              <label className="form-label">Contact Number</label>
              <Field name="contactNumber" className="form-control" />
              <div className="text-danger small"><ErrorMessage name="contactNumber" /></div>
            </Col>
          </Row>

          {/* Action buttons: Submit + Cancel (only when editing) */}
          <div className="d-flex gap-2">
            <Button type="submit" variant={isEditing ? 'warning' : 'primary'}>
              {isEditing ? 'Update Player' : 'Add Player'}
            </Button>

            {isEditing && (
              <Button type="button" variant="secondary" onClick={onCancelEdit}>
                Cancel
              </Button>
            )}
          </div>
        </Form>
      </Formik>
    </div>
  );
};

// Exporting component
export default PlayerForm;
