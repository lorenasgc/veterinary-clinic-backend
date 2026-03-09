package io.github.lorenasgc.vet.model;

public enum Role {
    ADMIN,         // Full control of the API
    VET,           // Medical management (diagnoses, treatments, history)
    RECEPTIONIST,  // Administrative management (clients, basic pets, schedule, payments)
    CLIENT         // Read-only access to their data and appointment requests
}
