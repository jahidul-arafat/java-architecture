package com.example.springmicroserviceweb;

import com.example.springmicroserviceweb.domain.*;
import com.example.springmicroserviceweb.helpers.CreateTourPackages;
import com.example.springmicroserviceweb.helpers.CreateTours;
import com.example.springmicroserviceweb.services.TourPackageService;
import com.example.springmicroserviceweb.services.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringMicroserviceWebApplication {
    private static final Logger LOG = LoggerFactory.getLogger(SpringMicroserviceWebApplication.class);
    @Value("${springmicroserviceweb.importfile}") // this is imported from resources/application.properties
    private String importFile;

    @Autowired // must //bcoz of CLR
    private TourPackageService tourPackageService;
    @Autowired // must //bcoz of CLR
    private TourService tourService;
    @Autowired // must //bcoz of CLR
    private CreateTourPackages createTourPackages;
    @Autowired // must //bcoz of CLR
    private CreateTours createTours;


    @Bean
    public CommandLineRunner commandLineRunner(){
        // below is a lambda expression
        // variable defined in Lambda expression must be defined Atomic
        return args -> {

            LOG.info("Starting CLR application");
            createTourPackages.createTourAllPackages();
            long numOfPackages = tourPackageService.total();
            LOG.info("Total Tour packages: "+numOfPackages);
            AtomicInteger counter = new AtomicInteger();
            Iterable<TourPackage> tourPkgList = tourPackageService.lookup();
            tourPkgList.forEach(tourPackage -> {
                LOG.info(counter+">>"+tourPackage.toString());
                counter.addAndGet(1);
            });

            AtomicReference<Integer> c2= new AtomicReference<>(1);
            createTours.createTours(importFile);
            long numOfTours = tourService.total();
            LOG.info("Total Number of Tours: "+numOfTours);
            Iterable<Tour> tourList = tourService.lookup();
            tourList.forEach(tour -> {
                LOG.info(c2+">>"+tour.toString());
                c2.updateAndGet(v -> v + 1);
            });


            LOG.info("Ending CLR application");
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringMicroserviceWebApplication.class, args);
    }
}
