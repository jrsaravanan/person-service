package com.nathan.sample.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.apache.commons.httpclient.HttpStatus;
import org.dozer.DozerBeanMapper;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.nathan.com.v1.Department;
import sample.nathan.com.v1.DepartmentList;

import com.nathan.sample.app.domain.repository.GenericHibernateRepository;
import com.nathan.sample.app.person.domain.entity.DepartmentEntity;
import com.sun.jersey.api.NotFoundException;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	private GenericHibernateRepository<DepartmentEntity, Long> departmentDAO;

	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired
	public DepartmentServiceImpl(SessionFactory sessionFactory) {
		departmentDAO = new GenericHibernateRepository<DepartmentEntity, Long>(sessionFactory) {
		};
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public DepartmentList getDepartments(final String uri) {
		
		List<DepartmentEntity> list = departmentDAO.findAll();
		
		DepartmentList departmentList = new DepartmentList();
		for (DepartmentEntity department : list) {
			sample.nathan.com.v1.Department refObject = mapper.map(department, sample.nathan.com.v1.Department.class);
			refObject.setHref(uri + "v1/dept/" + refObject.getId());
			departmentList.getDepartment().add(refObject);
		}
		
		return departmentList;
	}

	@Override
	public sample.nathan.com.v1.Department getDepartment(int id) {
		
		DepartmentEntity object = departmentDAO.findByAttribute("id", new Long(id));
		
		if ( null == object) {
			throw new NotFoundException("department [" + id +"] not found ");
		}
		sample.nathan.com.v1.Department refObject = mapper.map(object, sample.nathan.com.v1.Department.class);
		return refObject;
	}
	
	@Override
	public sample.nathan.com.v1.Department save(Department department) {
		
		DepartmentEntity entity = null;
		try {
			entity = mapper.map(department, DepartmentEntity.class);
			LOGGER.info(">> dept id -- " + entity.getName());
			entity = departmentDAO.save(entity);
		} catch (Exception e) {
			LOGGER.error("unable to save " , e);
			throw new WebApplicationException(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		}
		return mapper.map(entity, Department.class);
	}

}
