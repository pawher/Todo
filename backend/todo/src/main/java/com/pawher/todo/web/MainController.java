package com.pawher.todo.web;

import com.pawher.todo.entity.Task;
import com.pawher.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

}
