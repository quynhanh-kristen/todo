package com.example.services;

import com.example.model.ToDo;
import com.example.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImp implements TodoService{

    TodoRepository todoRepository;

    public TodoServiceImp(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<ToDo> getTodos() {
        List<ToDo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public ToDo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public ToDo insert(ToDo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, ToDo todo) {
        ToDo todoFromDb = todoRepository.findById(id).get();
        System.out.println(todoFromDb.toString());
        todoFromDb.setTodoStatus(todo.getTodoStatus());
        todoFromDb.setDescription(todo.getDescription());
        todoFromDb.setTitle(todo.getTitle());
        todoRepository.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
