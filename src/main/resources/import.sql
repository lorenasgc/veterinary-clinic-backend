-- 1. Insertar Especies (Species)
INSERT INTO species (name) VALUES ('Dog');
INSERT INTO species (name) VALUES ('Cat');
-- 2. Insertar Diagnósticos (Diagnosis)
INSERT INTO diagnoses (name, description) VALUES ('Parvovirus', 'Viral disease that is very contagious in dogs.');
INSERT INTO diagnoses (name, description) VALUES ('Leishmaniasis', 'Parasitic disease spread by sandflies.');
INSERT INTO diagnoses (name, description) VALUES ('Feline Leukemia', 'Viral infection that only affects cats.');
INSERT INTO diagnoses (name, description) VALUES ('Kidney Disease', 'Common chronic condition in senior cats.');
-- 3. Poblar Tabla Pivotante (animal_type_diagnoses)
-- Relacionamos Parvovirus (ID 1) y Leishmaniasis (ID 2) con Perro (ID 1)
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (1, 1);
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (1, 2);
-- Relacionamos Leukemia (ID 3) y Kidney Disease (ID 4) con Gato (ID 2)
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (2, 3);
INSERT INTO species_diagnoses (species_id, diagnosis_id) VALUES (2, 4);