package com.packtpub.micronaut.service.impl;

import com.packtpub.micronaut.domain.PetType;
import com.packtpub.micronaut.repository.PetTypeRepository;
import com.packtpub.micronaut.service.PetTypeService;
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
public class PetTypeServiceImpl implements PetTypeService {
    // Note: PetTypeService will underneath a call to PetTypeRepository which implements JPARepository which extends both CRUD and Pageable interfaces

    private final Logger log = LoggerFactory.getLogger(PetTypeServiceImpl.class);
    private final PetTypeRepository petTypeRepository;

    // constructor
    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {    // Note: It's not possible to create an object of an abstractClass.
                                                                        // To access the abstract class, it must be inherited from another class.
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType save(PetType petType) {
        log.debug("Request to save PetType: {}",petType);
        return petTypeRepository.margeAndSave(petType);
    }

    @Override
    @ReadOnly
    @Transactional
    public Page<PetType> findAll(Pageable pageable) {
        log.debug("Request to get all PetTypes");
        return petTypeRepository.findAll(pageable);
    }

    @Override
    @ReadOnly
    @Transactional
    public Optional<PetType> findOne(Long id) {
        log.debug("Request to get PetType: {}", id);
        return petTypeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PetType: {}", id);
        petTypeRepository.deleteById(id);

    }
}
