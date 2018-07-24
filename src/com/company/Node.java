package com.company;

public class Node {

    private double x, y;
    private double temperature;
    private boolean boundaryCondition; //warunek brzegowy
    private int nodeId;

    public Node(double x, double y, double temperature, boolean boundaryCondition, int nodeId) {
        this.x = x;
        this.y = y;
        this.temperature = temperature;
        this.boundaryCondition = boundaryCondition;
        this.nodeId = ++nodeId;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getNodeId() {
        return nodeId;
    }

}
