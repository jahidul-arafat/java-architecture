package org.jarotball.oop.challenge.readfilecontents;

import java.io.IOException;

public class Simulator {
    public static void main(String[] args) throws IOException {
        DigitsOnlyFileReader digitFileReader = new DigitsOnlyFileReader("/Users/jarotball/Study/java_architect/revisions_2023/LR_JAVA17/src/main/resources/message.txt");
        System.out.println(digitFileReader.readFile());

        TextOnlyFileReader textFileReader = new TextOnlyFileReader("/Users/jarotball/Study/java_architect/revisions_2023/LR_JAVA17/src/main/resources/message.txt");
        System.out.println(textFileReader.readFile());




    }
}
