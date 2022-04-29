package com.company.lab35;

import java.util.Objects;

public class NumberT {
    private int value;

    public NumberT() { this.value = 0; }
    public NumberT(int value) { this.value = value; }
    public NumberT(NumberT number) { this.value = number.value; }

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberT numberT = (NumberT) o;
        return value == numberT.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
