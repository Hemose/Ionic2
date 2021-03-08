package com.example.nativecpp;

public class Matrixlib {

    static {
        System.loadLibrary("Matrix-lib");
    }

    public native int[] Multiply(int[] a, int[] b);
}
