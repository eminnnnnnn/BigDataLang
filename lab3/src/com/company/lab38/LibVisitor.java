package com.company.lab38;

import java.util.ArrayList;
import java.util.Objects;

public class LibVisitor {
    private String name;
    private ArrayList<LibOrder> orders;

    private boolean isInBlackList;

    private int id;
    private static int idCounter = 0;

    public LibVisitor(String name) {
        this.name = new String(name);
        this.isInBlackList = false;
        this.orders = new ArrayList<LibOrder>();

        this.id = idCounter;
        idCounter++;
    }

    public void addOrder(LibOrder order) {
        orders.add(order);
    }

    public void removeOrder(LibOrder order) {
        orders.remove(order);
    }

    public void addToBlackList() { this.isInBlackList = true; }

    public boolean isInBlackList() { return isInBlackList; }

    public ArrayList<LibOrder> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibVisitor that = (LibVisitor) o;
        return isInBlackList == that.isInBlackList && id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
