package hw.homework1.advanced.task2;

import java.util.Objects;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Book other = (Book) object;
        return this.title.equals(other.title) && this.author.equals(other.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title,author);
    }

}
