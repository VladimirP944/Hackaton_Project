ALTER TABLE IF EXISTS ONLY services DROP CONSTRAINT IF EXISTS fk_service_home_owner_iduser_id CASCADE;
ALTER TABLE IF EXISTS ONLY services DROP CONSTRAINT IF EXISTS fk_applicant_id CASCADE;
ALTER TABLE IF EXISTS ONLY locations DROP CONSTRAINT IF EXISTS fk_home_owner_id CASCADE;
ALTER TABLE IF EXISTS ONLY applicants DROP CONSTRAINT IF EXISTS fk_home_id CASCADE;

DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS applicants;
DROP TABLE IF EXISTS home_owners;
DROP TABLE IF EXISTS admins;


CREATE TABLE applicants (
    id serial NOT NULL,
    username VARCHAR UNIQUE NOT NULL,
    password VARCHAR NOT NULL,
    photo_id VARCHAR,
    name VARCHAR ,
    extra_persons INTEGER DEFAULT 0 NOT NULL,
    phone_number VARCHAR,
    type VARCHAR,
    documents VARCHAR,
    applied_for_home boolean DEFAULT false NOT NULL,
    home_id INTEGER,
    PRIMARY KEY (id)
);


CREATE TABLE home_owners (
     id serial NOT NULL,
     username VARCHAR UNIQUE NOT NULL,
     password VARCHAR NOT NULL,
     photo_id VARCHAR,
     type VARCHAR,
     phone_number VARCHAR,
     name VARCHAR,
     photo_criminal_record VARCHAR,
     identity_card VARCHAR,
     PRIMARY KEY (id)
);


CREATE TABLE locations (
   id serial NOT NULL,
   home_owner_id INTEGER NOT NULL,
   address VARCHAR UNIQUE NOT NULL,
   available_space INTEGER NOT NULL,
   total_space INTEGER NOT NULL,
   start_date DATE DEFAULT NOW() NOT NULL,
   end_date DATE NOT NULL,
   photos VARCHAR NOT NULL,
   PRIMARY KEY (id)
);


CREATE TABLE services (
  id serial NOT NULL,
  home_owner_id INTEGER,
  applicant_id INTEGER,
  education boolean,
  pets boolean,
  medical_assistance boolean,
  disability_access boolean,
  creator boolean,
  PRIMARY KEY (id)
);


CREATE TABLE admins (
    id serial NOT NULL,
    username VARCHAR UNIQUE NOT NULL,
    password VARCHAR NOT NULL,
    PRIMARY KEY (id)
);


ALTER TABLE ONLY services
    ADD CONSTRAINT fk_service_home_owner_id FOREIGN KEY (home_owner_id) REFERENCES home_owners(id);

ALTER TABLE ONLY services
    ADD CONSTRAINT fk_applicant_id FOREIGN KEY (applicant_id) REFERENCES applicants(id);

ALTER TABLE ONLY locations
    ADD CONSTRAINT fk_home_owner_id FOREIGN KEY (home_owner_id) REFERENCES home_owners(id);

ALTER TABLE ONLY applicants
    ADD CONSTRAINT fk_home_id FOREIGN KEY (home_id) REFERENCES locations(id);