package org.example.todoapispringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todoList;


    private TodoService todoService;
    private TodoService todoService2;

    public TodoController(@Qualifier("anotherFakeTodoService") TodoService todoService, @Qualifier("fakeTodoService") TodoService todoService2) {
        this.todoService = todoService;
        this.todoService2 = todoService2;
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, true, "Todo 2", 1));
        todoList.add(new Todo(2, false, "Todo 2", 2));
        todoList.add(new Todo(3, true, "Todo 3", 3));
    }


    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newTodo);
    }


    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false) Boolean isCompleted) {
        if (isCompleted == null) {
            System.out.println(todoService.doSomething());
            System.out.println(todoService2.doSomething());
            return ResponseEntity.ok(todoList);
        } else {
            if (isCompleted) {
                return ResponseEntity.ok(todoList
                        .stream()
                        .filter(Todo::isCompleted)
                        .collect(Collectors.toList()));
            } else {
                return ResponseEntity.ok(todoList
                        .stream()
                        .filter((todo -> !todo.isCompleted()))
                        .collect(Collectors.toList()));
            }
        }
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long todoId) {
        for (Todo todo : todoList) {
            if (todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }
        }
        throw new ResourceNotFoundException("Todo item with ID " + todoId + " not found");
    }

}
