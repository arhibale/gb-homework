package com.arhibale.homework.repository;

import com.arhibale.homework.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    SessionFactory sessionFactory = new Configuration()
            .configure("configs/hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    public List<Product> findAll() {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> productList = session.createNamedQuery("Product.findAll", Product.class).getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    public Product findById(Long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            Product product = session.createNamedQuery("Product.findById", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    public void deleteById(Long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.remove(product);
            session.getTransaction().commit();
        }
    }

    public void save(Product product) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }
}
