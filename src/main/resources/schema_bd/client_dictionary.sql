CREATE TABLE contact
(
    id INTEGER PRIMARY KEY NOT NULL,
    phone CHAR(64),
    email CHAR(64),
    google_drive_file_id VARCHAR(50),
    passport_data VARCHAR(30) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    dob DATE NOT NULL,
    amount_of_visits INTEGER NOT NULL,
    total_spent INTEGER NOT NULL,
    additional_info VARCHAR(1000)
);