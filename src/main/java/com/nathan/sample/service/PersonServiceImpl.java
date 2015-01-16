package com.nathan.sample.service;

import java.net.URI;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.httpclient.HttpStatus;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.nathan.com.v1.Address;
import sample.nathan.com.v1.AddressList;
import sample.nathan.com.v1.Person;
import sample.nathan.com.v1.PersonList;

import com.mysql.jdbc.log.Log;
import com.nathan.sample.app.domain.repository.GenericHibernateRepository;
import com.nathan.sample.app.person.domain.entity.DepartmentEntity;
import com.nathan.sample.app.person.domain.entity.PersonEntity;
import com.sun.jersey.api.NotFoundException;

/**
 * Implementation {@link PersonService}
 * This class contains all the business logics and the interaction to the database
 * 
 * Transaction injected from this layer
 * @author Saravanan
 *
 */
@Service("PersonServiceDAO")
@Transactional
public class PersonServiceImpl implements PersonService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	private GenericHibernateRepository<PersonEntity, Long> personDAO;

	@Autowired
	private DozerBeanMapper mapper;
	
	@Context
	private UriInfo uriInfo;

	private GenericHibernateRepository<DepartmentEntity, Long> departmentDAO;

	 
	@Autowired
	public PersonServiceImpl(SessionFactory sessionFactory) {
		personDAO = new GenericHibernateRepository<PersonEntity, Long>(sessionFactory) {
		};
		
		departmentDAO = new GenericHibernateRepository<DepartmentEntity, Long>(sessionFactory) {
		};
	}
	
	@Override
	public sample.nathan.com.v1.Person getPerson(int id) {
		PersonEntity entity = personDAO.findByAttribute("id", new Long(id));
		
		if (null == entity) {
			 throw new NotFoundException("Person id [" + id +"] not found");
		}
		return mapper.map(entity, Person.class);
	}

	/** update Person details
	 * 
	 */
	@Override
	public Person savePerson(Person person) {
		PersonEntity personEntity = null;
		
		try {
			personEntity = mapper.map(person, PersonEntity.class);
			System.out.println( "ref department >> " + person.getDepartment().getName());
			System.out.println( "department >> " + personEntity.getDepartment().getName());
			
			DepartmentEntity department = departmentDAO.findByAttribute("name",  person.getDepartment().getName());
			if (null == department) {
				department = mapper.map(personEntity.getDepartment(), DepartmentEntity.class);
				departmentDAO.save(department);
			}
			personEntity.setDepartment(department);
			personDAO.save(personEntity);
			
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
		return mapper.map(personEntity, Person.class);
	}

	@Override
	public PersonList getPerson(final String uri) {
		
		List<PersonEntity> entityList = personDAO.findAll();
		PersonList personList = new PersonList();
		for (PersonEntity entity : entityList) {
			Person person = mapper.map(entity, Person.class);
			person.setHref(uri + "v1/person/" + person.getId());
			person.getDepartment().setHref(uri + "v1/dept/" + person.getDepartment().getId());
			personList.getPerson().add(person);
		}
		 
		return personList;
	}

	 
	
	
	 
}
