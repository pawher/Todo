package com.pawher.todo.service;

import com.pawher.todo.entity.Task;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pawcio on 2019-01-09.
 */
public interface TaskService {

    List<Task> getAllTasks();
    void create(Task task);
    Optional<Task> findOne(long id);
    void deleteOne(long id);
}
