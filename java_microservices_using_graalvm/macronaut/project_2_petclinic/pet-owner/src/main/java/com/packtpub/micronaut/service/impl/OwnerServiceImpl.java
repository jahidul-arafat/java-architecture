package com.packtpub.micronaut.service.impl;

import com.packtpub.micronaut.domain.Owner;
import com.packtpub.micronaut.repository.OwnerRepository;
import com.packtpub.micronaut.service.OwnerService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import javax.transaction.Transactional;

import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Optional;

/**
 * @description Service Implementation for managing {@link Owner}
 * @strategy implements interface {@link OwnerService}
 * @strategy a downstream call to {@link OwnerRepository} to flush the data in persistence database
 * @annotation @Singleton - is used to declare to "Dagger" that the provided object is to be initialized only once during the entire lifecycle of the component which uses that Module
 * @annotation @Transactional annotation is written at the service level. It is used to combine more than one writes on a database as a single atomic operation. When somebody call the method annotated with @Transactional all or none of the writes on the database is executed
 *
 * */

/*
* Explanation - @Singleton
* In Java, Singleton is a design pattern that ensures that a class can only have one object
* With CDI (Contexts and Dependency Injection), we can easily create singletons using the @Singleton annotation. This annotation is a part of the javax.inject package. It instructs the container to instantiate the singleton once and passes its reference to other objects during the injection.
As we can see, singleton implementation with CDI is very simple:

@Singleton
public class CarServiceSingleton {
    // ...
}
*
* Our class simulates a car service shop. We have a lot of instances of various Cars, but they all use the same shop for servicing. Therefore, Singleton is a good fit.
* We can verify it is the same instance with a simple JUnit test that asks the context for the class twice. Note that we've got a <getBean> helper method here for readability:

@Test
public void givenASingleton_whenGetBeanIsCalledTwice_thenTheSameInstanceIsReturned() {
    CarServiceSingleton one = getBean(CarServiceSingleton.class);       # getBean() is a helper method
    CarServiceSingleton two = getBean(CarServiceSingleton.class);
    assertTrue(one == two);
}
* Because of the @Singleton annotation, the container will return the same reference both times.
* If we try this with a plain managed bean, however, the container will provide a different instance each time.
*
* */

/*
* Explanation - @Transactional
* ----------------------------
* @Transactional annotation is used when you want the certain method/class(=all methods inside) to be executed in a transaction.
* Let's assume user A wants to transfer 100$ to user B. What happens is:
*   - We decrease A's account by 100$
*   - We add 100$ to B's account
* Let's assume the exception is thrown after succeeding 1) and before executing 2).
* Now we would have some kind of inconsistency because A lost 100$ while B got nothing.
* Transaction means all or nothing. If there is an exception thrown somewhere in the method, changes are not persisted in the database. Something called rollback happens.
* If you don't specify @Transactional, each DB call will be in a different transaction.
* */

/*
* * this interface<JpaRepository> further extends interfaces <CrudRepository> and <PageableRepository>
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
* */

@Singleton                  // Use jakarta.inject.Singleton to designate a class as a singleton. In Java, Singleton is a design pattern that ensures that a class can only have one object
@Transactional              // This method modifies the database, thus it is annotated with @Transactional.
public class OwnerServiceImpl implements OwnerService {

    private final Logger log = LoggerFactory.getLogger(OwnerServiceImpl.class);
    private final OwnerRepository ownerRepository;

    // constructor
    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }
    @Override
    public Owner save(Owner owner) {
        // have a logger that logs a message "Request to have Owner:{}"
        log.debug("Request to save Owner: {}", owner);

        // call the <repository>OwnerRepository's mergeAndSave() method to let it store in persistence database
        return ownerRepository.mergeAndSave(owner);
    }

    @Override
    @ReadOnly                       // All database access needs to be wrapped inside a transaction. As the method only reads data from the database, annotate it with @ReadOnly.
    @Transactional                  // This method modifies the database, thus it is annotated with @Transactional.
    public Page<Owner> findAll(Pageable pageable) {
        // a logger to log the msg "Request to get all Owners"
        log.debug("Request to get all the Owners");
        return ownerRepository.findAll(pageable);       // PageableRepository --> an extension of JPARepository
    }

    @Override
    @ReadOnly
    @Transactional
    public Optional<Owner> findOne(Long id) {
        log.debug("Request to get Owner: {}",id);
        return ownerRepository.findById(id);            // CRUDRepository --> an extension of JPARepository
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Owner: {}",id);
        ownerRepository.deleteById(id);                 // CRUDRepository --> an extension of JPARepository

    }
}
