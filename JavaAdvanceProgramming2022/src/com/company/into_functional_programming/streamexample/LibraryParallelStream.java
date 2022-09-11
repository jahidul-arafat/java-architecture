package com.company.into_functional_programming.streamexample;

/**
 * Library
 *
 * @method1 populateLibrary(): Create an arraylist of books
 * for small dataset, normal stream() would be preferred
 * only use parallelStream() when there is a very large dataset
 * */
import java.util.ArrayList;


public class LibraryParallelStream {
    public static void main(String[] args) {
        ArrayList<Book> bookList = populateLibrary();

        // Strategy01: forEach - using External Iteration
        for (Book book: bookList
             ) {
            if (book.getAuthor().startsWith("Author1")) {
                System.out.println(book);
            }
        }
        System.out.println();

        // Strategy02: stream - using Internal iteration
        // List all books with "Author1"
        // using parallelStream() instead stream() to enable multiple cores to filter the elements
        bookList.parallelStream().filter(
                book -> {
                    return book.getAuthor().startsWith("Author1");
                }
        ).forEach(System.out::println);


        System.out.println();
        // List all books with "Author1" and title "Book5"
        // using parallelStream() instead stream()
        bookList.parallelStream().filter(
                book -> {
                    return book.getAuthor().startsWith("Author1");
                }
        ).filter(
                book -> {
                    return book.getTitle().endsWith("5");
                }
        ).forEach(System.out::println);

    }

    // method
    public static ArrayList<Book> populateLibrary(){
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Author1","Book1"));
        bookList.add(new Book("Author2","Book2"));
        bookList.add(new Book("Author3","Book3"));
        bookList.add(new Book("Author4","Book4"));
        bookList.add(new Book("Author1","Book5"));
        bookList.add(new Book("Author2","Book6"));
        bookList.add(new Book("Author3","Book7"));
        bookList.add(new Book("Author4","Book8"));

        return bookList;
    }
}
