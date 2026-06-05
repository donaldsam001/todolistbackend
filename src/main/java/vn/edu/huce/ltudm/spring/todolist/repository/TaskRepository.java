package vn.edu.huce.ltudm.spring.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.huce.ltudm.spring.todolist.entity.Task;
import java.util.Collection;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Collection<Task> findByStatus(Integer status);
}