package com.company.lab36;

import java.util.ArrayList;
import java.util.Objects;

public class HouseT {
    private ArrayList<DoorT> doors;
    private ArrayList<WindowT> windows;
    private boolean closed;

    public HouseT(ArrayList<DoorT> doors, ArrayList<WindowT> windows) {
        this.doors = new ArrayList<DoorT>();
        this.windows = new ArrayList<WindowT>();
        this.closed = true;
        for (DoorT d : doors) {
            this.doors.add(d);
            this.closed = this.closed && d.isClosed();
        }
        for (WindowT w : windows) {
            this.windows.add(w);
            this.closed = this.closed && w.isClosed();
        }
    }

    public HouseT(DoorT[] doors, WindowT[] windows) {
        this.doors = new ArrayList<DoorT>();
        this.windows = new ArrayList<WindowT>();
        this.closed = true;
        for (DoorT d : doors) {
            this.doors.add(d);
            this.closed = this.closed && d.isClosed();
        }
        for (WindowT w : windows) {
            this.windows.add(w);
            this.closed = this.closed && w.isClosed();
        }
    }

    public void close() {
        for (DoorT d : doors) {
            d.close();
        }
        for (WindowT w : windows) {
            w.close();
        }
        this.closed = true;
    }

    public boolean isClosed() { return closed; }

    @Override
    public String toString() {
        StringBuilder houseString = new StringBuilder("House {\n");
        houseString.append("  Number of doors: " + doors.size());
        for (DoorT d : doors) {
            houseString.append("\n    " + d);
        }
        houseString.append("\n  Number of windows: " + windows.size());
        for (WindowT w : windows) {
            houseString.append("\n    " + w);
        }
        houseString.append("\n  Closed: " + (closed ? "Yes" : "No"));
        houseString.append("\n}");
        return houseString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseT houseT = (HouseT) o;
        return Objects.equals(doors, houseT.doors) && Objects.equals(windows, houseT.windows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doors, windows);
    }
}
