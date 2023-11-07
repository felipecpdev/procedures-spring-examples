package com.felipecpdev.proceduresspringexamples.entity;


import java.io.Serializable;

public class CarDTO implements Serializable {

    private String model;
    private Integer year;

    public CarDTO() {
    }

    public CarDTO(Object[] object) {
        this.model = (String) object[0];
        this.year = (Integer) object[1];
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
