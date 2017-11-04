package com.chvrg;

import java.util.*;

public class User {

	private String name;
	private String email;
	
	private List<Todo> todos = new ArrayList<Todo>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Todo> getTodos() {
		return todos;
	}
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	
	public void addTodo(String desc, int p) {
		this.todos.add(new Todo(desc, p));
	}
}
