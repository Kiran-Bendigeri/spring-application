package com.ben.springapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ben.springapplication.dto.Todo;
import com.ben.springapplication.service.TodoService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/apiv1/todo")
@SessionAttributes({"name"})
public class TodoController {
	
	private TodoService todoservice;
	private WelcomeController webController;
	
	public TodoController(TodoService todoservice, WelcomeController webController) {
		this.todoservice = todoservice;
		this.webController = webController;
	}
	
	@RequestMapping(value="/todos-list", method=RequestMethod.GET)
	public String getTodos(ModelMap model){
		List<Todo> list = todoservice.getTodos();
		model.put("todos", list);
		return "todos-list";
	}
	
	@RequestMapping(value="add-todos", method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
		Todo todo = new Todo(0, getLoggedInUserName(), "", LocalDate.now().plusYears(1), false);
		model.addAttribute("todo", todo);
		return "add-todo";
	}

	private String getLoggedInUserName() {
		return webController.getLoggedInUsername();
	}
	
	@RequestMapping(value="add-todos", method=RequestMethod.POST)
	public String showTodoList(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "add-todo";
		}
		todoservice.addTodo(getLoggedInUserName(), todo.getDescription());
		return "redirect:todos-list";
	}
	
	@RequestMapping(value="delete-todo", method=RequestMethod.GET)
	public String deleteById(@RequestParam("id") Integer id) {
		todoservice.deleteById(id);
		return "redirect:todos-list";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showTodoPage(@RequestParam("id") Integer id, ModelMap model) {
		Todo todo = todoservice.findById(id);
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "add-todo";
		}
		todo.setName(getLoggedInUserName());
		todoservice.updateTodo(todo);
		return "redirect:todos-list";
	}

}
