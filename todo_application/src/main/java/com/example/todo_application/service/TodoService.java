package com.example.todo_application.service;

import com.example.todo_application.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>(); // in-memory database
    private static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount,"Learn Spring Boot",false));
        todos.add(new Todo(++todoCount,"Visit Grocery store",false));
        todos.add(new Todo(++todoCount,"Learn AWS",false));
        todos.add(new Todo(++todoCount,"Swimming",false));
        todos.add(new Todo(++todoCount,"Yoga",false));
    }

    public static List<Todo> findAll(){
        return todos;
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo .getId()==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void addTodo(Todo todo){
        todos.add(todo);
    }

    public void deleteTodo(int id){
        Predicate <? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(int id,Todo newTodo){
        Todo todo = findById(id);
        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.getStatus());
    }

}
