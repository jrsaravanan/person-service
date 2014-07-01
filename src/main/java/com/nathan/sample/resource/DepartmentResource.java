package com.nathan.sample.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.nathan.com.v1.Department;
import sample.nathan.com.v1.DepartmentList;
import sample.nathan.com.v1.ObjectFactory;
import sample.nathan.com.v1.Person;

import com.nathan.sample.service.DepartmentService;

/**
 * @author Saravanan Renganathan
 *
 */
@Path("v1/dept")
@Component
public class DepartmentResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentResource.class);
	
    @Autowired
	private DepartmentService departmentService;
    
    @Context
    private UriInfo uriInfo;
    
    public DepartmentResource() {

    }

	/**
	 * Get all the person
	 * @return
	 */
    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getDepartments() {
		
		DepartmentList list = departmentService.getDepartments(uriInfo.getBaseUri().toString());
		ResponseBuilder response = Response.ok();
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<DepartmentList> referenceObject = factory.createDepartmentList(list);
		
		return response.entity(referenceObject).build();
		
    }
	
    
    /**
	 * Get all the person
	 * @return
	 */
    @Path("/{id}")
   @GET
   @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public Response getDepartment(@PathParam("id") final int id) {
		
		Department refObj = departmentService.getDepartment(id);
		refObj.setHref(uriInfo.getAbsolutePath().toASCIIString());
		ResponseBuilder response = Response.ok();
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<Department> referenceObject = factory.createDepartment(refObj);
		
		return response.entity(referenceObject)
				.build();
		
   }
    
    /**
     * create a new person
     * @param person
     * @return
     */
    @POST
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response saveDepartment(Department department) {
		
    	LOGGER.info("department " + department.getDescription() );
    	LOGGER.info("department id  " + department.getName()  );
		Department dept = departmentService.save(department);
		ResponseBuilder response = Response.ok();
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<Department> referenceObject = factory.createDepartment(dept);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(String.valueOf(dept.getId()));
		
		return response.entity(referenceObject)
				.contentLocation(uriBuilder.build())
				.build();
		
    }
     
}