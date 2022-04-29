package com.company.lab37;

import java.util.ArrayList;

public class AdmissionManager {
    private boolean opened;
    private ArrayList<Entrant> entrants;
    private ArrayList<Faculty> faculties;


    public AdmissionManager() {
        this.opened = false;
        this.entrants = new ArrayList<Entrant>();
        this.faculties = new ArrayList<Faculty>();
    }

    public void openAdmission() {
        this.opened = true;
    }

    public void closeAdmission() {
        this.opened = false;
    }

    public boolean isOpened() { return this.opened; }

    public void registerExamToFaculty(Exam exam, Faculty faculty) {
//        if (!opened) {
//            throw new InvalidObjectException("Admission isn't opened.");
//        }

        if (false == faculties.contains(faculty)) {
            faculties.add(faculty);
        }
        faculty.registerExam(exam);
    }

    public void addEntrant(Entrant entrant) {
//        if (!opened) {
//            throw new InvalidObjectException("Admission isn't opened.");
//        }
        Faculty entrantFaculty = entrant.getFaculty();
        for (int i = 0; i < entrantFaculty.getExams().size(); i++) {
            Exam newExam = new Exam(entrantFaculty.getExams().get(i));
            entrant.registerExam(newExam);
        }
        this.entrants.add(entrant);
    }

    public void takeExamsBy(Entrant entrant) {
//        if (opened) {
//            throw new InvalidObjectException("Admission isn't closed.");
//        }
        entrant.takeExams();
    }

    public void rateExamBy(Teacher teacher, Exam exam, Entrant entrant, Mark mark) {
        for (Exam e : entrant.getExams()) {
            if (e.getName().equals(exam.getName())) {
                e.setMark(mark);
                return;
            }
        }
    }

    public double getMeanMark(Faculty faculty) {
        double mean = 0.0;
        int facultyEntrantCount = 0;
        for (Entrant ent : entrants) {
            if (ent.getFaculty().getId() == faculty.getId()) {
                mean += ent.getMeanMark();
                facultyEntrantCount++;
            }
        }
        mean /= facultyEntrantCount;
        return mean;
    }

    public String getSuccessEntrants(Faculty faculty) {
        StringBuilder sb = new StringBuilder("");
        sb.append("---------------------------------\n" + faculty.getName() + "\n---------------------------------\n");
        sb.append("Имя\t\t\t\tСредний балл\n--------------------------------\n");
        ArrayList<Entrant> facultyEntrants = new ArrayList<Entrant>();
        double facultyMeanMark = getMeanMark(faculty);

        for (Entrant ent : entrants) {
            if (ent.getFaculty().getId() == faculty.getId()) {
                facultyEntrants.add(ent);
            }
        }
        facultyEntrants.sort((entrant, t1) -> {
            double lMean = entrant.getMeanMark();
            double rMean = t1.getMeanMark();
            if (lMean > rMean)
                return -1;
            else if (lMean == rMean)
                return 0;
            else
                return 1;
        });
        for (int i = 0; i < faculty.getNumberOfStudents(); i++) {
            Entrant entrant = facultyEntrants.get(i);
            sb.append(entrant.getName() + "\t\t\t\t" + Double.toString(entrant.getMeanMark()) + "\n");
        }

        return sb.toString();
    }
}
