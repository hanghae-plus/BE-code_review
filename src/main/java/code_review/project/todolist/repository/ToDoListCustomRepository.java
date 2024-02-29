package code_review.project.todolist.repository;

import code_review.project.todolist.presentation.ToDoListResponse;
import java.util.List;

public interface ToDoListCustomRepository {
	List<ToDoListResponse> findAllToDoList();
}
