package Lab54;

import com.company.lab34.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class BookList {
    ArrayList<Book> books;

    public BookList() {
        books = new ArrayList<Book>();
    }

    public BookList(int count) {
        books = new ArrayList<Book>(count);
    }

    public BookList(Book[] books) {
        this.books = new ArrayList<Book>(books.length);
        this.books.addAll(Arrays.asList(books));
    }

    public Book getById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return new Book();
    }

    public Book getByIndex(int idx) throws BookListException {
        try {
            return books.get(idx);
        } catch (IndexOutOfBoundsException e) {
            throw new BookListException("Index is out of bounds of book list");
        }
    }

    public void remove(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return;
            }
        }
    }

    public void append(Book book) throws BookListException {
        if (book == null) {
            throw new BookListException("Book object is null. Cannot add it to the list");
        }
        books.add(book);
    }

    public int size() {
        return books.size();
    }

    public BookList getByAuthors(String authors) {
        BookList booksByAuthor = new BookList();
        for (Book b : books) {
            if (b.getAuthors().contains(authors)) {
                booksByAuthor.books.add(b);
            }
        }
        return booksByAuthor;
    }

    public BookList getByPublication(String publication) {
        BookList booksByPublication = new BookList();
        for (Book b : books) {
            if (b.getPublication().equals(publication)) {
                booksByPublication.books.add(b);
            }
        }
        return booksByPublication;
    }

    public BookList getWithYearGreaterThan(int year) {
        BookList booksByYear = new BookList();
        for (Book b : books) {
            if (b.getYear() > year) {
                booksByYear.books.add(b);
            }
        }
        return booksByYear;
    }

    @Override
    public String toString() {
        StringBuilder booksString = new StringBuilder("--------------------------------------\n");
        for (Book b : books) {
            booksString.append(b.toString()).append("--------------------------------------\n");
        }
        return booksString.toString();
    }
}
