package com.example.elmira.dao;

import com.example.elmira.entity.Contacts;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by elmirabehzad on 14/3/19.
 */
@Repository
public class ContacsDAOHibernateImp implements ContactsDAO {

    //define field for entitymanager

    private EntityManager entiyManager;

    //setup constructor injection

    @Autowired
    public ContacsDAOHibernateImp(EntityManager entiyManager){

        this.entiyManager = entiyManager;
    }


    @Override
    @Transactional
    public List<Contacts> findAll() {

        //get the current hibernate session
        Session currentSession = entiyManager.unwrap(Session.class);

        //create the query

        Query<Contacts> theQuery = currentSession.createQuery("from Contacts", Contacts.class);

        //execute query and get result list

        List<Contacts> contacts = theQuery.getResultList();

        //return the results

        return contacts;
    }
}
