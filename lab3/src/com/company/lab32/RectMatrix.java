package com.company.lab32;

public class RectMatrix {
    private int nDim;
    private int mDim;
    private int[][] matrix;

    public RectMatrix() {
        nDim = mDim = 1;
        matrix = new int[nDim][mDim];
        matrix[0][0] = 0;
    }

    public RectMatrix(int n, int m) {
        nDim = n;
        mDim = m;
        matrix = new int[nDim][mDim];
        for (int i = 0; i < nDim; i++) {
            for (int j = 0; j < mDim; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public RectMatrix(int[][] mtx) {
        set(mtx);
    }

    public void set(int[][] mtx) {
        nDim = mtx.length;
        mDim = mtx[0].length;
        matrix = new int[nDim][mDim];
        for (int i = 0; i < nDim; i++) {
            for (int j = 0; j < mDim; j++) {
                matrix[i][j] = mtx[i][j];
            }
        }
    }

    public void setAt(int val, int row, int col) {
        matrix[row][col] = val;
    }

    public int[][] get() {
        return matrix;
    }

    public int getAt(int row, int col) {
        return matrix[row][col];
    }

    public int size() { return nDim*mDim; }

//    public int[] shape() {
//        return new int[]{ nDim, mDim };
//    }

    public int nDim() { return nDim; }
    public int mDim() { return mDim; }

    @Override
    public String toString() {
        StringBuilder mtxString = new StringBuilder("");
        for (int i = 0; i < nDim; i++) {
            for (int j = 0; j < mDim-1; j++) {
                mtxString.append(matrix[i][j]);
                mtxString.append("\t");
            }
            mtxString.append(matrix[i][mDim-1]);
            mtxString.append("\n");
        }
        return mtxString.toString();
    }
}
