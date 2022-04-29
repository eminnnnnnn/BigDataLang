package com.company.lab36;

import java.util.Objects;

public class WindowT {
    private int width;
    private int height;
    private boolean closed;

    public WindowT(int width, int height) {
        this.width = width;
        this.height = height;
        this.closed = true;
    }

    public void close() {
        this.closed = true;
    }

    public void open() {
        this.closed = false;
    }

    public boolean isClosed() {
        return closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WindowT windowT = (WindowT) o;
        return width == windowT.width && height == windowT.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return new String("Window{" + width + "x" + height + ", " + (closed ? "closed" : "opened") + "}");
    }
}
