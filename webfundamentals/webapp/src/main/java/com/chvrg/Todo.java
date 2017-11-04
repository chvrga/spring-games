package com.chvrg;

public class Todo {
	private String description;
	private int priority;

	public Todo(String d, int p) {
		description = d;
		priority = p;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
