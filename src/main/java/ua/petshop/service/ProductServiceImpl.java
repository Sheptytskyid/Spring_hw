package ua.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.petshop.Dao.ProductsDao;
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
    public void add(Product product) {
        productsDao.add(product);
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
    public void deleteById(long id) {
        productsDao.deleteById(id);
    }
}
