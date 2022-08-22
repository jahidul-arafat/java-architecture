package com.packtpub.micronaut.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visits", schema = "petowner")
public class Visit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    // constructor - optional
//    public Visit(LocalDate visitDate, String description, Pet pet){
//        this.visitDate = visitDate;
//        this.description = description;
//        this.pet = pet;
//    }

    // getter+setter methods
    // id
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    // visit_date
    public LocalDate getVisitDate(){
        return visitDate;
    }
    public void setVisitDate(LocalDate visitDate){
        this.visitDate = visitDate;
    }
    public Visit visitDate(LocalDate visitDate){
        this.visitDate = visitDate;
        return this;
    }

    // description
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Visit description(String description){
        this.description = description;
        return this;
    }

    // pet
    public Pet getPet(){
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public Visit pet(Pet pet){
        this.pet = pet;
        return this;
    }


    // Override
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Visit))
        {
            return false;
        }

        return id !=null && id.equals(((Visit) o).id); // nullable object
    }

    @Override
    public int hashCode(){
        return 31;
    }

    @Override
    public String toString(){
        String msg= "Visit {\n"+
                "id=" + getId() +"\n"+
                "visitDate="+ getVisitDate() + "\n"+
                "description="+ getDescription()+"\n"+
                "}";
        return msg;

    }
}
