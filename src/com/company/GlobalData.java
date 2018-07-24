package com.company;

public class GlobalData {
    private  double height, width;   // Wysokość, szerokość siatki
    private int numberOfNodeH, numberOfNodeW;     // Liczba węzłów na wysokość, szerokość
    private  int numberOfNode, numberOfElement;    // Liczba węzłów, elementów
    private double initialTemperature;        //temp poczatkowa
    private double k;       // wsp przewodzenenia
    private double alfa;    //Wspolczynnik przenikania ciepla
    private int dt;             // zmiana czasu
    private int specificHeat;     // coieplo wlasciwe
    private int density;         /// gestosc
    private int ambientTemperature;   // wtemp otoczenia


    public GlobalData(double height, double width, int numberOfNodeH, int numberOfNodeW, double initialTemperature, double k, double alfa, int dt, int specificHeat, int density, int ambientTemperature) {

            this.height = height;
            this.width = width;
            this.numberOfNodeH = numberOfNodeH;
            this.numberOfNodeW = numberOfNodeW;
            this.initialTemperature = initialTemperature;
            this.k = k;
            this.alfa = alfa;
            this.dt = dt;
            this.specificHeat = specificHeat;
            this.density = density;
            this.ambientTemperature = ambientTemperature;

        numberOfNode = numberOfNodeH * numberOfNodeW;
        numberOfElement = (numberOfNodeH-1) * (numberOfNodeW - 1);        // bo na dwa wezly przypada jeden elemencik
    }

    public double getInitialTemperature() {
        return initialTemperature;
    }

    public  double getHeight() {
        return height;
    }

    public  double getWidth() {
        return width;
    }

    public  int getNumberOfNodeH() {
        return numberOfNodeH;
    }

    public  int getNumberOfNodeW() {
        return numberOfNodeW;
    }

    public  int getNumberOfNode() {
        return numberOfNode;
    }

    public  int getNumberOfElement() {
        return numberOfElement;
    }

    public double getK() {
        return k;
    }

    public double getAlfa() {
        return alfa;
    }

//    public int getDt() {
//        return dt;
//    }
//
//    public int getSpecificHeat() {
//        return specificHeat;
//    }
//
//    public int getDensity() {
//        return density;
//    }
//
//    public int getAmbientTemperature() {
//        return ambientTemperature;
//    }
}
