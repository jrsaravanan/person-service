package com.nathan.sample.resource.api;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

 

public class ApiOriginFilter implements ContainerResponseFilter {
    @Override
    public ContainerResponse filter(ContainerRequest creq, ContainerResponse cresp) {
        cresp.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
        cresp.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        cresp.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization, api_key");
        return cresp;
    }
}

