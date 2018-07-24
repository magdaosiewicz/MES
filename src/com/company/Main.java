package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        GlobalData  globalData = new GlobalData(0.1,0.1,4,4,100,30,300,50,700,7800,1200);

        Grid grid = new Grid(globalData);   // robienie siatki
        grid.initializeNodes();
        grid.initializeElements();

//Wyswietlenie elementow
        // grid.viewNodes();
        //  System.out.println();
        //  grid.viewElements();
        //   System.out.println();

        /* Shape function */
        UniversalElement universalElement = new UniversalElement();
        universalElement.shapeFunc();
        universalElement.showShapeFunc();

        /* Derivatives after ksi, eta */
        universalElement.derivativeKsi();
        universalElement.derivativeEta();
        universalElement.showDerivativeKsi();
        universalElement.showDerivativeEta();
        System.out.println();


        /* Jacobian */
        Jacobian jacobian = new Jacobian(grid);
        jacobian.jacobian(universalElement, grid);

        /* Matrix H */
  //      jacobian.transformationJacobian(grid);

        /* Matrix C */
       // jacobian.matrixC(grid);
//
//        /* Vector P */
//        jacobian.vectorP(grid);
//
       // jacobian.finalMatrixH();
//       // jacobian.finalVectorP();
    }
}
