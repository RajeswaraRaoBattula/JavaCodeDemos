import React, { useEffect, useState } from "react";
import axios from "axios";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { Table, Button } from "react-bootstrap";

const API_URL = "http://localhost:5000/players";

const PlayerSchema = Yup.object().shape({
  name: Yup.string().min(3, "Min 3 characters").required("Required"),
  age: Yup.number().min(16).max(40).required("Required"),
  position: Yup.string().required("Required"),
  club: Yup.string().required("Required"),
  nationality: Yup.string().required("Required"),
  goals: Yup.number().min(0).required("Required"),
  matchesPlayed: Yup.number().min(0).required("Required"),
  jerseyNumber: Yup.number().min(1).max(99).required("Required"),
  email: Yup.string().email("Invalid email").required("Required"),
  contactNumber: Yup.string().matches(/^\d{10}$/, "Must be 10 digits").required("Required"),
});

function PlayerManager() {
  const [players, setPlayers] = useState([]);
  const [editingPlayer, setEditingPlayer] = useState(null);

  // Fetch players
  const fetchPlayers = async () => {
    const res = await axios.get(API_URL);
    setPlayers(res.data);
  };

  useEffect(() => {
    fetchPlayers();
  }, []);

  // Add or Update Player
  const handleSubmit = async (values, { resetForm }) => {
    if (editingPlayer) {
      await axios.put(`${API_URL}/${editingPlayer.id}`, values);
      setEditingPlayer(null);
    } else {
      await axios.post(API_URL, values);
    }
    fetchPlayers();
    resetForm();
  };

  // Delete Player
  const handleDelete = async (id) => {
    await axios.delete(`${API_URL}/${id}`);
    fetchPlayers();
  };

  return (
    <div>
      {/* Player Form */}
      <Formik
        initialValues={
          editingPlayer || {
            name: "",
            age: "",
            position: "",
            club: "",
            nationality: "",
            goals: "",
            matchesPlayed: "",
            jerseyNumber: "",
            email: "",
            contactNumber: "",
          }
        }
        validationSchema={PlayerSchema}
        enableReinitialize
        onSubmit={handleSubmit}
      >
        {({ resetForm }) => (
          <Form className="mb-4 border p-3 rounded bg-light">
            <div className="row">
              {[
                "name","age","club","nationality",
                "goals","matchesPlayed","jerseyNumber","email","contactNumber"
              ].map((field) => (
                <div className="col-md-4 mb-3" key={field}>
                  <label className="form-label">{field}</label>
                  <Field name={field} className="form-control" />
                  <ErrorMessage name={field} component="div" className="text-danger" />
                </div>
              ))}

              {/* Position Select */}
              <div className="col-md-4 mb-3">
                <label className="form-label">Position</label>
                <Field as="select" name="position" className="form-control">
                  <option value="">Select</option>
                  <option value="Forward">Forward</option>
                  <option value="Midfielder">Midfielder</option>
                  <option value="Defender">Defender</option>
                  <option value="Goalkeeper">Goalkeeper</option>
                </Field>
                <ErrorMessage name="position" component="div" className="text-danger" />
              </div>
            </div>

            <Button type="submit" className="btn btn-success me-2">
              {editingPlayer ? "Update Player" : "Add Player"}
            </Button>
            <Button type="button" className="btn btn-secondary" onClick={() => { resetForm(); setEditingPlayer(null); }}>
              Reset
            </Button>
          </Form>
        )}
      </Formik>

      {/* Player Table */}
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Name</th><th>Age</th><th>Position</th>
            <th>Club</th><th>Goals</th><th>Matches</th>
            <th>Jersey</th><th>Email</th><th>Contact</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p) => (
            <tr key={p.id}>
              <td>{p.name}</td>
              <td>{p.age}</td>
              <td>{p.position}</td>
              <td>{p.club}</td>
              <td>{p.goals}</td>
              <td>{p.matchesPlayed}</td>
              <td>{p.jerseyNumber}</td>
              <td>{p.email}</td>
              <td>{p.contactNumber}</td>
              <td>
                <Button variant="warning" size="sm" className="me-2" onClick={() => setEditingPlayer(p)}>Edit</Button>
                <Button variant="danger" size="sm" onClick={() => handleDelete(p.id)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default PlayerManager;
