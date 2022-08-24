package com.packtpub.micronaut.service.impl;

import com.packtpub.micronaut.domain.Pet;
import com.packtpub.micronaut.repository.PetRepository;
import com.packtpub.micronaut.service.PetService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.Optional;

@Singleton                  // Use jakarta.inject.Singleton to designate a class as a singleton. In Java, Singleton is a design pattern that ensures that a class can only have one object
@Transactional              // This method modifies the database, thus it is annotated with @Transactional.
public class PerServiceImpl implements PetService {

    private final Logger log = LoggerFactory.getLogger(PerServiceImpl.class);
    private final PetRepository petRepository;

    public PerServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet save(Pet pet) {
        log.debug("Request to save Pet: {}",pet);
        return petRepository.margeAndSave(pet);
    }

    @Override
    @ReadOnly
    @Transactional
    public Page<Pet> findAll(Pageable pageable) {
        log.debug("Request to get all Pets");
        return petRepository.findAll(pageable);
    }

    @Override
    @ReadOnly
    @Transactional
    public Optional<Pet> findOne(Long id) {
        log.debug("Request to get Pet: {}",id);
        return petRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Pet: {}",id);
        petRepository.deleteById(id);

    }
}
