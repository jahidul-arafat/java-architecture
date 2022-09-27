package com.packtpub.micronaut.service;

import com.packtpub.micronaut.domain.Owner;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

/*
* Service method definitions essentially delegate execution to the downstream repository.
* The OwnerService interface provides an abstract declaration of all service methods.
* We can implement all declared methods in a concrete class
* */
public interface OwnerService {

    // Method_01: save() - save the Entity into the persistence storage after all the CRUD operations are done
    /** Save an owner
    *  @param owner the entity to save
    *  @return: the persisted entity
    * */
    Owner save(Owner owner);

    // Method_02: findAll() - find all the owners, i.e. list all the owners
    /**
     * Get all the Owners
     * @param pageable the pagination information
     * @return the list of entities
     * */

    /*
    * Page<T>
    * Inspired by the Spring Data's Page and GORM's PagedResultList, this models a type that supports pagination operations.
    * A Page is a result set associated with a particular Pageable that includes a calculation of the total size of number of records.
    * */
    Page<Owner> findAll(Pageable  pageable);

    // Method_03: findOne() - find a specific owner with their <id>
    /**
     * Ge the "id" of the "owner"
     * @param id the id of the owner
     * @return the entity <owner>
     * */

    /*
    * Optional<T>: A container object which may or may not contain a non-null value
    * If a value is present, isPresent() will return true and get() will return the value
    * */
    Optional<Owner> findOne(Long id); // Optional<T> : A container object which may or may not contain a non-null value.



    // Method_04: delete() - delete a specific owner, search with their <id>
    /**
     * Delete the owner, look using their "id"
     * @param id the "id" of the entity
     * */
    void delete(Long id);



}
