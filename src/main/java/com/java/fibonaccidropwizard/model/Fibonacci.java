package com.java.fibonaccidropwizard.model;

import java.util.List;

public class Fibonacci {
	
	private List<Integer> fibonacci;

	private List<Integer> sorted;

	public Fibonacci(List<Integer> fibonacci, List<Integer> sorted) {
		super();
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}

	public List<Integer> getFibonacci() {
		return fibonacci;
	}

	public void setFibonacci(List<Integer> fibonacci) {
		this.fibonacci = fibonacci;
	}

	public List<Integer> getSorted() {
		return sorted;
	}

	public void setSorted(List<Integer> sorted) {
		this.sorted = sorted;
	}
	
	
}
