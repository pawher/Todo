package com.pawher.todo.service;

import com.pawher.todo.dao.TaskDAO;
import com.pawher.todo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
