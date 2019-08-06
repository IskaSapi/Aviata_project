package com.myspring.beans;

import com.myspring.models.Countries;
import com.myspring.models.Flights;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FlightsBean {

    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addFlight(Flights flight) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteFlight(Flights flight) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(flight);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateFlight(Flights flight) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(flight);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Flights> getAllFlights() {
        List<Flights> flights = new ArrayList<Flights>();
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Flights> criteriaQuery = criteriaBuilder.createQuery(Flights.class);
            Root<Flights> root = criteriaQuery.from(Flights.class);
            flights = session.createQuery(criteriaQuery).list();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flights;
    }

    public Flights getFlightById(Long id) {
        Flights flight = null;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Flights> criteriaQuery = criteriaBuilder.createQuery(Flights.class);
            Root root = criteriaQuery.from(Flights.class);
            Predicate predicate = criteriaBuilder.equal(root.get("id") , id);
            criteriaQuery.where(predicate);
            flight = session.createQuery(criteriaQuery).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flight;
    }


    public void deletebyID(Long id){
        Flights flights = getFlightById(id);
        deleteFlight(flights);
    }

}
