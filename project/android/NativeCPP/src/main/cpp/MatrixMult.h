//
// Created by Ibrahim on 3/8/2021.
//

#ifndef MATRIXMULTPLICATION_MATRIXMULT_H
#define MATRIXMULTPLICATION_MATRIXMULT_H

#include<iostream>
#include <Eigen/Dense>

using Eigen::MatrixXd;

class MatrixMult {

public:
    int m1[9];
    int m2[9];

    MatrixMult(int a[], int b[]);

    MatrixXd Mult();
};

#endif //MATRIXMULTPLICATION_MATRIXMULT_H
