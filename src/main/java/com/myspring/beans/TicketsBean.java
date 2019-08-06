package com.myspring.beans;

import com.myspring.models.Tickets;
import com.myspring.models.Tickets;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TicketsBean {


    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTickets(Tickets tickets) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(tickets);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteTickets(Tickets tickets) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(tickets);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateTickets(Tickets tickets) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(tickets);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Tickets> getAllTickets() {
        List<Tickets> tickets = new ArrayList<Tickets>();
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Tickets> criteriaQuery = criteriaBuilder.createQuery(Tickets.class);
            Root<Tickets> root = criteriaQuery.from(Tickets.class);
            tickets = session.createQuery(criteriaQuery).list();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return tickets;
    }

    public Tickets getTicketsById(Long id) {
        Tickets tickets = null;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Tickets> criteriaQuery = criteriaBuilder.createQuery(Tickets.class);
            Root root = criteriaQuery.from(Tickets.class);
            Predicate predicate = criteriaBuilder.equal(root.get("id") , id);
            criteriaQuery.where(predicate);
            tickets = session.createQuery(criteriaQuery).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return tickets;
    }
}
