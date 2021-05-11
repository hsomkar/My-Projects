package com.te.todoapp.entities;

import java.util.Date;

import lombok.Data;
@Data
public class Todo {
	private String todoTitle;
	private String todoContent;
	private Date todoDate;
}
