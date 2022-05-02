package Lab52;

import com.company.lab32.RectMatrix;

public class Lab52 {
    /*
    Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние
    потоков ввода/вывода. При возникновении ошибок, связанных с корректностью
    выполнения математических операций, генерировать и обрабатывать исключительные
    ситуации. Предусмотреть обработку исключений, возникающих при нехватке памяти,
    отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.

    Определить класс Матрица размерности (n x m). Класс должен содержать несколько конструкторов.
    Объявить массив объектов. Передать объекты в метод, меняющий местами строки с максимальным и
    минимальным элементами k-го столбца. Создать метод, который изменяет i-ю матрицу путем
    возведения ее в квадрат.
     */
    public static void lab5_2() {
        RectMatrix[] matrices = new RectMatrix[] {
                new RectMatrix(new int[][]{ {1,2,3}, {4,5,6} }),
                new RectMatrix(new int[][]{ {7,2,1,4}, {6,1,3,6}, {9,12,4,7} }),
                new RectMatrix(new int[][]{ {15,3}, {8,1}, {3,2}, {4,5} })
        };
        for (int i = 0; i < matrices.length; i++) {
            System.out.println("matrices[" + i + "]:\n" + matrices[i]);
        }
        try {
            for (int i = 0; i < matrices.length; i++) {
                changeMinMax(matrices, 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        squareMatrix(matrices, 2);
        for (int i = 0; i < matrices.length; i++) {
            System.out.println("matrices[" + i + "]:\n" + matrices[i]);
        }
    }

    public static void changeMinMax(RectMatrix[] mtxs, int kcol) {
        for (int i = 0; i < mtxs.length; i++) {
            changeMinMax(mtxs[i], kcol);
        }
    }

    public static void changeMinMax(RectMatrix mtx, int kcol) throws IndexOutOfBoundsException {
        if (kcol >= mtx.mDim()) {
            throw new IndexOutOfBoundsException();
        }
        int minRow = 0;
        int maxRow = 0;
        int min = mtx.getAt(0, kcol);
        int max = mtx.getAt(0, kcol);
        for (int i = 1; i < mtx.nDim(); i++) {
            if (mtx.getAt(i, kcol) > max) {
                max = mtx.getAt(i, kcol);
                maxRow = i;
            }
            if (mtx.getAt(i, kcol) < min) {
                min = mtx.getAt(i, kcol);
                minRow = i;
            }
        }

        for (int i = 0; i < mtx.mDim(); i++) {
            int tmp = mtx.getAt(minRow, i);
            mtx.setAt(mtx.getAt(maxRow, i), minRow, i);
            mtx.setAt(tmp, maxRow, i);
        }
    }

    public static void squareMatrix(RectMatrix[] mtxs, int num) {
        for (int i = 0; i < mtxs[num].nDim(); i++) {
            for (int j = 0; j < mtxs[num].mDim(); j++) {
                int val = mtxs[num].getAt(i, j);
                mtxs[num].setAt(val*val, i, j);
            }
        }
    }
}

