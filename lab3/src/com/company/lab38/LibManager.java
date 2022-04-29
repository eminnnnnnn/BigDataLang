package com.company.lab38;

import java.util.ArrayList;

public class LibManager {
    private LibBookStore bookStore;
    private ArrayList<LibVisitor> visitors;
    private ArrayList<LibWorker> workers;
    public LibManager(LibAdmin admin) {
        admin.setLibManager(this);
        visitors = new ArrayList<LibVisitor>();
        bookStore = new LibBookStore();
        workers = new ArrayList<LibWorker>();
    }

    public void addBook(LibBook book) {
        bookStore.add(book);
    }

    public void addVisitor(LibVisitor visitor) {
        visitors.add(visitor);
    }

    public LibOrder orderBy(LibVisitor visitor, LibOrder order, LibWorker worker) {
        LibBook orderedBook = bookStore.findByName(order.getBookName());
        if ((false == visitor.isInBlackList()) && (orderedBook != null)) {
            order.registerBook(orderedBook, worker);
            visitor.addOrder(order);
            return order;
        }
        return null;
    }

    public void addToBlackList(LibVisitor visitor) {
        for (LibVisitor v : visitors) {
            if (v.equals(visitor))
                v.addToBlackList();
        }
    }

    public void addWorker(LibWorker worker) {
        workers.add(worker);
    }

    public String getOrdersTableString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Имя читателя\t\t\t\tНомер заказа\t\t\t\tНазвание книги\n");
        sb.append("=====================================================================\n");

        for (LibVisitor v : visitors) {
            if (v.getOrders().size() > 0) {
                sb.append(v.getName());
                for (LibOrder vo : v.getOrders()) {
                    sb.append("\t\t\t\t\t\t\t" + vo.getOrderNum() + "\t\t\t\t\t\t" + vo.getBookName() + "\n");
                }
                sb.append("---------------------------------------------------------------------\n");
            }
        }
        return sb.toString();
    }
}
