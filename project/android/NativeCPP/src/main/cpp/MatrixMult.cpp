//
// Created by Ibrahim on 3/8/2021.
//

#include "MatrixMult.h"
#include <Eigen/Dense>

using Eigen::MatrixXd;

MatrixMult::MatrixMult(int a[], int b[]) {
    for (int i = 0; i < 9; ++i) {
        MatrixMult::m1[i] = a[i];
        MatrixMult::m2[i] = b[i];
    }
}

MatrixXd MatrixMult::Mult() {
    MatrixXd m(3, 3);
    MatrixXd a(3, 3);
    MatrixXd b(3, 3);
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            a(i, j) = m1[i * 3 + j];
        }
    }
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            b(i, j) = m2[i * 3 + j];
        }
    }
    m = a * b;
    int res[9];
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            res[i * 3 + j] = m(i, j);
        }
    }

//    std::cout << m;
    return m;
}