package com.example.springmicroserviceweb.helpers;

import com.example.springmicroserviceweb.services.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CreateTourPackages {

    @Autowired // keep the Autowired here as I am gonna call a CommandLineRunner which need to autowire the required services during CRL run
    private TourPackageService tourPackageService;
    // // Create a list of Tour Packages
    // first check whether the tourPackage is already exists in the JpaRepository
    // if so, then return
    // else, create a new tourPackage and add that in tourPackageRepository i.e. adding the entry into the database

    public void createTourAllPackages(){
        tourPackageService.createTourPackage("BC", "Backpack Cal");
        tourPackageService.createTourPackage("CC", "California Calm");
        tourPackageService.createTourPackage("CH", "California Hot springs");
        tourPackageService.createTourPackage("CY", "Cycle California");
        tourPackageService.createTourPackage("DS", "From Desert to Sea");
        tourPackageService.createTourPackage("KC", "Kids California");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SC", "Snowboard Cali");
        tourPackageService.createTourPackage("TC", "Taste of California");


    }
}
