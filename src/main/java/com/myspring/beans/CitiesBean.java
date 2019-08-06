package com.myspring.beans;

import com.myspring.models.Cities;
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

public class CitiesBean {

    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCity(Cities city) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteCity(Cities city) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateCity(Cities city) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(city);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Cities> getAllCities() {
        List<Cities> cities = new ArrayList<Cities>();
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Cities> criteriaQuery = criteriaBuilder.createQuery(Cities.class);
            Root<Cities> root = criteriaQuery.from(Cities.class);
            cities = session.createQuery(criteriaQuery).list();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cities;
    }

    public Cities getCityById(Long id) {
        Cities city = null;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Cities> criteriaQuery = criteriaBuilder.createQuery(Cities.class);
            Root root = criteriaQuery.from(Cities.class);
            Predicate predicate = criteriaBuilder.equal(root.get("id") , id);
            criteriaQuery.where(predicate);
            city = session.createQuery(criteriaQuery).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return city;
    }

    public void deletebyID(Long id){
        Cities cities = getCityById(id);
        deleteCity(cities);
    }
}
