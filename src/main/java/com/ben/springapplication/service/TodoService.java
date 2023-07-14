package com.ben.springapplication.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.ben.springapplication.dto.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todo = new ArrayList<>();
	private static Integer counter = 0;
	
	static {
		todo.add(new Todo(++counter, "Kiran", "Advance Java", 
							LocalDate.now().plusMonths(2), false));
		todo.add(new Todo(++counter, "Kiran", "Microservice", 
				LocalDate.now().plusMonths(5), false));
		todo.add(new Todo(++counter, "Kiran", "AWS", 
				LocalDate.now().plusMonths(5), false));
		todo.add(new Todo(++counter, "Kiran", "Docker", 
				LocalDate.now().plusMonths(6), false));
		todo.add(new Todo(++counter, "Kiran", "Kubernetes", 
				LocalDate.now().plusMonths(6), false));
	}
	
	public List<Todo> getTodos(){
		return todo;
	}
	
	public boolean addTodo(String username, String description) {
		Todo tudu = new Todo(++counter, username, description, LocalDate.now().plusMonths(2), false);
		return todo.add(tudu);
	}
	
	public Todo findByUsername(String username) {
		Predicate<? super Todo> predicate = (t) -> t.getName().equalsIgnoreCase(username);
		return todo.stream().filter(predicate).findFirst().get();
	}
	
	public Todo findById(Integer id) {
		Predicate<? super Todo> predicate = (t) -> t.getId() == id;
		return todo.stream().filter(predicate).findFirst().get();
	}

	public void deleteById(Integer id) {
		Predicate<? super Todo> predicate = (t) -> t.getId() == id;
		todo.removeIf(predicate);		
	}

	public boolean updateTodo(@Valid Todo t) {
		deleteById(t.getId());
		return todo.add(t);
	}

}
