package ua.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.petshop.dao.ProductsDao;
import ua.petshop.model.Product;

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
        productsDao.addProduct(product);
    }

    @Transactional
    public List<Product> getAll() {
        return productsDao.getAll();
    }

    @Transactional
    public Product getById(long id) {
        return productsDao.getById(id);
    }

    @Transactional
    public void deleteProduct(long id) {
        productsDao.deleteProduct(id);
    }

    @Transactional
    public void updateProduct(Product product) {
        productsDao.updateProduct(product);
    }
}
