package com.company.lab37;

public class Lab37 {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    lab_7
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Построить модель программной системы.
    Система Вступительные экзамены. Абитуриент регистрируется на Факультет, сдает Экзамены.
    Преподаватель выставляет Оценку. Система подсчитывает средний балл и определяет
    Абитуриентов, зачисленных в учебное заведение.
     */
    public static void lab_7() {
        AdmissionManager admissionManager = new AdmissionManager();
        admissionManager.openAdmission();

        Exam mathExam = new Exam("Математика");
        Exam informaticsExam = new Exam("Информатика");

        Faculty infoFaculty = new Faculty(0, "Факультет информационных технологий", 2);

        admissionManager.registerExamToFaculty(mathExam, infoFaculty);
        admissionManager.registerExamToFaculty(informaticsExam, infoFaculty);

        Entrant entrantVasya = new Entrant("Василий", infoFaculty);
        Entrant entrantPetya = new Entrant("Петр", infoFaculty);
        Entrant entrantTanya = new Entrant("Татьяна", infoFaculty);

        admissionManager.addEntrant(entrantVasya);
        admissionManager.addEntrant(entrantPetya);
        admissionManager.addEntrant(entrantTanya);

        admissionManager.closeAdmission();

        admissionManager.takeExamsBy(entrantPetya);
        admissionManager.takeExamsBy(entrantVasya);
        admissionManager.takeExamsBy(entrantTanya);

        Teacher teacherDima = new Teacher("Дмитрий");
        Teacher teacherElena = new Teacher("Елена");

        admissionManager.rateExamBy(teacherDima, mathExam, entrantPetya, new Mark(3.5));
        admissionManager.rateExamBy(teacherDima, mathExam, entrantTanya, new Mark(5));
        admissionManager.rateExamBy(teacherDima, mathExam, entrantVasya, new Mark(4));
        admissionManager.rateExamBy(teacherElena, informaticsExam, entrantPetya, new Mark(3));
        admissionManager.rateExamBy(teacherElena, informaticsExam, entrantTanya, new Mark(5));
        admissionManager.rateExamBy(teacherElena, informaticsExam, entrantVasya, new Mark(4.5));

        System.out.println(admissionManager.getSuccessEntrants(infoFaculty));
    }

}
