package com.myspring.beans;

import com.myspring.models.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RoleBean {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addRole(Roles role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
        session.close();
    }

    public List<Roles> getAllRoles() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Roles> query = criteriaBuilder.createQuery(Roles.class);
        Root<Roles> root = query.from(Roles.class);
        List<Roles> allRoles = session.createQuery(query).getResultList();
        session.close();
        return allRoles;
    }

    public void deleteRole(Long id) {
        Roles role = new Roles();
        role.setId(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();
    }

    public Roles getRole(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Roles> query = criteriaBuilder.createQuery(Roles.class);
        Root<Roles> root = query.from(Roles.class);
        Roles roles = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return roles;
    }

    public void saveRoles(Roles roles) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(roles);
        transaction.commit();
        session.close();
    }

}
