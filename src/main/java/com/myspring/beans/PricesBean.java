package com.myspring.beans;

import com.myspring.models.Prices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PricesBean {


    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPrice(Prices price) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(price);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deletePrice(Prices price) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(price);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updatePrice(Prices price) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(price);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Prices> getAllPrices() {
        List<Prices> prices = new ArrayList<Prices>();
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Prices> criteriaQuery = criteriaBuilder.createQuery(Prices.class);
            Root<Prices> root = criteriaQuery.from(Prices.class);
            prices = session.createQuery(criteriaQuery).list();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return prices;
    }

    public Prices getPriceById(Long id) {
        Prices price = null;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Prices> criteriaQuery = criteriaBuilder.createQuery(Prices.class);
            Root root = criteriaQuery.from(Prices.class);
            Predicate predicate = criteriaBuilder.equal(root.get("id") , id);
            criteriaQuery.where(predicate);
            price = session.createQuery(criteriaQuery).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return price;
    }
}
