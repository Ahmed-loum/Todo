package com.unchk.todo.service;

import com.unchk.todo.model.Status;
import com.unchk.todo.model.Task;
import com.unchk.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void markAsCompleted(Long id) {
        Task task = getTaskById(id);
        task.setStatus(Status.TERMINE);
        repository.save(task);
    }
}