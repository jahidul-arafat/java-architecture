package com.example.springmicroservicewebmongodbsolution.helpers;

import com.example.springmicroservicewebmongodbsolution.domain.TourTemp;
import com.example.springmicroservicewebmongodbsolution.services.TourService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateTours {

    private final TourService tourService;

    public CreateTours(TourService tourService) {
        this.tourService = tourService;
    }

    public void createTours(String fileToImport) throws IOException {
        TourTemp.loadToursFromJson(fileToImport).forEach(importedTour ->
                tourService.createTour(
                        importedTour.getTitle(),
                        importedTour.getPackageName(),
                        importedTour.getDetails()));
    }

}
