package com.company.into_functional_programming.streamexample;

/**
 * Library
 *
 * @method1 populateLibrary(): Create an arraylist of books
 * */
import java.util.ArrayList;


public class LibraryStream {
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
        bookList.stream().filter(
                book -> {
                    return book.getAuthor().startsWith("Author1");
                }
        ).forEach(System.out::println);


        System.out.println();
        // List all books with "Author1" and title "Book5"
        bookList.stream().filter(
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
