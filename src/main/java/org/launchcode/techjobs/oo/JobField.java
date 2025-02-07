package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    // Fields
    private int id;
    private static int nextId = 1;
    private String value;

    // Constructors
    public JobField(){
        id = nextId;
        nextId++;
    }

    public JobField(String aValue){
        this();
        this.value = aValue;
    }

    public int getId() {
        return id;
    }

    // Getters & Setters

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id && Objects.equals(value, jobField.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
