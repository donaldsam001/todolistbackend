package vn.edu.huce.ltudm.spring.todolist.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.huce.ltudm.spring.todolist.entity.Task;
import vn.edu.huce.ltudm.spring.todolist.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepo;

    @Override
    public Task getTaskByID(Long id) {
        return taskRepo.findById(id).orElse(null); 
    }

    @Override
    public void createTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public void updateTask(Long id, Task task) {
        task.setId(id);
        taskRepo.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Collection<Task> getTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Collection<Task> getTasksByStatus(Integer status) {
        return taskRepo.findByStatus(status);
    }
}