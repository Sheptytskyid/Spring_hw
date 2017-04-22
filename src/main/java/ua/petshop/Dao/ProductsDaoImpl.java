package ua.petshop.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.petshop.model.Product;

import java.util.List;

@Repository
public class ProductsDaoImpl implements ProductsDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> list = session.createQuery("from Product").list();
        return list;
    }

    public Product getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        return product;
    }

    public void deleteProduct(long id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = getById(id);
        session.delete(product);
    }

    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }
}
