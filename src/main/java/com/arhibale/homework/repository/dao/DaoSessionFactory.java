package com.arhibale.homework.repository.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoSessionFactory {

    private final SessionFactory sessionFactory;

    public DaoSessionFactory() {
        sessionFactory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public <T> List<T> getAll(String str, Class<T> cls) {
        try(Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                List<T> list = session.createNamedQuery(str, cls).getResultList();
                session.getTransaction().commit();
                return list;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

    public <T> T getById(String str, Class<T> cls, String setParameter, Long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                T t = session.createNamedQuery(str, cls)
                        .setParameter(setParameter, id)
                        .getSingleResult();
                session.getTransaction().commit();
                return t;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

    public <T> List<T> getByIdList(String str, Class<T> cls, String setParameter, Long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                List<T> list = session.createNamedQuery(str, cls).setParameter(setParameter, id).getResultList();
                session.getTransaction().commit();
                return list;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

    public <T> void deleteById(Class<T> cls, Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                T t = session.get(cls, id);
                session.remove(t);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }

    public <T> void save(T t) {
        try(Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.save(t);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }

    public <T> void update(T t) {
        try(Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.update(t);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }

    public void shutdown() {
        sessionFactory.close();
    }
}
