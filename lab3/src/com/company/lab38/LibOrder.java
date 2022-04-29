package com.company.lab38;

public class LibOrder {
    private int orderNum;
    private String bookName;
    private LibBook book;
    private LibWorker issuedByWorker;

    private static int orderCounter = 0;


    public LibOrder(String bookName) {
        this.bookName = new String(bookName);
        this.orderNum = -1;
        this.book = null;
        this.issuedByWorker = null;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void registerBook(LibBook book, LibWorker worker) {
        this.book = book;
        this.orderNum = orderCounter;
        LibOrder.orderCounter++;
        this.issuedByWorker = worker;
    }

    public LibBook getBook() {
        return book;
    }
}
