package com.example.productmanagement.models;

public class Product {
    int id;
    String name;
    double cost;
    String description;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, double cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public Product(int id, String name, double cost, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public Product(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
