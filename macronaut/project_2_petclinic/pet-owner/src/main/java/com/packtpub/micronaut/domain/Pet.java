package com.packtpub.micronaut.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets", schema = "petowner")
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    // Pending_Task_01: - [ ]
    // relationship_01: One owner can have multiple pets or multiple pets can be owned by a single owner
    @ManyToOne
    @JoinColumn(name = "owner_id")                                      //FK<owner_id>
    private Owner owner;                                                //pd_fromEx_01: Under Domain<Pet>, in the relationship mapping section, create a variable<owner>

    // relationship_02: Multiple pets can be of a single type (i.e. cats, dog)
    @ManyToOne
    @JoinColumn(name = "type_id")                                       //FK<type_id>
    private PetType type;

    // relationship_03: A pet can visit a vet multiple times
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();                        // (X)pd_toEx_01: create a new Domain<visits>



    // constructor - optional
//    public Pet(String name, LocalDate birthDate, Owner owner, PetType petType){
//        this.name = name;
//        this.birthDate = birthDate;
//        this.owner = owner;
//        this.type = petType;
//    }

    // define the setter, getter methods
    // id
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    // name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Pet name(String name){
        this.name = name;
        return this;
    }

    // birthDate
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }
    public Pet birthDate(LocalDate birthDate){
        this.birthDate = birthDate;
        return this;
    }


    // owner :: ManyToOne relationship
    public Owner getOwner(){
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Pet owner(Owner owner){
        this.owner = owner;
        return this;

    }


    // PetType :: ManyToOne relationship
    public PetType getType(){
        return type;
    }
    public void setType(PetType type){
        this.type = type;
    }
    public Pet type(PetType petType){
        this.type = petType;
        return this;
    }


    // visit :: oneToMany relation
    public Set<Visit> getVisits(){
        return this.visits;
    }
    public void setVisits(Set<Visit> visits){
        this.visits = visits;
    }
    public Pet visits(Set<Visit> visits){
        this.visits = visits;
        return this;
    }
    public Pet addVisit(Visit visit){
        this.visits.add(visit);
        visit.setPet(this);
        return this;
    }
    public Pet removeVisit(Visit visit){
        this.visits.remove(visit);
        visit.setPet(null);
        return this;
    }


    // Override
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Pet))
        {
            return false;
        }

        return id !=null && id.equals(((Pet) o).id); // nullable object
    }

    @Override
    public int hashCode(){
        return 31;
    }

    @Override
    public String toString(){
        String msg= "Pet {\n"+
                "id=" + getId() +"\n"+
                "name="+ getName() + "\n"+
                "birthDate="+ getBirthDate()+ "\n"+
                "}";
        return msg;

    }





}
