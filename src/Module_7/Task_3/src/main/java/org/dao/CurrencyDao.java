package org.dao;

import jakarta.persistence.EntityManager;
import org.datasource.MariaDBJPAConnection;
import org.entity.Currency;

import java.util.List;

public class CurrencyDao {

    public String persist(Currency curr) {
        Currency exists = find(curr.getAbbreviation());
        if (exists != null) {
            update(curr);
            return "Currency updated";
        }
        try {
            EntityManager em = MariaDBJPAConnection.getInstance();
            em.getTransaction().begin();
            em.persist(curr);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";
    }

    public Currency find(String abbreviation) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        Currency curr = em.find(Currency.class, abbreviation);
        return curr;
    }

    public List<Currency> findAll() {
        EntityManager em = MariaDBJPAConnection.getInstance();
        List<Currency> currs = em.createQuery("select e from Currency e").getResultList();
        return currs;
    }

    public void update(Currency curr) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        em.getTransaction().begin();
        em.merge(curr);
        em.getTransaction().commit();
    }

    public void delete(Currency curr) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        em.getTransaction().begin();
        em.remove(curr);
        em.getTransaction().commit();
    }
}