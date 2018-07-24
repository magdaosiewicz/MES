package com.company;

public class Element {
    private int[] nodesId = new int[4];
    private int[] area = new int[4];    // powierzchnia przejkroju
    private int elementId;

    public Element(int[] nodesId, int[] area, int elementId) {
        this.nodesId = nodesId;
        this.area = area;
        this.elementId = ++elementId;
    }

    public int[] getNodesId() {
        return nodesId;
    }

    public int[] getArea() {
        return area;
    }

//    @Override
//    public String toString() {
//        return "El. " + String.format("%d", elementId) + " {" + "nodesId = " + Arrays.toString(nodesId) + "   " + "BC ścian = " + Arrays.toString(area) + '}';
//    }
}
