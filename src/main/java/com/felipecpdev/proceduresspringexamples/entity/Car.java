package com.felipecpdev.proceduresspringexamples.entity;

import jakarta.persistence.*;

@NamedStoredProcedureQuery(name = "Car.getTotalCardsbyModelEntity",
        procedureName = "GET_TOTAL_CARS_BY_MODEL", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "model_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_out", type = Integer.class)})
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String model;

    @Column
    private Integer year;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
