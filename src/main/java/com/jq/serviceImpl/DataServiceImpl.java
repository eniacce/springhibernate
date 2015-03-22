package com.jq.serviceImpl;

import java.util.List;

import com.jq.daoImpl.DataDaoImpl;
import com.jq.entity.Person;
import com.jq.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;


public class DataServiceImpl implements IDataService {

    @Autowired
    DataDaoImpl dataDao;

    @Override
    public int insertPerson(Person person) {
        return dataDao.insertPerson(person);
    }

    @Override
    public List<Person> getList() {
        return dataDao.getList();
    }

    @Override
    public Person getPersonById(int id) {
        return dataDao.getPersonById(id);
    }

    @Override
    public int updatePerson(Person person) {
        return dataDao.updatePerson(person);
    }

    @Override
    public int deletePersonById(int id) {
        return dataDao.deletePersonById(id);
    }

}