package com.packtpub.micronaut.utils;

import com.packtpub.micronaut.domain.Owner;
import com.packtpub.micronaut.domain.Pet;
import com.packtpub.micronaut.domain.Visit;
import com.packtpub.micronaut.service.OwnerService;
import com.packtpub.micronaut.service.PetService;
import com.packtpub.micronaut.service.PetTypeService;
import com.packtpub.micronaut.service.VisitService;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @purpose to exhibit basic CRUD opetations on the entities: Owner, Pet, PetType and Visit
 * @strategy CliCline will directly talk to the respective services
 * @cliToServiceCallCount 4x
 * @cliToServiceCall_01    PetOwnerCliClient --> OwnerService (OwnerServiceImpl) --> OwnerRepository(Implements JPARespository)
 * @cliToServiceCall_02    PetOwnerCliClient --> PetService   (PetServiceImpl)   --> PetRepository  (Implements JPARespository)
 * @cliToServiceCall_03    PetOwnerCliClient --> PetTypeService (PetTypeServiceImpl) --> PetTypeRepository(Implements JPARespository)
 * @cliToServiceCall_04    PetOwnerCliClient --> VisitService (VisitServiceImpl) --> VisitRepository(Implements JPARespository)
 * @whenYouCanAccessProtectedMethods
 * @protectedMethodStrategy_01  You can access protected Method from the same class
 * @protectedMethodStrategy_02  You can access protected method from another class within same package
 * @protectedMethodStrategy_03  You can access protected Method from a subclass extending the parent class
 *
 * @whenYouCantAccessProtectedMethods
 * @protectedMethodStrategy_04  You can't access protected Method of a class in a class (non-subclass) that is present in different package; will result in compile time error.
 *
 * */
public class PetOwnerCliClient {
    private final Logger log = LoggerFactory.getLogger(PetOwnerCliClient.class);

    // Step-01 Lets inject all services <OwnerService, PetService, PetTypeService and VisitService> into Cli's Constructor
    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;

    public PetOwnerCliClient(OwnerService ownerService, PetService petService, PetTypeService petTypeService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
    }

    // Step-02: List all the features this Cli_Utility will be providing.
    // For the simplicity, we just limited our scope to entity<Owner>
    public void performDatabaseOperations(){
        performFindAll();
        Owner owner = performSave();
        performFindOne(owner.getId());
        performDelete(owner);
    }

    // Step-2.1: Performing read/fetch (All) operation
    /**
     * @strategy call the OwnerService to fetch all owners
     * @why since "owner" has multiple pets and each pet can have multiple visits, fetching an owner will fetch pretty much everything in the schema:"petowner"
     * */
    protected void performFindAll(){

        // Decoration
        log.info("---------------------------------------------");
        log.info("Request to performFindAll");
        log.info("---------------------------------------------");


        // get all the pages related to owner and unpaged those
        // Lets remove the pagiantion setup for now using unpaged()
        // Pageable.unpaged() --> Returns a Pageable instance representing no pagination setup.
        Page<Owner> pOwners = ownerService.findAll(Pageable.unpaged());

        // let's iterate over the pages(unpaginated)
        if (CollectionUtils.isNotEmpty(pOwners.getContent())){
            // get the list of all owners of T <Owner>
            List<Owner> owners = pOwners.getContent();

            // iterate over the list and log the Owners<firstName><lastName>
            owners.forEach(owner -> {
                log.info("Owner: {},{}", owner.getFirstName(),owner.getLastName());
            });
        }
    }

    // Step-2.2: Find a Specific Owner
    protected void performFindOne(Long id){
        // Decoration
        log.info("---------------------------------------------");
        log.info("Request to performFindOne for id: {}",id);
        log.info("---------------------------------------------");

        // You may or may not find that Owner with the <id> specified;
        // That's why instead of List<T, use Optional<T>  T:Generic Type
        Optional<Owner> oOwner = ownerService.findOne(id);

        // Let log the owner's firstName and lastName
        // Dependency: Check if the owner really exists
        oOwner.ifPresent(owner -> {
            log.info("Owner: {},{}", owner.getFirstName(), owner.getLastName());
        });

    }

    // Step-2.3: Performing a Save Operation
    // let's set some dummy data for Owner

    private Owner initOwner(){
        Owner owner = new Owner();
        owner.setFirstName("Jahidul");
        owner.setLastName("Arafat");
        owner.setCity("Dhaka");
        owner.setAddress("Mirpur DOHS");
        owner.setTelephone("01759XX5859");

        Pet pet = new Pet();
        pet.setType(petTypeService.findAll(Pageable.unpaged()).getContent().get(1));
        pet.setName("Guchu");
        pet.setBirthDate(LocalDate.of(2022,3,9));
        pet.setOwner(owner);

        Visit visit = new Visit();
        visit.setVisitDate(LocalDate.now());
        visit.setDescription("Breathing Issues");
        visit.setPet(pet);

        return owner;
    }
    // Why: To save an owner with a pet and a visit
    protected Owner performSave(){
        Owner owner = initOwner();
        log.info("-----------------------------------------------------");
        log.info("Request to performSave for owner: {}", owner);
        log.info("-----------------------------------------------------");
        return ownerService.save(owner);
    }
    // Step-2.4: Performing a Delete Operation
    protected void performDelete(Owner owner){
        // 2.4.1- Before deleting Owner, Delete all his/her pets and its visits
        // Before preceding next, make sure the Set<Pet> is not empty
        Set<Pet> pets = owner.getPets();
        if (CollectionUtils.isNotEmpty(pets)){
            for (Pet pet: pets){
                Set<Visit> visits = pet.getVisits();
                if (CollectionUtils.isNotEmpty(visits)){
                    for (Visit visit: visits){
                        visitService.delete(visit.getId());  // Delete Pet's visit
                    }
                }
                petService.delete(pet.getId());             // Delete Pet
            }
        }

        ownerService.delete(owner.getId());                 // Delete Owner
    }
}

// next go to the Application.java to Wrap up and call the Cli_Util
