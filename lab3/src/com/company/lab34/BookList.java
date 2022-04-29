package com.company.lab34;

import java.util.ArrayList;

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
        for (Book b : books) {
            this.books.add(b);
        }
    }

    public Book getById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return new Book();
    }

    public Book getByIndex(int idx) {
        return books.get(idx);
    }

    public void remove(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return;
            }
        }
    }

    public void append(Book book) {
        books.add(book);
    }

    public int size() {
        return books.size();
    }

    public BookList getByAuthors(String authors) {
        BookList booksByAuthor = new BookList();
        for (Book b : books) {
            if (b.getAuthors().contains(authors)) {
                booksByAuthor.append(b);
            }
        }
        return booksByAuthor;
    }

    public BookList getByPublication(String publication) {
        BookList booksByPublication = new BookList();
        for (Book b : books) {
            if (b.getPublication().equals(publication)) {
                booksByPublication.append(b);
            }
        }
        return booksByPublication;
    }

    public BookList getWithYearGreaterThan(int year) {
        BookList booksByYear = new BookList();
        for (Book b : books) {
            if (b.getYear() > year) {
                booksByYear.append(b);
            }
        }
        return booksByYear;
    }

    @Override
    public String toString() {
        StringBuilder booksString = new StringBuilder("--------------------------------------\n");
        for (Book b : books) {
            booksString.append(b.toString() + "--------------------------------------\n");
        }
        return booksString.toString();
    }
}
