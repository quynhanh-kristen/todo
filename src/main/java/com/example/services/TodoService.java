package com.example.services;

import com.example.model.ToDo;

import java.util.List;

public interface TodoService {
    List<ToDo> getTodos();
    ToDo getTodoById(Long id);

    ToDo insert(ToDo todo);

    void updateTodo(Long id, ToDo todo);

    void deleteTodo(Long todoId);
}
