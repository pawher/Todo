package com.pawher.todo.service;

import com.pawher.todo.entity.Task;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Pawcio on 2019-01-09.
 */
public interface TaskService {

    List<Task> getAllTasks();
}
