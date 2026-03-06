package io.github.lorenasgc.vet.mapper;

import io.github.lorenasgc.vet.dto.DiagnosisDTO;
import io.github.lorenasgc.vet.model.Diagnosis;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiagnosisMapper {
    DiagnosisDTO toDto(Diagnosis diagnosis);
}
