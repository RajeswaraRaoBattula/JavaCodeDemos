import React from 'react';
import { Button, Table, ButtonGroup } from 'react-bootstrap';

const PlayerTable = ({ players, onEdit, onDelete }) => {
  return (
    <div className="card p-3">
      <h4 className="mb-3">Players</h4>
      <Table striped bordered hover responsive>
        <thead className="table-light">
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Position</th>
            <th>Club</th>
            <th>Goals</th>
            <th>Matches Played</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.length === 0 && (
            <tr><td colSpan="7" className="text-center">No players found.</td></tr>
          )}
          {players.map(p => (
            <tr key={p.id}>
              <td>{p.name}</td>
              <td>{p.age}</td>
              <td>{p.position}</td>
              <td>{p.club}</td>
              <td>{p.goals}</td>
              <td>{p.matchesPlayed}</td>
              <td>
                <ButtonGroup size="sm">
                  <Button variant="info" onClick={() => onEdit(p)}>Edit</Button>
                  <Button variant="danger" onClick={() => onDelete(p.id)}>Delete</Button>
                </ButtonGroup>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default PlayerTable;
