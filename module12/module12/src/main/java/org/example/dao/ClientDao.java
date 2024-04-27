package org.example.dao;

import org.example.model.Client;
import org.example.service.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }

    public Client findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            client = session.merge(client);
            tx.commit();
        }
    }

    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
        }
    }
}