package com.microservices.configurations.beans;

public class LimitsConfigurations {
    private String minimmum;
    private String maximum;

    protected LimitsConfigurations(){

    }
    public LimitsConfigurations(String minimmum, String maximum) {
        this.minimmum = minimmum;
        this.maximum = maximum;
    }

    public String getMinimmum() {
        return minimmum;
    }

    public void setMinimmum(String minimmum) {
        this.minimmum = minimmum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }
}
