package com.jq.dao;

import com.jq.entity.Person;

import java.util.List;



public interface IDataDao {
    public int insertPerson(Person Person);

    public List<Person> getList();

    public Person getPersonById(int id);

    public int updatePerson(Person person);

    public int deletePersonById(int id);

}  