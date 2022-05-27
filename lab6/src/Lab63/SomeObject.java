package Lab63;

import java.util.Objects;

public class SomeObject {
    public String name;
    public String code;

    public SomeObject(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return name + "[" + code + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeObject that = (SomeObject) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
