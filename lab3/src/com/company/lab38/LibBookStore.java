package com.company.lab38;

import java.util.ArrayList;

public class LibBookStore {
    ArrayList<LibBook> libBooks;

    public LibBookStore() {
        libBooks = new ArrayList<LibBook>();
    }

    public LibBook findByName(String name) {
        for (LibBook b : libBooks) {
            if (b.getName().equals(name))
                return b;
        }
        return null;
    }

    public void add(LibBook libBook) {
        libBooks.add(libBook);
    }
}
