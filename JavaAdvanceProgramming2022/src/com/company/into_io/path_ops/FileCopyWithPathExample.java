package com.company.into_io.path_ops;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING; //

public class FileCopyWithPathExample {
    public static void main(String[] args) {
        // Copy the contents of the file
        Path source = Path.of("source_file.txt");
        Path destination = Path.of("copy_source_file.txt");
        try {
            Files.copy(source,destination, REPLACE_EXISTING,
                    COPY_ATTRIBUTES,
                    NOFOLLOW_LINKS); // copy the contents of source_file into destination_file
                                    // argument<REPLACE_EXISTING> will replace the destination file if it already exists. Without it, it will throw an FileAlreadyExists exception
                                    // argument<COPY_ATTRIBUTES> will copy the metadata of the source_file to destination_file
                                    // argument<NOFOLLOW_LINKS> check of the file is a symbolic link; if so, then copy the original file instead.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
