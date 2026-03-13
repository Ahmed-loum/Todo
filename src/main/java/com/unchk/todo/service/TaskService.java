package com.unchk.todo.service;

import com.unchk.todo.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task saveTask(Task task);
    Task getTaskById(Long id);
    void deleteTask(Long id);
    void markAsCompleted(Long id);
}