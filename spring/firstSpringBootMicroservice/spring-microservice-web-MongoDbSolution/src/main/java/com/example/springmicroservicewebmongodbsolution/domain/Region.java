package com.example.springmicroservicewebmongodbsolution.domain;

import lombok.AllArgsConstructor;

// enum doesnt need to be auto-loaded by SpringBoot Application Context
// thats why @Component annotation is not required
@AllArgsConstructor
public enum Region {
    Central_Coast("Central Coast"),
    Southern_California("Southern California"),
    Northern_California("Northern California"),
    Varies("Varies");


    private String label;

    public static Region findByLabel(String byLabel) {
        for(Region r: Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }

}
