package com.nathan.sample.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

@Path("v1/hello")
@Component
@Api(value = "/hello", description = "Say Hello World")
public class HelloResource {

    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Hello World Method", notes = "More notes about this method", response = String.class)
    @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Hello not found") 
    })
    public String getHello() {
        return "Hello, World";
    }
}