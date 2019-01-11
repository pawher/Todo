package com.pawher.todo.web;

import com.pawher.todo.entity.Task;
import com.pawher.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pawcio on 2019-01-09.
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
public class MainController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable long id) {
        return taskService.findOne(id).orElse(null);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(@RequestBody Task task) {
        taskService.create(task);
        Task createdTask = task;
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(createdTask.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        Optional<Task> taskToBeDeleted = taskService.findOne(id);
        if(taskToBeDeleted.isPresent()) {
            taskService.deleteOne(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
