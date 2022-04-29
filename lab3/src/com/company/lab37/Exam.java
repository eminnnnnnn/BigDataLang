package com.company.lab37;

import java.util.Objects;

public class Exam {
    private String name;
    private Mark mark;

    public Exam(String name) {
        this.name = new String(name);
    }

    public Exam(Exam exam) {
        this.name = new String(exam.getName());
    }

    public String getName() {
        return name;
    }

    public void setMark(Mark mark) { this.mark = mark; }

    public Mark getMark() { return this.mark; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Экзамен{");
        sb.append("Название='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return Objects.equals(name, exam.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
