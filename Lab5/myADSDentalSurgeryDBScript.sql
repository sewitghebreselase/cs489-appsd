CREATE TABLE address (
	id int NOT NULL,
  	street varchar(50) NULL,
	state varchar(50) NULL,
	city varchar(50) NULL,
	zipcode int NULL,
	PRIMARY KEY (id)
);


CREATE TABLE dentist (
  	id int NOT NULL,
	firstname varchar(50) NULL,
	lastname varchar(50) NULL,
	contactphone varchar(50) NULL,
	email varchar(50) NULL,
	specialization varchar(50) NULL,
	PRIMARY KEY (id)
);


CREATE TABLE patient (
	id int NOT NULL,
	firstname varchar(50) NULL,
	lastname varchar(50) NULL,
	phone varchar(50) NULL,
	email varchar(50) NULL,
	dob date NULL,
	a_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (a_id) REFERENCES address(id)
);


CREATE TABLE surgerylocation (
	id int NOT NULL,
	name varchar(50) NULL,
	phonenumber varchar(50) NULL,
	a_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (a_id) REFERENCES address(id)
);

CREATE TABLE appointment (
	id int NOT NULL,
	appdate date NULL,
	location varchar(50) NULL,
	status varchar(50) NULL,
	a_id int,
	d_id int,
	p_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (a_id) REFERENCES address(id),
	FOREIGN KEY (d_id) REFERENCES dentist(id),
	FOREIGN KEY (p_id) REFERENCES patient(id)
);


-----------------------------------------------------------------------------------------

-- Dummy data for address table
INSERT INTO address (id, street, state, city, zipcode)
VALUES 
    (1, '306 vernon', 'CA', 'Oakland', 94610),
    (2, '473 Buena vista St', 'CA', 'Alameda', 94501),
    (3, '789 Ranchwood St', 'TX', 'Wylie', 75001);

-- Dummy data for dentist table
INSERT INTO dentist (id, firstname, lastname, contactphone, email, specialization)
VALUES 
    (1, 'Sewit', 'Ghebre', '206-463-2745', 'sewitg.ghebreselase@miu.edu', 'Dentist'),
    (2, 'Abiel', 'Alazar', '987-654-3210', 'abiel.alazar@example.com', 'Orthodontics');

-- Dummy data for patient table
INSERT INTO patient (id, firstname, lastname, phone, email, dob, a_id)
VALUES 
    (1, 'Mike', 'Smith', '111-222-3333', 'mike.smith@example.com', '1995-07-10',1),
    (2, 'Chris', 'John', '444-555-6666', 'chris.john@example.com', '1988-12-11',3);

-- Dummy data for surgerylocation table
INSERT INTO surgerylocation (id, name, phonenumber, a_id)
VALUES 
    (1, 'Dental Clinic', '555-123-4567',2),
    (2, 'Orthodontics Center', '555-987-6543',2);

-- Dummy data for appointment table
INSERT INTO appointment (id, appdate, location, status, a_id, d_id, p_id)
VALUES 
    (1, '2024-04-08', 'Dental Clinic', 'Scheduled', 1, 2, 1),
    (2, '2024-04-12', 'Orthodontics Center', 'Scheduled', 2, 1, 1);


-------------------------------------------------------------------------------

-- 1. Display the list of ALL Dentists registered in the system, sorted in ascending order of their lastNames
SELECT * FROM Dentist ORDER BY lastname  ASC;

-- 2. Display the list of ALL Appointments for a given Dentist by their dentist_Id number. Include in the result, the Patient information.
SELECT A.*, P.firstname  AS patient_first_name, P.lastname  AS patient_last_name
FROM Appointment A
JOIN Patient P ON A.p_id  = P.id 
JOIN dentist d ON A.d_id = d.id 
WHERE A.d_id = d.id;


-- 3. Display the list of ALL Appointments that have been scheduled at a Surgery Location
SELECT * FROM Appointment WHERE location = 'Dental Clinic';

-- 4. Display the list of the Appointments booked for a given Patient on a given Date.
SELECT * 
FROM Appointment A
JOIN patient p on a.p_id  = p.id 
WHERE appdate  = '2024-04-08';
