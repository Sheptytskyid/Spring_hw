package ua.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.petshop.dao.ProductsDao;
import ua.petshop.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductsService {

    private ProductsDao productsDao;

    @Autowired
    public ProductServiceImpl(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Transactional
    public void addProduct(Product product) {
        productsDao.save(product);
    }

    @Transactional
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        productsDao.findAll().forEach(products::add);
        return products;
    }

    @Transactional
    public Product getById(long id) {
        return productsDao.findOne(id);
    }

    @Transactional
    public void deleteProduct(long id) {
        productsDao.delete(id);
    }

    @Transactional
    public void updateProduct(Product product) {
        productsDao.save(product);
    }
}
