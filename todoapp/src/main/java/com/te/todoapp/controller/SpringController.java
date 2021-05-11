package com.te.todoapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.todoapp.entities.Todo;

@Controller
public class SpringController {
	@Autowired
	ServletContext context;

	@GetMapping("/")
	public String getHome(Model m) {
		m.addAttribute("page", "home");
		List<Todo> list=(List<Todo>) context.getAttribute("list");
		m.addAttribute("todos", list);
		return "home";
	}

	@GetMapping("/add")
	public String getAdd(Model m) {
		m.addAttribute("page", "add");
		m.addAttribute("todo", new Todo());
		return "add";
	}

	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") Todo todo, Model m) {
		todo.setTodoDate(new Date());
		System.out.println(todo);
		List<Todo> list = (List<Todo>) context.getAttribute("list");// get the todo list of context
		list.add(todo);
		m.addAttribute("message", "Successfully added");
		return "home";
	}
}
