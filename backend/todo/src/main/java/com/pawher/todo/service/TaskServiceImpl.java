package com.pawher.todo.service;

import com.pawher.todo.dao.TaskDAO;
import com.pawher.todo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pawcio on 2019-01-09.
 */

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public List<Task> getAllTasks() {
        return taskDAO.findAll();
    }

    @Override
    public void create(Task task) {
        taskDAO.save(task);
    }

    @Override
    public Optional<Task> findOne(long id) {
        return taskDAO.findById(id);
    }

    @Override
    public void deleteOne(long id) {
         taskDAO.deleteById(id);
    }
}
