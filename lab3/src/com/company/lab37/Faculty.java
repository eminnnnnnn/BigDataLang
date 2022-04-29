package com.company.lab37;

import com.company.lab37.Exam;

import java.util.ArrayList;

public class Faculty {
    private int id;
    private String name;
    private int numberOfStudents;
    private ArrayList<Exam> exams;

    public Faculty(int id, String name, int numberOfStudents) {
        this.id = id;
        this.name = new String(name);
        this.numberOfStudents = numberOfStudents;
        exams = new ArrayList<Exam>();
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void registerExam(Exam exam) {
        if (false == exams.contains(exam)) {
            exams.add(exam);
        }
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }
}
