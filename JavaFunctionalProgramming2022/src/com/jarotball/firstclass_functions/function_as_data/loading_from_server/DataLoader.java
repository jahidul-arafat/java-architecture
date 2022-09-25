package com.jarotball.firstclass_functions.function_as_data.loading_from_server;

import com.jarotball.firstclass_functions.custom_functional_programming_interfaces.NoArgFunction;

/**
 * DataLoader has 2x private methods/functions which cant be access from MAIN directly either by instance or class itself.
 * private Person loadPersonReal()
 * private Person loadPersonFake()
 *
 * */
public class DataLoader {
    // Function Type variable whose data is also a function
    public NoArgFunction<Person> loadData;

    public DataLoader(boolean isDevelopment){
        loadData = isDevelopment?
                this::loadPersonFake:
                this::loadPersonReal;
    }

    private Person loadPersonReal(){
        System.out.println("Loading Real Data ...");
        return new Person("Real Person", 30);
    }

    private Person loadPersonFake(){
        System.out.println("Returning Fake Person Object ...");
        return new Person("Fake Person", 100);
    }

}
