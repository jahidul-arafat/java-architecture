package org.codeclinic.utility;

public enum FilePath {
    FILE_PATH("/Users/jarotball/Study/java_architect/JavaCodeClinic/src/main/resources/");
    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.path;
    }
}
