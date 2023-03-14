package org.jarotball.oop.challenge.readfilecontents;

public class TextOnlyFileReader extends AbstractFileReader{

    public TextOnlyFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public String parseLine(String line) {
        // regex - [0-9] means, match all the numerics expect the alphabets and replace those with ""(nothing)
        return line.replaceAll("[0-9]","");
    }
}
