package com.example.springmicroserviceweb.restcontrollers;

import com.example.springmicroserviceweb.domain.TourPackage;
import com.example.springmicroserviceweb.services.TourPackageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TourPackageRestController {
    private final TourPackageService tourPackageService;

    // Rest-endpoint-1: Get all the available tour Packages
    @GetMapping("/tourPackages")
    public Iterable<TourPackage> getAllTourPackages(){
        Iterable<TourPackage> tourPackageIterable = tourPackageService.lookup();
        return tourPackageIterable;
    }

    // RestEndpoint02: Get the tourPackage Details by the tourPackage <code>
    @GetMapping("/tourPackage/{code}")
    public Optional<TourPackage> getTourPkgDetailsByCode(@PathVariable(value = "code") String code){
        return tourPackageService.getTourPkgDetailsByCode(code);

    }
}
