package io.github.lorenasgc.vet.mapper;

import io.github.lorenasgc.vet.dto.response.PetDTO;
import io.github.lorenasgc.vet.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(source = "species.id", target = "speciesId")
    @Mapping(source = "owner.id", target = "ownerId")
    PetDTO toDto(Pet pet);
}
