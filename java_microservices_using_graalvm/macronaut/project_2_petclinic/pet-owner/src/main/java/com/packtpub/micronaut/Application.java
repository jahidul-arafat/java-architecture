package com.packtpub.micronaut;

import com.packtpub.micronaut.utils.PetOwnerCliClient;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

@Singleton                  // Use jakarta.inject.Singleton to designate a class as a singleton. In Java, Singleton is a design pattern that ensures that a class can only have one object
public class Application {
    private final PetOwnerCliClient petOwnerCliClient;

    public Application(PetOwnerCliClient petOwnerCliClient) {
        this.petOwnerCliClient = petOwnerCliClient;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    // when we run our application, the aforementioned @EventListener will invoke PetOwnerCliClient to perform database operations.
    @EventListener
    void init(StartupEvent event){
        petOwnerCliClient.performDatabaseOperations();
    }
}
