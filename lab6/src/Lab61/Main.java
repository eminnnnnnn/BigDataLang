package Lab61;

/*
    Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся
    в объекте HashMap.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ioErrorMsg = "Ошибка из-за некорректного ввода. Завершение программы.";

        int degree_1 = 0;
        HashMap<String, Integer> polynom_1 = new HashMap<String, Integer>();
        int degree_2 = 0;
        HashMap<String, Integer> polynom_2 = new HashMap<String, Integer>();
        int res_degree = 0;
        HashMap<String, Integer> res_polynom = new HashMap<String, Integer>();

        System.out.print("Степень первого слагаемого-многочлена = ");
        try {
            degree_1 = scan.nextInt();
        } catch (Exception e) {
            System.out.println(ioErrorMsg);
            System.exit(1);
        }
        for (int i = 0; i <= degree_1; i++) {
            String coef = "a" + i;
            System.out.print("    Коэффициент " + coef + " = ");
            try {
                polynom_1.put(coef, scan.nextInt());
            } catch (Exception e) {
                System.out.println(ioErrorMsg);
                System.exit(1);
            }
        }

        System.out.print("Степень второго слагаемого-многочлена = ");
        try {
            degree_2 = scan.nextInt();
        } catch (Exception e) {
            System.out.println(ioErrorMsg);
            System.exit(1);
        }
        for (int i = 0; i <= degree_2; i++) {
            String coef = "a" + i;
            System.out.print("    Коэффициент " + coef + " = ");
            try {
                polynom_2.put(coef, scan.nextInt());
            } catch (Exception e) {
                System.out.println(ioErrorMsg);
                System.exit(1);
            }
        }

        res_degree = Integer.max(degree_1, degree_2);

        for (int i = 0; i <= res_degree; i++) {
            String coef = "a" + i;
            Integer a1 = polynom_1.get(coef);
            Integer a2 = polynom_2.get(coef);
            res_polynom.put(coef, (a1 == null ? 0 : a1) + (a2 == null ? 0 : a2));
        }

        System.out.print("Результат сложения: ");
        System.out.print(res_polynom.get("a0"));
        for (int i = 1; i <= res_degree; i++) {
            String coef = "a" + i;
            String term = res_polynom.get(coef) + "x^" + i;
            System.out.print(" + " + term);
        }
    }

//    Сложение с использованием вектора (не по заданию)
//    public static void foo() {
//        Scanner scan = new Scanner(System.in);
//        String ioErrorMsg = "Ошибка из-за некорректного ввода. Завершение программы.";
//
//        int degree_1 = 0;
//        int degree_2 = 0;
//        int res_degree = 0;
//
//        System.out.print("Степень первого слагаемого-многочлена = ");
//        try {
//            degree_1 = scan.nextInt();
//            if (degree_1 < 0)
//                throw new IOException("Степень многочлена должна быть положительной.");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            System.out.println(ioErrorMsg);
//            System.exit(1);
//        } catch (Exception e) {
//            System.out.println(ioErrorMsg);
//            System.exit(1);
//        }
//
//        Vector<Integer> polynom_1 = new Vector<>(degree_1);
//        for (int i = 0; i <= degree_1; i++) {
//            System.out.print("    Коэффициент a" + i + " = ");
//            try {
//                int coef = scan.nextInt();
//                if (degree_1 == i && degree_1 != 0 && coef == 0)
//                    throw new IOException();
//                polynom_1.add(coef);
//            } catch (IOException e) {
//                System.out.println("Переменная со старшей степенью должна иметь ненулевой коэффициент.");
//                System.out.println(ioErrorMsg);
//                System.exit(1);
//            } catch (Exception e) {
//                System.out.println(ioErrorMsg);
//                System.exit(1);
//            }
//        }
//
//        System.out.print("Степень второго слагаемого-многочлена = ");
//        try {
//            degree_2 = scan.nextInt();
//            if (degree_2 < 0)
//                throw new IOException("Степень многочлена должна быть положительной.");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            System.out.println(ioErrorMsg);
//            System.exit(1);
//        } catch (Exception e) {
//            System.out.println(ioErrorMsg);
//            System.exit(1);
//        }
//
//        Vector<Integer> polynom_2 = new Vector<>(degree_2);
//        for (int i = 0; i <= degree_2; i++) {
//            System.out.print("    Коэффициент a" + i + " = ");
//            try {
//                int coef = scan.nextInt();
//                if (degree_2 == i && degree_2 != 0 && coef == 0)
//                    throw new IOException();
//                polynom_2.add(coef);
//            } catch (IOException e) {
//                System.out.println("Переменная со старшей степенью должна иметь ненулевой коэффициент.");
//                System.out.println(ioErrorMsg);
//                System.exit(1);
//            } catch (Exception e) {
//                System.out.println(ioErrorMsg);
//                System.exit(1);
//            }
//        }
//
//        if (degree_1 < degree_2) {
//            for (int i = degree_1 + 1; i <= degree_2; i++) {
//                polynom_1.add(0);
//            }
//        } else if (degree_2 < degree_1) {
//            for (int i = degree_2 + 1; i <= degree_1; i++) {
//                polynom_2.add(0);
//            }
//        }
//
//        res_degree = Integer.max(degree_1, degree_2);
//        Vector<Integer> res_polynom = new Vector<>(res_degree);
//
//        for (int i = 0; i <= res_degree; i++) {
//            res_polynom.add(polynom_1.get(i) + polynom_2.get(i));
//        }
//
//        System.out.print("Результат сложения: ");
//        System.out.print(res_polynom.get(0));
//        for (int i = 1; i <= res_degree; i++) {
//            Integer coef = res_polynom.get(i);
//            if (coef != 0) {
//                String term = res_polynom.get(i) + "x^" + i;
//                System.out.print(" + " + term);
//            }
//        }
//    }
}