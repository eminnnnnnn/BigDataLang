package Lab51;

import com.company.lab31.SquareMatrix;

public class Lab51 {
    /*
    Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние
    потоков ввода/вывода. При возникновении ошибок, связанных с корректностью
    выполнения математических операций, генерировать и обрабатывать исключительные
    ситуации. Предусмотреть обработку исключений, возникающих при нехватке памяти,
    отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.

    Определить класс Матрица размерности (n x n). Класс должен содержать несколько конструкторов.
    Реализовать методы для сложения, вычитания, умножения матриц. Объявить массив объектов. Создать
    методы, вычисляющие первую и вторую норму матрицы. Определить какая из матриц имеет наименьшую
    первую и вторую нормы.
     */
    public static void lab5_1() {
        int[][] n = {{1, 2}, {3, 4}};
        int[][] m = {{5, 6}, {7, 8}};

        SquareMatrix mtxA = new SquareMatrix(n);
        SquareMatrix mtxB = new SquareMatrix(m);

        SquareMatrix[] mtxs = new SquareMatrix[2];
        mtxs[0] = mtxA;
        mtxs[1] = mtxB;

        try {
            SquareMatrix addMtx = mtxs[0].add(mtxs[1]);
            SquareMatrix subMtx = mtxs[0].sub(mtxs[1]);
            SquareMatrix mulMtx = mtxs[0].mul(mtxs[1]);

            System.out.println("add:\n" + addMtx.toString() +
                    "sub:\n" + subMtx.toString() +
                    "mul:\n" + mulMtx.toString());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка при выполнении арифметической операции. " + e.getMessage());
        }

        int minIdx = -1;
        if ((mtxs[0].firstNorma() < mtxs[1].firstNorma()) && (mtxs[0].secondNorma() < mtxs[1].secondNorma())) {
            minIdx = 0;
        } else if ((mtxs[1].firstNorma() < mtxs[0].firstNorma()) && (mtxs[1].secondNorma() < mtxs[0].secondNorma())) {
            minIdx = 1;
        }
        System.out.println("Matrix with min first and second normas: " + (minIdx == -1 ? "None" : minIdx));
    }
}
