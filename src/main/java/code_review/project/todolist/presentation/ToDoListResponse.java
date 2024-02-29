package code_review.project.todolist.presentation;

import code_review.project.todolist.domain.entity.ToDoList;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoListResponse {
	private String description;
	private Boolean isCompleted;
	private LocalDateTime completedTime;

	public static ToDoListResponse of(ToDoList entity) {
		return ToDoListResponse.builder()
			.description(entity.getDescription())
			.isCompleted(entity.getIsCompleted())
			.completedTime(entity.getCompletedTime())
			.build();
	}
}
