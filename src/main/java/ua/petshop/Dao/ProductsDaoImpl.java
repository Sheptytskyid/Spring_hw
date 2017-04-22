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

    public void add(Product product) {
        Session session = sessionFactory.openSession();
        session.persist(product);
    }

    public List<Product> getAll() {
        Session session = sessionFactory.openSession();
        List<Product> list = session.createSQLQuery("select * from products;").list();
        return list;
    }

    public Product getById(long id) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        return product;
    }

    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        Product product = getById(id);
        session.delete(product);
    }

    public void updateById(Product product) {
        Session session = sessionFactory.openSession();
        session.update(product);
    }
}
