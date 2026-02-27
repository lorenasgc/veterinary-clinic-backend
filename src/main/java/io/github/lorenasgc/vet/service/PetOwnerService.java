package io.github.lorenasgc.vet.service;

import io.github.lorenasgc.vet.dto.PetOwnerDTO;
import io.github.lorenasgc.vet.mapper.PetOwnerMapper;
import io.github.lorenasgc.vet.repository.PetOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetOwnerService {

    private final PetOwnerRepository petOwnerRepository;
    private final PetOwnerMapper petOwnerMapper;

    @Transactional(readOnly = true)
    public List<PetOwnerDTO> findAll() {
        return petOwnerRepository.findAllWithPets().stream()
                .map(petOwnerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<PetOwnerDTO> findById(Long id) {
        return petOwnerRepository.findById(id)
                .map(petOwnerMapper::toDto);
    }
}
