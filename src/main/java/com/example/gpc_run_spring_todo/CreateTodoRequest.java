package com.example.gpc_run_spring_todo;

class CreateTodoRequest {
    private String description;

    public CreateTodoRequest(String description) {
        this.description = description;
    }

    public CreateTodoRequest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
