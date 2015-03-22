package com.jq.service;

import com.jq.entity.Person;

import java.util.List;

public interface IDataService {
    public int insertPerson(Person person);

    public List<Person> getList();

    public Person getPersonById(int id);

    public int updatePerson(Person person);

    public int deletePersonById(int id);

}