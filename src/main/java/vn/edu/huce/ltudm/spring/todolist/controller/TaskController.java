package vn.edu.huce.ltudm.spring.todolist.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.huce.ltudm.spring.todolist.entity.Task;
import vn.edu.huce.ltudm.spring.todolist.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping(path="/all")
    public Collection<Task> list() {
        return taskService.getTasks();
    }

    @GetMapping(path="/completed")
    public Collection<Task> listCompleted() {
        return taskService.getTasksByStatus(1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) {
        Task t = taskService.getTaskByID(id);
        if (t == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.print(t.getContent());
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Task input) {
        taskService.updateTask(id, input);
        return new ResponseEntity<>(null, HttpStatus.valueOf(303)); 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Task input) {
        taskService.createTask(input);
        return new ResponseEntity<>(null, HttpStatus.valueOf(201)); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(null, HttpStatus.valueOf(204)); 
    }
}