//package com.java.fibonaccidropwizard.controller;
//
//import java.util.ArrayList;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.Invocation;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//
//@Produces(MediaType.TEXT_PLAIN)
//@Path("/client/")
//public class FibonacciRestController {
//
//	private Client client;
//	 
//    public FibonacciRestController(Client client) {
//        this.client = client;
//    }
//     
//    @GET
//    @Path("/employees/")
//    public String getEmployees()
//    {
//        //Do not hard code in your application
//        WebTarget webTarget = client.target("http://localhost:8080/employees");;
//        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
//        Response response = invocationBuilder.get();
//        @SuppressWarnings("rawtypes")
//        ArrayList employees = response.readEntity(ArrayList.class);
//        return employees.toString();
//    }
//    
//  
//}
