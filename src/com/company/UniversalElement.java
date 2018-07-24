package com.company;

import static java.lang.Math.sqrt;

public class UniversalElement {

    private double[] ksi = {-(1/sqrt(3)), (1/sqrt(3)), (1/sqrt(3)), -(1/sqrt(3))};
    private double[] eta = {-(1/sqrt(3)), -(1/sqrt(3)), (1/sqrt(3)), (1/sqrt(3))};

    private double[][] shapeFunc; //funkcja ksztaltu ->N
    private double[][] derivativeKsi; //pochodnaKsi
    private double[][] derivativeEta; //pochodnaEta

    public UniversalElement(){
        shapeFunc = new double[4][4];
        derivativeKsi = new double[4][4];
        derivativeEta = new double[4][4];
    }

    public void shapeFunc() {
        for(int i=0; i<4; i++) {
            shapeFunc[i][0] = 0.25 * (1 - ksi[i]) * (1 - eta[i]);
            shapeFunc[i][1] = 0.25 * (1 + ksi[i]) * (1 - eta[i]);
            shapeFunc[i][2] = 0.25 * (1 + ksi[i]) * (1 + eta[i]);
            shapeFunc[i][3] = 0.25 * (1 - ksi[i]) * (1 + eta[i]);
        }
    }
    public void derivativeKsi() {  //pocgodna po ksi
        for(int i=0; i<4; i++) {
            derivativeKsi[i][0] = -0.25 * (1 - eta[i]);
            derivativeKsi[i][1] = 0.25 * (1 - eta[i]);
            derivativeKsi[i][2] = 0.25 * (1 + eta[i]);
            derivativeKsi[i][3] = -0.25 * (1 + eta[i]);
        }
    }

    public void derivativeEta(){    // pochodna po eta
        for(int i=0; i<4; i++) {
            derivativeEta[i][0] = -0.25 * (1 - ksi[i]);
            derivativeEta[i][1] = -0.25 * (1 + ksi[i]);
            derivativeEta[i][2] = 0.25 * (1 + ksi[i]);
            derivativeEta[i][3] = 0.25 * (1 - ksi[i]);
        }
    }
    public void showShapeFunc() {
        System.out.println("Funkcje kształtu:");
        for (int i = 0; i < 4; i++) {
            System.out.print("N " + (i+1) + ": ");
            for (int j = 0; j < 4; j++) {
                System.out.print(shapeFunc[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void showDerivativeKsi(){
        System.out.println("\nPochodne po ksi:");
        System.out.println("\t\t N1 \t\t\t\t\t\t N2\t\t\t\t\t\t N3 \t\t\t\t\t\t N4");
        for (int i = 0; i < 4; i++) {
            System.out.print("pc " + (i+1) + ": ");  ///pc-punkt calkowania
            for (int j = 0; j < 4; j++) {
                System.out.print(derivativeKsi[i][j]+" ");
//                System.out.println("suma sprawdzenie: " derivativeKsi[ );
            }
            System.out.println();
        }
    }

    public void showDerivativeEta(){
        System.out.println("\nPochodne po eta:");
        System.out.println("\t\tN1 \t\t\t\t \t\tN2 \t\t\t\t\t\t N3 \t\t\t\t\t\t N4");
        for (int i = 0; i < 4; i++) {
            System.out.print("pc " + (i+1) + ": ");  //pc-punkt calkowania
            for (int j = 0; j < 4; j++)
                System.out.print(derivativeEta[i][j]+" ");
            System.out.println();
        }
    }

    public double[][] getDerivativeKsi() {
        return derivativeKsi;
    }

    public double[][] getDerivativeEta() {
        return derivativeEta;
    }
}
