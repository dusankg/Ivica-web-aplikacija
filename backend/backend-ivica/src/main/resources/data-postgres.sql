-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123

--INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58.508-07');
--INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58.508-07');

INSERT INTO USERS (dtype, username, password, first_name, last_name, email, enabled, last_password_reset_date, validated, verification_code) VALUES ('Agency', 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58.508-07', true, 11);

INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_GUEST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_AGENCY');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 3);
--INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
--INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

INSERT INTO LOCATION (city, latitude, longitude, number, postal_code, street, google_maps_url) VALUES ('Novi Sad', 1, 1, '5B', 21000, 'Jirecekova', 'https://maps.google.com/maps?q=Jirecekova%205B%20%Novi%20Sad&t=&z=20&ie=UTF8&iwloc=&output=embed');
INSERT INTO APARTMENT (dtype, active, for_sale, guests_number, rooms_number, location_id) VALUES ('ApartmentForRent', true, false, 4, 2, 1);
