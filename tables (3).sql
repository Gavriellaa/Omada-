CREATE DATABASE programming_2;
USE programming_2;

-- Δημιουργία πίνακα πελατών
CREATE TABLE clients (
    client_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (client_id),
    UNIQUE (first_name, last_name, address)
);

-- Εισαγωγή δεδομένων πελατών
INSERT INTO clients (first_name, last_name, address) VALUES
('Αλέξανδρος', 'Παπαδόπουλος', 'Ομόνοια 1, Αθήνα'),
('Μαρία', 'Παπακώστα', 'Σταδίου 10, Αθήνα'),
('Γεώργιος', 'Καραγιάννης', 'Ακαδημίας 15, Αθήνα'),
('Ελένη', 'Σταυροπούλου', 'Σύνταγμα 5, Αθήνα'),
('Δημήτρης', 'Αλεξίου', 'Πανεπιστημίου 20, Αθήνα'),
('Κωνσταντίνος', 'Λαμπρόπουλος', 'Ερμού 50, Αθήνα'),
('Αναστασία', 'Παπαϊωάννου', 'Αθηνάς 30, Αθήνα'),
('Ιωάννης', 'Μανωλάς', 'Μητροπόλεως 3, Αθήνα');

-- Δημιουργία πίνακα οχημάτων
CREATE TABLE vehicles (
    vehicle_id INT NOT NULL AUTO_INCREMENT,
    vehicle_type VARCHAR(50) NOT NULL,
    capacity INT NOT NULL CHECK (capacity > 0),
    PRIMARY KEY (vehicle_id)
);

-- Εισαγωγή δεδομένων οχημάτων
INSERT INTO vehicles (vehicle_type, capacity) VALUES
('Φορτηγάκι', 600),
('Φορτηγό', 1800),
('Μικρό Βαν', 500),
('Μεσαίο Βαν', 1000),
('Φορτηγάκι', 700);

-- Δημιουργία πίνακα αποστάσεων
CREATE TABLE distances (
    client_id_1 INT NOT NULL,
    client_id_2 INT NOT NULL,
    distance DOUBLE NOT NULL CHECK (distance > 0),
    PRIMARY KEY(client_id_1, client_id_2),
    FOREIGN KEY(client_id_1) REFERENCES clients(client_id),
    FOREIGN KEY(client_id_2) REFERENCES clients(client_id)
);

-- Εισαγωγή δεδομένων αποστάσεων
INSERT INTO distances (client_id_1, client_id_2, distance) VALUES
(1, 2, 1.2),
(1, 3, 0.8),
(1, 4, 1.5),
(1, 5, 2.0),
(2, 3, 1.1),
(2, 4, 2.3),
(2, 5, 1.8),
(3, 4, 0.9),
(3, 5, 1.4),
(4, 5, 1.7),
(4, 6, 2.2),
(5, 6, 1.5),
(6, 7, 0.7),
(6, 8, 1.9),
(7, 8, 1.3);
