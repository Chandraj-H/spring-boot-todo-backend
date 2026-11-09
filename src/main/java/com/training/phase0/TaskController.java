package com.training.phase0;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//3
//Controller

@RestController
public class TaskController {

    private final JdbcTemplate jdbcTemplate;    //final so that it is not accidentally changed by other part of code.
    private final TaskResponseMapper taskResponseMapper = new TaskResponseMapper();

    public TaskController(JdbcTemplate jdbcTemplate) {  // jdbc template supplied by spring, but you have to save the instance, else constructor exits and the parameter is discarded.
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/tasks")
    public List<TaskResponse> getTasks(){
        return jdbcTemplate.query("SELECT id, title, done, created_at FROM tasks ORDER BY id ASC;", taskResponseMapper);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody CreateTaskRequest createTaskRequest){

        if (createTaskRequest.title() == null || createTaskRequest.title().isBlank()){
            return ResponseEntity.badRequest().body(Map.of("error", "title can't be null, empty string or string of whitespaces"));
        }
        TaskResponse taskResponse = jdbcTemplate.queryForObject("INSERT INTO tasks (title) VALUES (?) RETURNING id, title, done, created_at", taskResponseMapper, createTaskRequest.title());

        return new ResponseEntity<>(taskResponse, HttpStatus.CREATED);
    }
}
