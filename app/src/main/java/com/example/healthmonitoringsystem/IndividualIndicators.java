package com.example.healthmonitoringsystem;

import java.util.Date;

public class IndividualIndicators {
    private int topPressure;
    private int lowerPressure;
    private int pulse;
    private boolean tachycardia;
    private Date date;

    public IndividualIndicators(int topPressure, int lowerPressure, int pulse, boolean tachycardia, Date date) {
        this.topPressure = topPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

    public int getTopPressure() {
        return topPressure;
    }

    public void setTopPressure(int topPressure) {
        this.topPressure = topPressure;
    }

    public int getLowerPressure() {
        return lowerPressure;
    }

    public void setLowerPressure(int lowerPressure) {
        this.lowerPressure = lowerPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }

    public void setTachycardia(boolean tachycardia) {
        this.tachycardia = tachycardia;
    }

    public Date getDateofmeasurement() {
        return date;
    }

    public void setDateofmeasurement(Date dateofmeasurement) {
        this.date = dateofmeasurement;
    }
}
