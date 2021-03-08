//
// Created by Ibrahim on 3/8/2021.
//

#include <jni.h>
#include <string>
#include 'MatrixMult.h'
#include <Eigen/Dense>

using Eigen::MatrixXd;


/*function name : Java_+_{package name}_+{class name}_+{function name}  */
JNIEXPORT jstring JNICALL Java_com_matrixplugin_MatrixPlugin_Multiply(JNIEnv *env, jobject, jint a[] ,jint b[]) {

    MatrixMult matm(a,b);
    MatrixXd m = matm.Mult();
   string res ="";

    for(int i =0;i<9;i++){
        res+= m(i/3,i%3);
        res+=" ";
    }
      return (*env)->NewStringUTF(env, res);
}