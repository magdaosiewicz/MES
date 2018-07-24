package com.company;
public class Grid {

    private GlobalData globalData;
    private Node[] nodes;
    private Element[] elements;

    public Grid(GlobalData globalData) {
        this.globalData = globalData;
        nodes = new Node[globalData.getNumberOfNode()];
        elements = new Element[globalData.getNumberOfElement()];
    }

    public void initializeNodes() {
        double x = 0, y = 0;
        double dx = globalData.getWidth() / (globalData.getNumberOfNodeW() -1);   // odl;eglosc miedzy wezlami na osi x i nizej y
        double dy = globalData.getHeight() / (globalData.getNumberOfNodeH() -1);

        for (int i = 0; i < nodes.length; i++ ) {  // node.lenth na poczatku = 4
            nodes[i] = new Node(x, y, globalData.getInitialTemperature(), informationBoundaryCondition(i), i);
            y += dy;
            if (i % globalData.getNumberOfNodeH() == 0) {
                x += dx;
                y = 0;                                                                    // zeby siatka nie byla tylko podluzna
                                                                                            // przesuwam sie na bok i zeruje y
            }
        }
    }
//Warunki brzegowe
    private boolean informationBoundaryCondition(int numberOfNode) {
        boolean BC = false;

        if (numberOfNode < globalData.getNumberOfNodeH() || numberOfNode >= globalData.getNumberOfNode() - globalData.getNumberOfNodeH()) {  // nigdy nei moze byc wieksze numberOfNose od
            BC = true;
        }
        if (numberOfNode % globalData.getNumberOfNodeH() == 0 || numberOfNode % globalData.getNumberOfNodeH() == globalData.getNumberOfNodeH() - 1) {
            BC = true;
        }
        return BC;
    }

    public void initializeElements() {
        int widthId = 0, heightId = 0;   // liczna rzedow
        for (int i = 0; i < elements.length; i++) {
            if (i % (globalData.getNumberOfNodeH() - 1) == 0) {
                heightId = 0;
                ++widthId;
            }
            ++heightId;
            elements[i] = new Element(elementID(heightId, widthId), elementBC(heightId, widthId), i);
        }
    }

    private int[] elementID(int heightId, int widthId) {

        int down_left = globalData.getNumberOfNodeH() * (widthId - 1) + heightId;   // rozwsowanlalalam u uli w zeszycie
        int down_right = down_left + globalData.getNumberOfNodeH();                 //
        int up_right = down_right + 1;                                              //
        int up_left = down_left + 1;                                                //
        return new int[]{down_left, down_right, up_right, up_left};
    }

    private int[] elementBC(int heightId, int widthId) {
        int[] BC = new int[]{0, 0, 0, 0}; //ściany
        if (widthId == 1) {
            BC[0] = 1;
        }
        if (heightId == 1) {
            BC[1] = 1;
        }
        if (widthId == (globalData.getNumberOfNodeW() - 1)) {
            BC[2] = 1;
        }
        if (heightId == (globalData.getNumberOfNodeH() - 1)) {
            BC[3] = 1;
        }
        return BC;  // warunki n apowierzchni
    }

    public void viewNodes() {
        for (int i = 0; i < nodes.length; i++)
            System.out.println(nodes[i]);
    }

    public void viewElements() {
        for (int i = 0; i < elements.length; i++)
            System.out.println(elements[i]);
    }

    public GlobalData getGlobalData() {
        return globalData;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public Element[] getElements() {
        return elements;
    }
}