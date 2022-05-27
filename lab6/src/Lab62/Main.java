package Lab62;

/*
    Умножить два многочлена заданной степени, если коэффициенты многочленов
    хранятся в различных списках.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ioErrorMsg = "Ошибка из-за некорректного ввода. Завершение программы.";

        int degree_1 = 0;
        int degree_2 = 0;
        int res_degree = 0;

        System.out.print("Степень первого множителя-многочлена = ");
        try {
            degree_1 = scan.nextInt();
            if (degree_1 < 0)
                throw new IOException("Степень многочлена должна быть положительной.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(ioErrorMsg);
            System.exit(1);
        } catch (Exception e) {
            System.out.println(ioErrorMsg);
            System.exit(1);
        }

        Vector<Integer> polynom_1 = new Vector<>(degree_1);
        for (int i = 0; i <= degree_1; i++) {
            System.out.print("    Коэффициент a" + i + " = ");
            try {
                int coef = scan.nextInt();
                if (degree_1 == i && degree_1 != 0 && coef == 0)
                    throw new IOException("Переменная со старшей степенью должна иметь ненулевой коэффициент.");
                polynom_1.add(coef);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println(ioErrorMsg);
                System.exit(1);
            } catch (Exception e) {
                System.out.println(ioErrorMsg);
                System.exit(1);
            }
        }

        System.out.print("Степень второго множителя-многочлена = ");
        try {
            degree_2 = scan.nextInt();
            if (degree_2 < 0)
                throw new IOException("Степень многочлена должна быть положительной.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(ioErrorMsg);
            System.exit(1);
        } catch (Exception e) {
            System.out.println(ioErrorMsg);
            System.exit(1);
        }

        Vector<Integer> polynom_2 = new Vector<>(degree_2);
        for (int i = 0; i <= degree_2; i++) {
            System.out.print("    Коэффициент a" + i + " = ");
            try {
                int coef = scan.nextInt();
                if (degree_2 == i && degree_2 != 0 && coef == 0)
                    throw new IOException("Переменная со старшей степенью должна иметь ненулевой коэффициент.");
                polynom_2.add(coef);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println(ioErrorMsg);
                System.exit(1);
            } catch (Exception e) {
                System.out.println(ioErrorMsg);
                System.exit(1);
            }
        }

        if (degree_1 < degree_2) {
            for (int i = degree_1 + 1; i <= degree_2; i++) {
                polynom_1.add(0);
            }
        } else if (degree_2 < degree_1) {
            for (int i = degree_2 + 1; i <= degree_1; i++) {
                polynom_2.add(0);
            }
        }

        res_degree = degree_1 + degree_2;
        Vector<Integer> res_polynom = new Vector<>(res_degree + 1); //
        for (int i = 0; i <= res_degree; i++) {
            res_polynom.add(0);
        }

        for (int i = 0; i <= degree_1; i++) {
            for (int j = 0; j <= degree_2; j++) {
//                System.out.printf("a%dx^%d = %dx^%d, b%dx^%d = %dx^%d, curr_res a%dx^%d = %d, mul_res = %d\n",
//                        i, i, polynom_1.get(i), i,
//                        j, j, polynom_2.get(j), j,
//                        (i+j), (i+j), res_polynom.get(i+j),
//                        polynom_1.get(i) * polynom_2.get(j));
                res_polynom.set(i + j, res_polynom.get(i+j) + (polynom_1.get(i) * polynom_2.get(j)));
            }
        }

        System.out.print("Результат умножения: ");
        System.out.print(res_polynom.get(0));
        for (int i = 1; i <= res_degree; i++) {
            Integer coef = res_polynom.get(i);
            if (coef != 0) {
                String term = res_polynom.get(i) + "x^" + i;
                System.out.print(" + " + term);
            }
        }
    }
}