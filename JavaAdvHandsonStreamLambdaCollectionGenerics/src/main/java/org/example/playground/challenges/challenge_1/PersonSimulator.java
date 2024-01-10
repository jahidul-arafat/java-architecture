package org.example.playground.challenges.challenge_1;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonSimulator {
    public static void main(String[] args) {
        // Problem-1: Return a list containing only the Person's name from the given list of Person objects.
        // create an array of 5 persons
        Person[] personsArray = new Person[6];
        personsArray[0] = new Person("John", 25);
        personsArray[1] = new Person("Mary", 24);
        personsArray[2] = new Person("Peter", 23);
        personsArray[3] = new Person("Lisa", 22);
        personsArray[4] = new Person("Sarah", 19);
        personsArray[5] = new Person("Jahidul Arafat", 38);

        List<Person> personList = Arrays.asList(personsArray);
        System.out.println(personList);

        // get the list of person's names
        Function<Person, String> personNameGrapperFunction = person -> person.getName();
        List<String> personNameList = personList.stream()
                //.map(personNameGrapperFunction)
                .map(Person::getName)// using method reference, instead of Function; however could be done in both ways
                .toList();
        System.out.printf("List of all Person Names: %s%n",personNameList);

        // get the average age of all persons
        Function<Person, Integer> personAgeGrapperFunction = person -> person.getAge();
        Double averageAge = personList.stream()
             .mapToDouble(Person::getAge)
                     .average()
                             .orElse(0.0);

        System.out.printf("Average age of all persons: %s%n",averageAge);

        // get the person with highest age
        Person personWithHighestAge = personList.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElse(null);
        System.out.println("Person with highest age: " + personWithHighestAge);

        // get the person with lowest age
        Person personWithLowestAge = personList.stream()
              .min(Comparator.comparing(Person::getAge))
              .orElse(null);
        System.out.println("Person with lowest age: " + personWithLowestAge);

        // get the person with maximum name length
        Person personWithMaximumNameLength = personList.stream()
              .max(Comparator.comparingInt(person -> person.getName().length()))
                      .orElse(null);
        System.out.println("Person with maximum name length: " + personWithMaximumNameLength);

        // get the person with minimum name length
        Person personWithMinimumNameLength = personList.stream()
            .min(Comparator.comparingInt(person -> person.getName().length()))
                    .orElse(null);
        System.out.println("Person with minimum name length: " + personWithMinimumNameLength);

        // group persons by their name length
        // .groupingBy(Classifier, Downstream)
        Function<Person, Integer> personNameLengthGrapperFunction = person -> person.getName().length();
        Map<Integer, List<Person>> personNameLengthGroupedMap = personList.stream()
                //.collect(Collectors.groupingBy(personNameLengthGrapperFunction))
              .collect(Collectors.groupingBy(personNameLengthGrapperFunction, Collectors.toList()));
        System.out.println(personNameLengthGroupedMap);

        // group persons by their age higher than the average age
        Function<Person, String> personAgeHigherThanAverageGrapperFunction = person -> person.getAge() >= averageAge? "Higher" : "Lower";
        Map<String, List<Person>> personAgeHigherThanAverageGroupedMap = personList.stream()
            .collect(Collectors.groupingBy(personAgeHigherThanAverageGrapperFunction, Collectors.toList()));
        System.out.println(personAgeHigherThanAverageGroupedMap);

        // count the number of persons whose age is higher than the average age
        Map<String, Long> personAgeHigherThanAverageGroupedMap2 = personList.stream()
          .collect(Collectors.groupingBy(personAgeHigherThanAverageGrapperFunction, Collectors.counting()));
        System.out.println(personAgeHigherThanAverageGroupedMap2);

        // define a Predicate to check if a character is vowel or not
        Predicate<Character> isVowel = c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';

        // Define a function to count the number of vowels in a person's name
        Function<Person, String> classifyByVowelCount = person -> {
            long vowelCount = person.getName().toLowerCase().chars()
                    .filter(ch -> "aeiou".indexOf(ch) != -1) // means a vowel in the name is found
                    .count();
            return vowelCount>=3?"More Vowels": "Less Vowels";
        };

        var groupedByVowelCount = personList.stream()
                .collect(Collectors.groupingBy(
                            classifyByVowelCount, // classifier function
                            Collectors.mapping(Person::getName,Collectors.toList()) // Downstream
                ));
        System.out.println("Grouped by vowel count: " + groupedByVowelCount);












    }
}
