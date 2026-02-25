package io.github.lorenasgc.vet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "dogs")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Dog extends Pet{

    private String breed;
    private boolean isWorkingDog; //Guide dog etc


    @Override
    public String getGeneralCheckupGuide() {
        return "Check for: Leishmaniasis, Hip Dysplasia, and Heartworm.";
    }
}
