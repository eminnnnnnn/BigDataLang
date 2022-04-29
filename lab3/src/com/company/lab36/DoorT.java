package com.company.lab36;

import java.util.Objects;

public class DoorT {
    private int width;
    private int height;
    private boolean closed;
    private String material;

    public DoorT(int width, int height, String material) {
        this.width = width;
        this.height = height;
        this.closed = true;
        this.material = new String(material);
    }

    public void close() {
        closed = true;
    }

    public void open() {
        closed = false;
    }

    public boolean isClosed() { return closed; };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoorT doorT = (DoorT) o;
        return width == doorT.width && height == doorT.height && Objects.equals(material, doorT.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, material);
    }

    @Override
    public String toString() {
        return new String("Door{" + width + "x" + height + ", " + material + ", " + (closed ? "closed" : "opened") + "}");
    }
}
