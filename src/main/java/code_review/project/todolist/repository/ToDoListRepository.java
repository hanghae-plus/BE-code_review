package code_review.project.todolist.repository;

import code_review.project.todolist.domain.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}
