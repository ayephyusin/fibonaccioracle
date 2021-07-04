package com.java.fibonaccidropwizard.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.fibonaccidropwizard.model.Fibonacci;

@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciController {
	private final Validator validator;
	public FibonacciController(Validator validator) {
		// TODO Auto-generated constructor stub
		this.validator = validator;
	}

	 @POST
	 public Response getEmployees(TestClass c) {
		 //getting fibonacciList
		 List<Integer> fibonacciList = getFibonacci(c.elements);
		 List<Integer> sortedList = getSortedFibonacci(fibonacciList);
		 Fibonacci f = new Fibonacci(fibonacciList, sortedList);
	     return Response.ok(f).build();
	  }
	 
	  
	  private List<Integer> getSortedFibonacci(List<Integer> fibonacciList) {
		// TODO Auto-generated method stub
		  Map<Boolean, List<Integer>> response = fibonacciList.stream()
			        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
		  List<Integer> evens = response.get(true);
		  List<Integer> odds = response.get(false);
		  Collections.sort(evens, Collections.reverseOrder());
		  Collections.sort(odds, Collections.reverseOrder());
		  evens.addAll(odds);
		return evens;
	}

	private List<Integer> getFibonacci(Integer elements) {
		// TODO Auto-generated method stub
	    	List<Integer> fibonacciList = new ArrayList<>();
	    	int n1=0,n2=1,n3,i;
			 fibonacciList.add(n1);
			 fibonacciList.add(n2);
			 for(i=2;i<elements;++i)//loop starts from 2 because 0 and 1 are already printed  
			 {  
			  n3=n1+n2;   
			  fibonacciList.add(n3);
			  n1=n2;  
			  n2=n3;  
			 }  
		System.out.println(fibonacciList);
		return fibonacciList;
	}


		public static class TestClass {

	        @JsonProperty("elements")
	        public Integer elements;

	    }
}
