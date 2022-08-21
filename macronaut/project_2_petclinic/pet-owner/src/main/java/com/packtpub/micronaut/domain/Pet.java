package com.packtpub.micronaut.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class Pet implements Serializable {

    // Pending_Task_01: - [ ] Under Domain<Pet>, in the relationship mapping section, create a variable<owner>
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
