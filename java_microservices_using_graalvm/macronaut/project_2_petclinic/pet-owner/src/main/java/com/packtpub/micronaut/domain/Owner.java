package com.packtpub.micronaut.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


// DocString_01: Strategy
/* (1) Tag the class<Owner> as an Entity which mapped to table<owners> under schema<petowner>
 * (2) Set an unique serialVersionUID for the class:: a Serialization and Deserialization Tag
 * (3) Under ORM (Hibernate) Framework, map the attributes of table<Owners> into Entity <Class Owner> for easy database access and operations
 * (4) Under ORM (Hibernate) Framework, map the relationships as required. JPA (Java Persistent API) will take care of it
 * (5) For each Column of class<Owner>, create an Object of returnType class<Owner> and have the methods <getter> and <setter> for them
 * (6) Define the methods for variable <pet> of Domain<Pet>
 *      - [ ] getPets()
        - [ ] setPets(Set<Pet> pets)
        - [ ] add a <pet> to <owner>
        - [ ] remove a <pet> from <owner>
 * (7) Override the following default method behavior
 *      - equals(Object) :: to check if the objects are equal
 *      - hashCode :: length
 *      - toString() :: to print the Object's properties
* */

// DocString_02:: Architecture [to be coded]
/*
 * Category_01: glimps of Table<Owners>
 * =========================================
 * ATTRIBUTES
 * -----------------------------------------
 * id                --> int     -->     PK             --> mapped_by[ owner_id --in_table_pets--as_FK ]::for_relationship_mapping
 * first_name        --> string
 * last_name         --> string
 * address           --> string
 * city              --> string
 * telephone         --> string
 *
 * RELATIONSHIPS
 * -----------------------------------------
 * relationship_01: OneToMany relationship(Table<Owner>::Table<Pets>) --> An owner could have multiple Pets
 *
 * Category_02: ORM (Object Relationship Mapping) Framework used
 * =================================================================
 * ORM Framework Used: Hibernate --(to_access)--> Database
 * Architecture: web_app <--> ORM_framework <--> Database
 * Why ORM Frameworks:
 * -------------------
 * - to provide connectivity to the database
 * - To make development more object-oriented
 * - For easy transaction management
 * - No need to implement database manually
 *
 * Category_03: ORM object-oriented design requirements
 * =================================================================
 * Attribute        in_database_table           as_defined_in_ORM                                                                       db_table_attr --> orm_object_column
 * ---------        -----------------           ------------------                                                                      -----------------------------------
 *
 * id               id(PK)                      @Id (Annotation to make it PK)                                                          id --> id
 *                                              @GeneratedValue(strategy=GenerationType.IDENTITY) :: to let it auto_increment
 *                                              private Long id
 *
 * first_name       first_name(string)          @Column(name="first_name")                                                              first_name  --> firstName
 *                                              private String firstName
 *
 * last_name        last_name(string)           @Column(name="last_name")                                                               last_name   --> lastName
 *                                              private String lastName
 *
 * address          address(string)             @Column(name="address")                                                                 address     --> address
 *                                              private String address
 *
 * city             city(string)                @Column(name="city")                                                                    city        --> city
 *                                              private String city
 *
 * telephone        telephone(string)           @Column(name="telephone")                                                               telephone   --> telephone
 *                                              private String telephone
 *
 * Category_04: getter, setter and returnType<class<Owner>>_for_object<specific_column<columnName>>
 * Column@ORM Framework                         methods
 * --------------------                         -------
 * id                                           Long getId()
 *                                              void setId(Long id)
 *
 * firstName                                    String getFirstName()
 *                                              void setFirstName(String firstName)
 *                                              Owner firstName(String firstName)
 *
 * lastName                                     String getLastName()
 *                                              void setLastName(String lastName)
 *                                              Owner lastName(String lastName)
 * */

