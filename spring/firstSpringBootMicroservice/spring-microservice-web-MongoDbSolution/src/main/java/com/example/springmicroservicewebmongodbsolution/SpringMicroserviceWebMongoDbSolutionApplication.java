package com.example.springmicroservicewebmongodbsolution;

import com.example.springmicroservicewebmongodbsolution.domain.Tour;
import com.example.springmicroservicewebmongodbsolution.domain.TourPackage;
import com.example.springmicroservicewebmongodbsolution.helpers.CreateTourPackages;
import com.example.springmicroservicewebmongodbsolution.helpers.CreateTours;
import com.example.springmicroservicewebmongodbsolution.services.TourPackageService;
import com.example.springmicroservicewebmongodbsolution.services.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class SpringMicroserviceWebMongoDbSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceWebMongoDbSolutionApplication.class, args);
	}

}
