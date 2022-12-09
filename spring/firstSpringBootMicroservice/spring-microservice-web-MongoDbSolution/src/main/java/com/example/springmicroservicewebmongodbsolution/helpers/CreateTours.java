package com.example.springmicroservicewebmongodbsolution.helpers;

import com.example.springmicroservicewebmongodbsolution.domain.TourTemp;
import com.example.springmicroservicewebmongodbsolution.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateTours {
    @Autowired // must be Autowired due to the CLR dependency
    private TourService tourService;

    public void createTours(String fileToImport) throws IOException {
        TourTemp.loadToursFromJson(fileToImport).forEach(importedTour ->
                tourService.createTour(
                        importedTour.getTitle(),
                        importedTour.getPackageName(),
                        importedTour.getDetails()));
    }

}
