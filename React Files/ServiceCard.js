import React from "react";

const ServiceCard = ({ service }) => {
  return (
    <div className="col-md-4 mb-4">
      <div className="card shadow-sm h-100">
        <div className="card-body">
          <h4 className="card-title">{service.serviceName}</h4>
          <p className="card-text">
            <strong>Price:</strong> ${service.price}
          </p>
          <p className="card-text">
            <strong>Fabrics:</strong>
          </p>
          <ul>
            {service.fabricsAvailable.map((fabric, index) => (
              <li key={index}>{fabric}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ServiceCard;
