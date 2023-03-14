package org.jarotball.oop.challenge.readfilecontents;

public class DigitsOnlyFileReader extends AbstractFileReader{

    public DigitsOnlyFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public String parseLine(String line) {
        // regex - [^0-9] means, match all the alphabets expect the numerics one and replace those with ""(nothing)
        return line.replaceAll("[^0-9]","");
    }
}
