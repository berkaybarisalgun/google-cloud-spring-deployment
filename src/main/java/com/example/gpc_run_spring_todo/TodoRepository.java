package com.example.gpc_run_spring_todo;

import org.springframework.data.repository.CrudRepository;

interface TodoRepository extends CrudRepository<Todo, Integer> {}