// Step-00: Tag the class<Owner> as an Entity which mapped to table<owners> under schema<petowner>
@Entity
@Table(name = "owners", schema = "petowner")
public class Owner implements Serializable {
    // Step-01: Set an unique serialVersionUID for the class:: a Serialization and Deserialization Tag
    /*
    * Why serialVersionUID?
    * - its an unique identifier for each class,
    * - JVM uses it to compare versions of the class ensuring that the same class was used during serialization is loaded during Deserialization
    * - serialVersionUID of different classes are independent, means not necessary for different classes to have unique values. So, its better to set it manually if you dont.
    * What if I forget to generate the serialVersionUID manually?
    * - JVM does generate one if you don't specify
    * */
    private static final long serialVersionUID = 1L;



    // Step-02: Under ORM (Hibernate) Framework, map the attributes of table<Owners> into Entity <Class Owner> for easy database access and operations
    // 2.1 PK setup: attribute<id>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 2.2 Rest of the Attribute to ORM Framework Column mapping
    // attribute<first_name>
    @Column(name = "first_name")
    private String firstName;

    // attribute<last_name>
    @Column(name = "last_name")
    private String lastName;

    // attribute<address>
    @Column(name = "address")
    private String address;

    // attribute<city>
    @Column(name = "city")
    private String city;

    // attribute<telephone>
    @Column(name = "telephone")
    private String telephone;

    // Step-03: - Under ORM (Hibernate) Framework, map the relationships as required.                                       // Pending Task
    // JPA (Java Persistent API) will take care of it.
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)                                                               // (X)create a variable<owner> of type<Owner> in Domain<Pet>
    private Set<Pet> pets = new HashSet<>(); // Set<Type>                                                                   // (X)Create a Domain<Pet>; still its not exist. That's why highlighting <ERROR>

    // Step-04: For each Column of class<Owner>, create an Object of returnType class<Owner> and have the methods <getter> and <setter> for them
    // Optional: Constructor
//    public Owner(String firstName, String lastName,
//                 String address, String city, String telephone){
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.city = city;
//        this.telephone = telephone;
//    }


    // column: id
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    // column <firstName>
    public Owner firstName(String firstName){
        this.firstName = firstName;
        return this;    // return an Instance of class<Owner>
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    // column <lastName>
    public Owner lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }


    // column <address>
    public Owner address(String address){
        this.address = address;
        return this;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    // column <city>
    public Owner city(String city){
        this.city = city;
        return this;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    // column <telephone>
    public Owner telephone(String telephone){
        this.telephone = telephone;
        return this;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    // Step-05: - Define the methods for variable<pet> of Domain<Pet>?
    // Why? because <owner>|One--to--Many|<Pet> relationship; which is handled by JPA
    /*  - [ ] getPets()
        - [ ] setPets(Set<Pet> pets)
        - [ ] add a <pet> to <owner>
        - [ ] remove a <pet> from <owner>

     */

    public Set<Pet> getPets(){
        return pets;
    }

    public void setPets(Set<Pet> pets){
        this.pets = pets;
    }

    public Owner addPet(Pet pet){
        this.pets.add(pet);     // set function <add> applied
        pet.setOwner(this);                                                                                              // (X) pendingTask: create a setOwner(Owner owner) method in domain<Pet>
        return this;
    }

    public Owner removePet(Pet pet){
        this.pets.remove(pet);  // set function <remove> applied
        pet.setOwner(null);
        return this;
    }

    // Step-6: - [ ] Override the following default method behavior
    //    - [ ]  equals(Object) :: to check if the objects are equal
    //    - [ ]  hashCode :: length
    //    - [ ]  toString() :: to print the Object's properties

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Owner))
        {
            return false;
        }

        return id !=null && id.equals(((Owner) o).id); // nullable object
    }

    @Override
    public int hashCode(){
        return 31;
    }

    @Override
    public String toString(){
        String msg= "Owner {\n"+
                "id=" + getId() +"\n"+
                "firstName="+ getFirstName() + "\n"+
                "lastName="+ getLastName()+ "\n"+
                "address="+ getAddress()+ "\n"+
                "city="+ getCity()+ "\n"+
                "telephone="+ getTelephone()+ "\n"+
                "}";
        return msg;

    }



}
