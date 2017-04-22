package ua.petshop.service;

import ua.petshop.model.Product;

import java.util.List;

public interface ProductsService {

    void add(Product product);

    List<Product> getAll();

    Product getById(long id);

    void deleteById(long id);

//    void updateById(Product product);

}
