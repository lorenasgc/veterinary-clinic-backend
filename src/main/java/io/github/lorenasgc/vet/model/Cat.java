package io.github.lorenasgc.vet.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Cat extends Pet {
    private boolean isIndoor;
    private String breed;

    @Override
    public String getGeneralCheckupGuide() {
        return "Check for: Feline Leukemia, Kidney health, and Dental plaque.";
    }
}
