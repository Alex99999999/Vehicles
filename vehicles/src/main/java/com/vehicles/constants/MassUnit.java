package com.vehicles.constants;

public enum MassUnit {

    KG(0, 26_270),
    T(0, 26),
    LB(0, 57_915),
    ST(0, 4_136);

    private final int minWeight;
    private final int maxWeight;

    MassUnit(int minWeight, int maxWeight) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public int getMinWeight() {
        return this.minWeight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

}
