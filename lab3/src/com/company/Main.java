package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] n = {{1, 2}, {3, 4}};
        int[][] m = {{5, 6}, {7, 8}};

        SquareMatrix mtxA = new SquareMatrix(n);
        SquareMatrix mtxB = new SquareMatrix(m);

        SquareMatrix[] mtxs = new SquareMatrix[2];
        mtxs[0] = mtxA;
        mtxs[1] = mtxB;

        SquareMatrix addMtx = mtxs[0].add(mtxs[1]);
        SquareMatrix subMtx = mtxs[0].sub(mtxs[1]);
        SquareMatrix mulMtx = mtxs[0].mul(mtxs[1]);

        System.out.println("add:\n" + mtxs[0].add(mtxs[1]).toString() +
                "sub:\n" + mtxs[0].sub(mtxs[1]).toString() +
                "mul:\n" + mtxs[0].mul(mtxs[1]).toString());

        int minIdx = -1;
        if ((mtxs[0].firstNorma() < mtxs[1].firstNorma()) && (mtxs[0].secondNorma() < mtxs[1].secondNorma())) {
            minIdx = 0;
        } else if ((mtxs[1].firstNorma() < mtxs[0].firstNorma()) && (mtxs[1].secondNorma() < mtxs[0].secondNorma())) {
            minIdx = 1;
        }

        System.out.println("Matrix with min first and second normas: " + (minIdx == -1 ? "None" : minIdx));
    }
    
    public static void changeMinMax(RectMatrix mtx, int col) {
        int minRow = 0;
        int maxRow = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < ; i++) {
            
        }
    }
}
