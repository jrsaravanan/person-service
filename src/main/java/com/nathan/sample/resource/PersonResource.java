package com.nathan.sample.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.nathan.com.v1.ObjectFactory;
import sample.nathan.com.v1.Person;
import sample.nathan.com.v1.PersonList;

import com.nathan.sample.service.PersonService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("v1/person")
@Component
@Api(value = "/person", description = "Person Details Resource / Person Operations")
public class PersonResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);
    @Autowired
	private PersonService personService;
    
    @Context
    private UriInfo uriInfo;
    
    public PersonResource() {

    }

	@Path("{id}")
    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Get Person Details By Id", notes = "Id is unique person identification number", response = String.class)
    @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Person Detail not found for the id ") 
    })
    public Response getPerson(@PathParam("id")  final int id) {
		
		ResponseBuilder response = Response.ok();
		ObjectFactory factory = new ObjectFactory();
		
		System.out.println(">> URI Absolute Path " + uriInfo.getAbsolutePath().toASCIIString());
		System.out.println(">> URI base Path " + uriInfo.getBaseUri());
		Person person = personService.getPerson(id);
		person.setHref(uriInfo.getAbsolutePath().toASCIIString());
		JAXBElement<Person> referenceObject = factory.createPerson(person);
		
		return response.entity(referenceObject).build();
		
    }
	
    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Get All Person Details", notes = "List All the persons", response = String.class)
    @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Person Detail not found") 
    })
    public Response getPerson() {
		
		ResponseBuilder response = Response.ok();
		ObjectFactory factory = new ObjectFactory();
		
		PersonList list = personService.getPerson(uriInfo.getBaseUri().toString());
		JAXBElement<PersonList> referenceObject = factory.createPersonList(list);
		
		return response.entity(referenceObject).build();
		
    }
	
    @POST
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Save Person Details", notes = "Save persons", response = String.class)
    @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Person Detail not found") 
    })
    public Response savePerson(Person person) {
		
		ResponseBuilder response = Response.ok();
		ObjectFactory factory = new ObjectFactory();
		
		 person = personService.savePerson(person);
		 JAXBElement<Person> referenceObject = factory.createPerson(person);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(String.valueOf(person.getId()));
		return response.entity(referenceObject)
				.contentLocation(uriBuilder.build())
				.build();
		
    }
	
	@Path("{id}")
    @DELETE
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deletePerson(@PathParam("id")  final int id) {
		
		ResponseBuilder response = Response.ok();
	  
		 
		
		return response.build();
		
    }
	
	
	@Path("/person")
    @PUT
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updatePerson(Person person) {
		
		return savePerson(person);
		
    }
}