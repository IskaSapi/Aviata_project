package com.myspring.beans;


import com.myspring.models.Aircrafts;
import com.myspring.models.Countries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CountriesBean {

    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCountry(Countries country) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(country);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteCountry(Countries country) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(country);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateCountry(Countries country) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(country);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Countries> getAllCountries() {
        List<Countries> countries = new ArrayList<Countries>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Countries> criteriaQuery = criteriaBuilder.createQuery(Countries.class);
            Root<Countries> root = criteriaQuery.from(Countries.class);
            countries = session.createQuery(criteriaQuery).list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return countries;
    }

    public Countries getCountryById(Long id) {
        Countries country = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Countries> criteriaQuery = criteriaBuilder.createQuery(Countries.class);
            Root root = criteriaQuery.from(Countries.class);
            Predicate predicate = criteriaBuilder.equal(root.get("id"), id);
            criteriaQuery.where(predicate);
            country = session.createQuery(criteriaQuery).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return country;
    }

    public void deletebyID(Long id){
        Countries countries = getCountryById(id);
        deleteCountry(countries);
    }
}
