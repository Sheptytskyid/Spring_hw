package ua.petshop.dao;

import org.springframework.stereotype.Repository;
import ua.petshop.model.Product;

import java.util.List;

@Repository
public interface ProductsDao {

    void addProduct(Product product);

    List<Product> getAll();

    Product getById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product);

}
