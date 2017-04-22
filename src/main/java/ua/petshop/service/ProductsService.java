package ua.petshop.service;

import ua.petshop.model.Product;

import java.util.List;

public interface ProductsService {

    void addProduct(Product product);

    List<Product> getAll();

    Product getById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product);

}
