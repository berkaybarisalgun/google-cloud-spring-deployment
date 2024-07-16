package com.example.gpc_run_spring_todo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
class TodoController {

    private final TodoRepository todoRepository;

    TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    void create(@RequestBody CreateTodoRequest request) {
        this.todoRepository.save(new Todo(request.getDescription(), false));
    }

    @GetMapping
    Iterable<Todo> list() {
        return this.todoRepository.findAll();
    }
}
