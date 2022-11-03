package org.datascience.loadingdata.utils;

public enum FilePath {
    FILE_PATH("/Users/jarotball/Study/java_architect/JavaDataScience/src/main/java/org/datascience/loadingdata/sampledata/");
    private final String path;
    FilePath(String path) {
        this.path=path;
    }

    @Override
    public String toString() {
        return this.path;
    }
}
