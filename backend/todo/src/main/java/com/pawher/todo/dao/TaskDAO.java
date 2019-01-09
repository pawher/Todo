package com.pawher.todo.dao;

import com.pawher.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pawcio on 2019-01-09.
 */

@Repository
public interface TaskDAO extends JpaRepository<Task, Long>{
}
