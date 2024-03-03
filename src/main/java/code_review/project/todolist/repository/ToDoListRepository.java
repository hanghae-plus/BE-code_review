package code_review.project.todolist.repository;

import code_review.project.todolist.domain.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long>, ToDoListCustomRepository {
	ToDoList findByDescription(@Param("description") String description);
}
