package com.jq.daoImpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import com.jq.dao.IDataDao;
import com.jq.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;



public class DataDaoImpl implements IDataDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public int insertPerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(person);
        tx.commit();
        Serializable id = session.getIdentifier(person);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<Person> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Person> employeeList = session.createQuery("from Person")
                .list();
        session.close();
        return employeeList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.openSession();
        Person person = (Person) session.load(Person.class, id);
        return person;
    }

    @Override
    public int updatePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(person);
        tx.commit();
        Serializable id = session.getIdentifier(person);
        session.close();
        return (Integer) id;
    }

    @Override
    public int deletePersonById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Person person = (Person) session.load(Person.class, id);
        session.delete(person);
        tx.commit();
        Serializable ids = session.getIdentifier(person);
        session.close();
        return (Integer) ids;
    }

}