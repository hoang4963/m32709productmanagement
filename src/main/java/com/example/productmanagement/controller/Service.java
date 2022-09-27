package com.example.productmanagement.controller;

import com.example.productmanagement.models.Product;

import java.util.List;

public interface Service {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    public interface CustomerService {
        List<Product> findAll();

        void save(Product product);

        Product findById(int id);

        void update(int id, Product product);

        void remove(int id);
    }
}
