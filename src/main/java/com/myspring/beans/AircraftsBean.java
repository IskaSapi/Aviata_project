package com.myspring.beans;

import com.myspring.models.Aircrafts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AircraftsBean {

    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAircraft(Aircrafts aircraft) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(aircraft);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteAircraft(Aircrafts aircraft) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(aircraft);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateAircraft(Aircrafts aircraft) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(aircraft);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Aircrafts> getAllAircrafts() {
        List<Aircrafts> aircrafts = new ArrayList<Aircrafts>();
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Aircrafts> criteriaQuery = criteriaBuilder.createQuery(Aircrafts.class);
            Root<Aircrafts> root = criteriaQuery.from(Aircrafts.class);
            aircrafts = session.createQuery(criteriaQuery).list();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return aircrafts;
    }

    public Aircrafts getAircraftById(Long id) {
        Aircrafts aircrafts = null;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Aircrafts> criteriaQuery = criteriaBuilder.createQuery(Aircrafts.class);
            Root root = criteriaQuery.from(Aircrafts.class);
            Predicate predicate = criteriaBuilder.equal(root.get("id") , id);
            criteriaQuery.where(predicate);
            aircrafts = session.createQuery(criteriaQuery).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return aircrafts;
    }

    public void deletebyID(Long id){
        Aircrafts aircrafts = getAircraftById(id);
        deleteAircraft(aircrafts);
    }


}
