package hw.homework1.advanced.task2;

public class Main {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();

        Book book1 = new Book("1984", "Orwell");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "Rowling");
        Book book3 = new Book("Anna Karenina", "Tolstoy");
        Book book4 = new Book("War and Peace", "Tolstoy");
        Book book5 = new Book("1984", "Orwell");


        bookCollection.addBookToCollection(book1);
        bookCollection.addBookToCollection(book2);
        bookCollection.addBookToCollection(book3);

        bookCollection.removeBookFromCollection(book2);

        bookCollection.checkIfBookInCollection(book3);
        bookCollection.checkIfBookInCollection(book4);
        bookCollection.checkIfBookInCollection(book5);
    }
}
