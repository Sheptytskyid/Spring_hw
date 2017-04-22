package ua.petshop.Dao;

import org.springframework.stereotype.Repository;
import ua.petshop.model.Product;

import java.util.List;

@Repository
public interface ProductsDao {

    void add(Product product);

    List<Product> getAll();

    Product getById(long id);

    void deleteById(long id);

    void updateById(Product product);

}
