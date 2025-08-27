// HockeyForm.js
import React from "react";
import { Formik, Form, Field, FieldArray, ErrorMessage } from "formik";
import * as Yup from "yup";

const HockeyForm = () => {
  const initialValues = {
    playerName: "",
    jerseyNumber: "",
    position: "",
    stickHand: "",
    dob: "",
    nationality: "",
    email: "",
    phone: "",
    playerId: "",
    guardianName: "",
    teamName: "",
    leagueLevel: "",
    tournamentName: "",
    startDate: "",
    endDate: "",
    pastTeams: [{ clubName: "", years: "" }],
  };

  const validationSchema = Yup.object({
    playerName: Yup.string().required("Player name is required"),
    jerseyNumber: Yup.string().required("Jersey number is required"),
    position: Yup.string().required("Position is required"),
    stickHand: Yup.string().required("Stick hand is required"),
    dob: Yup.date().required("Date of birth is required"),
    nationality: Yup.string().required("Nationality is required"),
    email: Yup.string().email("Invalid email").required("Email is required"),
    phone: Yup.string().required("Phone is required"),
    playerId: Yup.string().required("Player ID is required"),
    guardianName: Yup.string().required("Guardian name is required"),
    teamName: Yup.string().required("Team name is required"),
    leagueLevel: Yup.string().required("League level is required"),
    tournamentName: Yup.string().required("Tournament name is required"),
    startDate: Yup.date().required("Start date is required"),
    endDate: Yup.date().required("End date is required"),
  });

  const handleSubmit = (values, { resetForm }) => {
    console.log(values);
    resetForm();
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Player Details</h2>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {({ values }) => (
          <Form>
            {/* Player Info */}
            <div>
              <label>Player Name</label>
              <Field name="playerName" type="text" />
              <ErrorMessage name="playerName" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Jersey Number</label>
              <Field name="jerseyNumber" type="text" />
              <ErrorMessage name="jerseyNumber" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Position</label>
              <Field as="select" name="position">
                <option value="">Select</option>
                <option value="Forward">Forward</option>
                <option value="Defense">Defense</option>
                <option value="Goalie">Goalie</option>
              </Field>
              <ErrorMessage name="position" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Stick Hand</label>
              <Field as="select" name="stickHand">
                <option value="">Select</option>
                <option value="Left">Left</option>
                <option value="Right">Right</option>
              </Field>
              <ErrorMessage name="stickHand" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Date of Birth</label>
              <Field name="dob" type="date" />
              <ErrorMessage name="dob" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Nationality</label>
              <Field name="nationality" type="text" />
              <ErrorMessage name="nationality" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Email</label>
              <Field name="email" type="email" />
              <ErrorMessage name="email" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Phone</label>
              <Field name="phone" type="text" />
              <ErrorMessage name="phone" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Player ID</label>
              <Field name="playerId" type="text" />
              <ErrorMessage name="playerId" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Guardian Name</label>
              <Field name="guardianName" type="text" />
              <ErrorMessage name="guardianName" component="div" style={{ color: "red" }} />
            </div>

            {/* Team & Event Info */}
            <h2>Team & Event Information</h2>
            <div>
              <label>Team Name</label>
              <Field name="teamName" type="text" />
              <ErrorMessage name="teamName" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>League Level</label>
              <Field as="select" name="leagueLevel">
                <option value="">Select</option>
                <option value="Amateur">Amateur</option>
                <option value="Professional">Professional</option>
              </Field>
              <ErrorMessage name="leagueLevel" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Tournament Name</label>
              <Field name="tournamentName" type="text" />
              <ErrorMessage name="tournamentName" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>Start Date</label>
              <Field name="startDate" type="date" />
              <ErrorMessage name="startDate" component="div" style={{ color: "red" }} />
            </div>

            <div>
              <label>End Date</label>
              <Field name="endDate" type="date" />
              <ErrorMessage name="endDate" component="div" style={{ color: "red" }} />
            </div>

            {/* Dynamic Past Teams */}
            <h3>Past Teams</h3>
            <FieldArray name="pastTeams">
              {({ push, remove }) => (
                <div>
                  {values.pastTeams.map((_, index) => (
                    <div key={index}>
                      <Field name={`pastTeams[${index}].clubName`} placeholder="Club Name" />
                      <Field name={`pastTeams[${index}].years`} placeholder="Years" />
                      <button type="button" onClick={() => remove(index)}>Remove</button>
                    </div>
                  ))}
                  <button type="button" onClick={() => push({ clubName: "", years: "" })}>
                    + Add Past Team
                  </button>
                </div>
              )}
            </FieldArray>

            {/* Buttons */}
            <div style={{ marginTop: "15px" }}>
              <button type="submit">Submit</button>
              <button type="reset">Reset</button>
            </div>
          </Form>
        )}
      </Formik>
    </div>
  );
};

export default HockeyForm;
