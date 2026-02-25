package io.github.lorenasgc.vet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "cats")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Cat extends Pet {
    private boolean isIndoor;
    private String breed;

    @Override
    public String getGeneralCheckupGuide() {
        return "Check for: Feline Leukemia, Kidney health, and Dental plaque.";
    }
}
