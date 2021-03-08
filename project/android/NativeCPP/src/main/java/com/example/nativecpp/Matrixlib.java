package com.example.nativecpp;

public class Matrixlib {

    static {
        System.loadLibrary("Matrix-lib");
    }

    public native String Multiply(int[] a, int[] b);
}
