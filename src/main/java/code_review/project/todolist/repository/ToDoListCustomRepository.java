package code_review.project.todolist.repository;

import code_review.project.todolist.domain.dto.out.ToDoListResponse;
import java.util.List;

public interface ToDoListCustomRepository {
	List<ToDoListResponse> findAllToDoList();
}
