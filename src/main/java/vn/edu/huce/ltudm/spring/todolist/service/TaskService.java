package vn.edu.huce.ltudm.spring.todolist.service;

import java.util.Collection;
import vn.edu.huce.ltudm.spring.todolist.entity.Task;

public interface TaskService {
    public abstract Task getTaskByID(Long id);
    public abstract void createTask(Task task);
    public abstract void updateTask(Long id, Task task);
    public abstract void deleteTask(Long id);
    public abstract Collection<Task> getTasks();
    public abstract Collection<Task> getTasksByStatus(Integer status);
}