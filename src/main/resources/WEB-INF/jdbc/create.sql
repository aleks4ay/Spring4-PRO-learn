CREATE TABLE IF NOT EXISTS contact (
  id SERIAL NOT NULL,
  first_name VARCHAR(60) NOT NULL,
  last_name VARCHAR(60) NOT NULL,
  birth_date DATE,
--   UNIQUE uq_contact_1 (first_name, last_name),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contact_tel_detail (
  id SERIAL NOT NULL,
  contact_id INT NOT NULL,
  tel_type VARCHAR(20) NOT NULL,
  tel_number VARCHAR(20) NOT NULL,
--   UNIQUE uq_contact_detail_1 (contact_id),
  PRIMARY KEY (id),
  CONSTRAINT FK_contact_tel_detail_1 FOREIGN KEY (contact_id) REFERENCES contact(id)
);