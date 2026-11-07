package com.training.phase0;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//3
//Controller

@RestController
public class TaskController {

    @GetMapping("/tasks")
    public List<TaskResponse> getTasks(){
        return new ArrayList<>();
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponse> createTask(@RequestBody CreateTaskRequest createTaskRequest){
        return null;
    }
}
