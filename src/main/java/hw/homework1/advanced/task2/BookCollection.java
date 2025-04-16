package hw.homework1.advanced.task2;

import java.util.HashSet;

public class BookCollection {
    private HashSet<Book> bookCollection;

    public BookCollection() {
        this.bookCollection = new HashSet<>();
    }

    public void addBookToCollection(Book book) {
        bookCollection.add(book);
    }

    public void removeBookFromCollection(Book book) {
        bookCollection.remove(book);
    }

    public void checkIfBookInCollection(Book book) {
        if(bookCollection.contains(book)) {
            System.out.println("This book is presented in the collection.");;
        } else System.out.println("There is no such book in the collection.");
    }

}
