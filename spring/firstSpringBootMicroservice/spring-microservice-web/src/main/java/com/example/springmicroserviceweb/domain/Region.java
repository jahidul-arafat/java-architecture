package com.example.springmicroserviceweb.domain;

import lombok.AllArgsConstructor;

// enum doesnt need to be auto-loaded by SpringBoot Application Context
// thats why @Component annotation is not required
@AllArgsConstructor
public enum Region {
    CENTRAL_COAST("Central California"),
    SOUTHERN_CALIFORNIA("Southern California"),
    NORTHERN_CALIFORNIA("Northern California"),
    VARIES("Varies");

    private String label;
}
