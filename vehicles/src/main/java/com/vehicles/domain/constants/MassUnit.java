package com.vehicles.domain.constants;

public enum MassUnit {

    KG(0, 26_270, 1.0),
    T(0, 26, 1000.0),
    LB(0, 57_915, 0.45),
    ST(0, 4_136, 6.35);

    private final int minWeight;
    private final int maxWeight;
    private final double factor;

    MassUnit(int minWeight, int maxWeight, double factor) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.factor = factor;
    }

    public int getMinWeight() {
        return this.minWeight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    public double getFactor() {
        return this.factor;
    }

}
