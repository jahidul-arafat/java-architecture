package com.packtpub.micronaut.repository;

import com.packtpub.micronaut.domain.Owner;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

// Concepts of Abstract Class and Interfaces
// ============================================
/*
* abstractClass<OwnerRepository> implements interface<JpaRepository<table_for_which_the_repository_is, table_primary_key_type>>
* Interface JpaRepository<E,ID>
    - E - the Entity type
    - ID - The ID type
* this interface<JpaRepository> further extends interfaces <CrudRepository> and <PageableRepository>
* Methods inherited from interface io.micronaut.data.repository.PageableRepository
*   - findAll
* Methods inherited from interface io.micronaut.data.repository.CrudRepository
*   - count
*   - delete
*   - deleteAll
*   - deleteById
*   - existsById
*   - findById
*   - save
*   - update
* to declare and define standard methods to support common CRUD operations in Table<Owners> as mapped with Domain<Owner>

* Why abstract class?
* -------------------
* Example:
* abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}
* From the example above, it is not possible to create an object of the Animal class:
* Animal myObj = new Animal(); // will generate an error
* To access the abstract class, it must be inherited from another class

* Why Java Interface?
* ---------------------
* - this is another way to achieve abstraction
* - An interface is a completely "abstract class" that is used to group related methods with empty bodies
* Example:
* interface Animal {
  public void animalSound(); // interface method (does not have a body)
  public void run(); // interface method (does not have a body)
}
* */
/**
 * Micronaut Data  repository for the Owner entity.
 */

@Repository
public abstract class OwnerRepository implements JpaRepository<Owner, Long> {
    // Why PersistenceContext and EntityManager?
    /*
    * What is PersistenceContext?
    * ----------------------------
    * PersistenceContext is the first level cache where all entities are fetched from the database or saved to the db. It sits in between our application and persistent storage
    * Persistence context keeps track of any changes made into a managed entity.
    * If anything changes during a <transaction>, then the entity is marked as <dirty>. When the transaction <completes>, these changes are flushed into persistent storage.
    *
    * What is EntityManager?
    * ----------------------
    * The EntityManager is the interface that lets us interact with the persistence context.
    * Whenever we use the EntityManager, we are actually interacting with the persistence context.
    *
    * Why EntityManager is used when we can directly interact with PersistenceContext?
    * --------------------------------------------------------------------------------
    * If every change made in the entity makes a call to persistent storage, we can imagine how many calls will be made.
    * This will lead to a performance impact because persistent storage calls are expensive.
    *
    * Types of PersistenceContext? - 2x
    * ---------------------------------
    * - Transaction-scoped persistence context // default type
    * - Extended-scoped persistence context //@PersistenceContext(type = PersistenceContextType.EXTENDED)
    *
    * */

    // PersistenceContext and EntityManager pair
    @PersistenceContext  // first level cache
    private final EntityManager entityManager;  // an interface to interact with PersistenceContext

    public OwnerRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public Owner mergeAndSave(Owner owner){
        owner = entityManager.merge(owner);
        return save(owner);
    }
}
