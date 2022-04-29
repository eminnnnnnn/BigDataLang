package com.company.lab34;

import java.util.Arrays;

public class Book {

    private int id;
    private String name;
    private String authors;
    private String publication;
    private int year;
    private int pageNumbers;
    private int price;
    private String coverType;

    public Book() {
        id = -1;
        name = new String("");
        authors = new String("");
        publication = new String("");
        coverType = new String("");
        year = -1;
        pageNumbers = -1;
        price = -1;
    }

    public Book(int id, String name, String authors, String publication, String coverType, int year,
                int pageNumbers, int price) {
        this.id = id;
        this.name = new String(name);
        this.authors = new String(authors);
        this.publication = new String(publication);
        this.coverType = new String(coverType);
        this.year = year;
        this.pageNumbers = pageNumbers;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder books = new StringBuilder(String.format(
                "ID: %d\nНазвание: %s\nАвторы: %s\nИздательство: %s\nТип переплета: %s\nГод издания: %d\n" +
                "Количество страниц: %d\nЦена: %d\n",
                id, name, authors, publication, coverType, year, pageNumbers, price
        ));
        return books.toString();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAuthors() { return authors; }
    public String getPublication() { return publication; }
    public String getCoverType() { return coverType; }
    public int getPageNumbers() { return pageNumbers; }
    public int getPrice() { return price; }
    public int getYear() { return year; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = new String(name); }
    public void setPublication(String publication) { this.publication = new String(publication); }
    public void setAuthors(String authors) { this.authors = new String(authors); }
    public void setCoverType(String coverType) { this.coverType = new String(coverType); }
    public void setYear(int year) { this.year = year; }
    public void setPageNumbers(int pageNumbers) { this.pageNumbers = pageNumbers; }
    public void setPrice(int price) { this.price = price; }
}
