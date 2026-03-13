package com.unchk.todo.controller;

import com.unchk.todo.model.Task;
import com.unchk.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        model.addAttribute("task", new Task());
        return "index";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        service.saveTask(task);
        return "redirect:/";
    }

    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        service.markAsCompleted(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = service.getTaskById(id);
        model.addAttribute("task", task);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "redirect:/";
    }
}