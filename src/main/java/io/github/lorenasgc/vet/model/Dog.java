package io.github.lorenasgc.vet.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Dog extends Pet{

    private String breed;
    private boolean isWorkingDog; //Guide dog etc


    @Override
    public String getGeneralCheckupGuide() {
        return "Check for: Leishmaniasis, Hip Dysplasia, and Heartworm.";
    }
}
