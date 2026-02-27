package io.github.lorenasgc.vet.mapper;

import io.github.lorenasgc.vet.dto.PetOwnerDTO;
import io.github.lorenasgc.vet.model.PetOwner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PetMapper.class)
public interface PetOwnerMapper {
    PetOwnerDTO toDto(PetOwner petOwner);
}
