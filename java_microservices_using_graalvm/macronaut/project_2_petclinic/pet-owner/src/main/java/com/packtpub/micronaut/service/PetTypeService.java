package com.packtpub.micronaut.service;

import com.packtpub.micronaut.domain.Pet;
import com.packtpub.micronaut.domain.PetType;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

public interface PetTypeService {
    PetType save(PetType petType);
    Page<PetType> findAll(Pageable pageable);
    Optional<PetType> findOne(Long id);
    void delete(Long id);
}
