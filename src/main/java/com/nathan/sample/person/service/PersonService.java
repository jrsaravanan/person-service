package com.nathan.sample.person.service;

import com.nathan.sample.person.domain.entiry.Person;
import com.nathan.sample.person.domain.entiry.PersonList;

/**
 * Basic Contract
 *
 */
public interface PersonService {

	Person savePersonDetails(Person person);

	Person getPerson(String id);

	PersonList getAllPersons();

}
