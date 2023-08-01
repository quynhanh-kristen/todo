package com.example.controllers;

import com.example.model.ToDo;
import com.example.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getTodos() {
        List<ToDo> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping({"/{todoId}"})
    public ResponseEntity<ToDo> getTodo(@PathVariable Long todoId) {
        return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
    }



}
