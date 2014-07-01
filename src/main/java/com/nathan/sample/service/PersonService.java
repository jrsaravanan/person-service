package com.nathan.sample.service;

import sample.nathan.com.v1.Person;
import sample.nathan.com.v1.PersonList;

/**
 * Person Business components 
 * This interface will be exposed to resources , Has the basic operations to interact with the persistence layer
 * 
 * @author Saravanan Renganathan
 *
 */
public interface PersonService {
	
	/**
	 * get all persons
	 */
	PersonList getPerson(String uri);
	
	/**
	 * get a person detail
	 */
	Person getPerson(int id);
	
	/**
	 * save or update person details
	 */
	Person savePerson(Person person);
	 
	

}
