package com.company.lab37;

import java.util.ArrayList;

public class Entrant {
    private String name;
    private Faculty faculty;
    private ArrayList<Exam> exams;
    private boolean examsTaken;

    public Entrant(String name, Faculty faculty) {
        this.name = new String(name);
        this.faculty = faculty;
        this.examsTaken = false;
        this.exams = new ArrayList<Exam>();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setName(String name) {
        this.name = new String(name);
    }

    public String getName() {
        return name;
    }

    public void registerExam(Exam exam) {
        exams.add(exam);
    }

    public void takeExams() {
        examsTaken = true;
    }

    public double getMeanMark() {
//        if (false == examsTaken) {
//            throw new InvalidObjectException("Exams aren't taken. Cannot calculate mean mark.")
//        }
        double mean = 0.0;
        for (int i = 0; i < exams.size(); i++) {
            mean += exams.get(i).getMark().getValue();
        }
        mean /= exams.size();
        return mean;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }
}
