-- 1. Insert species (Species)
INSERT INTO species (name) VALUES ('Dog');
INSERT INTO species (name) VALUES ('Cat');
-- 2. Insert diagnoses (Diagnosis)
INSERT INTO diagnoses (name, description) VALUES ('Parvovirus', 'Viral disease that is very contagious in dogs.');
INSERT INTO diagnoses (name, description) VALUES ('Leishmaniasis', 'Parasitic disease spread by sandflies.');
INSERT INTO diagnoses (name, description) VALUES ('Feline Leukemia', 'Viral infection that only affects cats.');
INSERT INTO diagnoses (name, description) VALUES ('Kidney Disease', 'Common chronic condition in senior cats.');
-- 3. Insert data into the pivot table (species_diagnoses)
-- Link Parvovirus (ID 1) and Leishmaniasis (ID 2) to Dog (ID 1)
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (1, 1);
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (1, 2);
-- Link Feline Leukemia (ID 3) and Kidney Disease (ID 4) to Cat (ID 2)
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (2, 3);
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (2, 4);
-- 4. Insert clients (PetOwner)
INSERT INTO pet_owners (id, name, email, phone) VALUES (1, 'Owner1', 'owner1@example.com', '+359888888888');
INSERT INTO pet_owners (id, name, email, phone) VALUES (2, 'Owner2', 'owner2@example.com', '+359999999999');
-- 5. Insert pets (Pet) and their specific data
-- Insert a Dog (ID 1)
INSERT INTO pets (id, name, birth_date, gender, species_id, owner_id) VALUES (1, 'Buddy', '2021-01-01', true, 1, 1);
INSERT INTO dogs (id, breed, is_working_dog) VALUES (1, 'Golden Retriever', false);
-- Insert a Cat (ID 2)
INSERT INTO pets (id, name, birth_date, gender, species_id, owner_id) VALUES (2, 'Whiskers', '2022-02-02', false, 2, 2);
INSERT INTO cats (id, breed, is_indoor) VALUES (2, 'Siamese', true);
