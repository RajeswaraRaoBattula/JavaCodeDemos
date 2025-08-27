// src/ReactFiles/ChessTournamentForm.js

import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

// ✅ Validation schema
const validationSchema = Yup.object({
  playerName: Yup.string()
    .min(3, "Name must be at least 3 characters")
    .required("Required"),

  dob: Yup.date()
    .required("Required")
    .test("age-range", "Age must be between 5 and 90 years", function (value) {
      if (!value) return false;
      const age = new Date().getFullYear() - new Date(value).getFullYear();
      return age >= 5 && age <= 90;
    }),

  gender: Yup.string().required("Required"),

  fideId: Yup.string()
    .matches(/^\d{8}$/, "FIDE ID must be exactly 8 digits")
    .required("Required"),

  rating: Yup.number()
    .min(100, "Rating must be at least 100")
    .max(3000, "Rating must not exceed 3000")
    .required("Required"),

  email: Yup.string().email("Invalid email").required("Required"),

  mobile: Yup.string()
    .matches(/^[6-9]\d{9}$/, "Invalid mobile number")
    .required("Required"),

  country: Yup.string().required("Required"),

  category: Yup.string().required("Required"),

  // ✅ Fixed "branch is not a function" by making then/otherwise return functions
  parentContact: Yup.string().when("category", {
    is: (val) => val === "Under 12",
    then: () =>
      Yup.string()
        .matches(/^[6-9]\d{9}$/, "Invalid parent contact")
        .required("Parent contact is required"),
    otherwise: () => Yup.string().notRequired(),
  }),

  payment: Yup.boolean()
    .oneOf([true], "Payment confirmation is required")
    .required(),

  terms: Yup.boolean()
    .oneOf([true], "You must accept terms and conditions")
    .required(),
});

export default function ChessTournamentForm() {
  const [players, setPlayers] = useState([]);

  return (
    <div className="container mt-4">
      <h2 className="text-center text-primary mb-4">Chess Tournament Registration</h2>

      <Formik
        initialValues={{
          playerName: "",
          dob: "",
          gender: "",
          fideId: "",
          rating: "",
          email: "",
          mobile: "",
          country: "",
          category: "",
          parentContact: "",
          payment: false,
          terms: false,
        }}
        validationSchema={validationSchema}
        onSubmit={(values, { resetForm }) => {
          setPlayers([...players, values]);
          resetForm();
        }}
      >
        {({ values }) => (
          <Form className="card p-4 shadow-lg">
            {/* Player Name */}
            <div className="mb-3">
              <label className="form-label">Player Name</label>
              <Field name="playerName" className="form-control" />
              <ErrorMessage name="playerName" component="div" className="text-danger" />
            </div>

            {/* Date of Birth */}
            <div className="mb-3">
              <label className="form-label">Date of Birth</label>
              <Field name="dob" type="date" className="form-control" />
              <ErrorMessage name="dob" component="div" className="text-danger" />
            </div>

            {/* Gender */}
            <div className="mb-3">
              <label className="form-label">Gender</label>
              <Field as="select" name="gender" className="form-select">
                <option value="">Select</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
              </Field>
              <ErrorMessage name="gender" component="div" className="text-danger" />
            </div>

            {/* FIDE ID */}
            <div className="mb-3">
              <label className="form-label">FIDE ID</label>
              <Field name="fideId" className="form-control" />
              <ErrorMessage name="fideId" component="div" className="text-danger" />
            </div>

            {/* Rating */}
            <div className="mb-3">
              <label className="form-label">Rating</label>
              <Field name="rating" type="number" className="form-control" />
              <ErrorMessage name="rating" component="div" className="text-danger" />
            </div>

            {/* Email */}
            <div className="mb-3">
              <label className="form-label">Email</label>
              <Field name="email" type="email" className="form-control" />
              <ErrorMessage name="email" component="div" className="text-danger" />
            </div>

            {/* Mobile */}
            <div className="mb-3">
              <label className="form-label">Mobile</label>
              <Field name="mobile" className="form-control" />
              <ErrorMessage name="mobile" component="div" className="text-danger" />
            </div>

            {/* Country */}
            <div className="mb-3">
              <label className="form-label">Country</label>
              <Field name="country" className="form-control" />
              <ErrorMessage name="country" component="div" className="text-danger" />
            </div>

            {/* Category */}
            <div className="mb-3">
              <label className="form-label">Category</label>
              <Field as="select" name="category" className="form-select">
                <option value="">Select</option>
                <option value="Open">Open</option>
                <option value="Under 12">Under 12</option>
                <option value="Under 18">Under 18</option>
              </Field>
              <ErrorMessage name="category" component="div" className="text-danger" />
            </div>

            {/* Parent Contact (only if Under 12) */}
            {values.category === "Under 12" && (
              <div className="mb-3">
                <label className="form-label">Parent Contact</label>
                <Field name="parentContact" className="form-control" />
                <ErrorMessage
                  name="parentContact"
                  component="div"
                  className="text-danger"
                />
              </div>
            )}

            {/* Payment Confirmation */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="payment" className="form-check-input" />
              <label className="form-check-label">Payment Confirmed</label>
              <ErrorMessage name="payment" component="div" className="text-danger" />
            </div>

            {/* Terms & Conditions */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="terms" className="form-check-input" />
              <label className="form-check-label">Accept Terms & Conditions</label>
              <ErrorMessage name="terms" component="div" className="text-danger" />
            </div>

            {/* Submit */}
            <button type="submit" className="btn btn-success w-100">
              Register
            </button>
          </Form>
        )}
      </Formik>

      {/* Registered Players Table */}
      {players.length > 0 && (
        <div className="mt-5">
          <h4 className="text-center">Registered Players</h4>
          <table className="table table-bordered mt-3">
            <thead className="table-dark">
              <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Rating</th>
                <th>FIDE ID</th>
                <th>Country</th>
              </tr>
            </thead>
            <tbody>
              {players.map((p, index) => (
                <tr key={index}>
                  <td>{p.playerName}</td>
                  <td>{p.category}</td>
                  <td>{p.rating}</td>
                  <td>{p.fideId}</td>
                  <td>{p.country}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
