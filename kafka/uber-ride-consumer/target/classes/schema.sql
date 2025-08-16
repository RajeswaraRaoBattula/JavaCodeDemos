
CREATE TABLE IF NOT EXISTS rides (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  ride_id VARCHAR(100),
  driver_name VARCHAR(100),
  passenger_name VARCHAR(100),
  pickup_location VARCHAR(255),
  drop_location VARCHAR(255),
  fare DOUBLE,
  status VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
