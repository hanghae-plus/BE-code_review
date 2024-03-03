package code_review.project.todolist.domain.dto.out;

import code_review.project.todolist.domain.entity.CompletionStatus;
import code_review.project.todolist.domain.entity.ToDoList;
import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoListResponse {
	private Long toDoListId;
	private String description;
	private CompletionStatus isCompleted;
	private LocalDateTime completedTime;

	public static ToDoListResponse of(ToDoList entity) {
		return ToDoListResponse.builder()
			.description(entity.getDescription())
			.isCompleted(entity.getIsCompleted())
			.completedTime(entity.getCompletedTime())
			.build();
	}

	@QueryProjection
	public ToDoListResponse(Long toDoListId, String description, CompletionStatus isCompleted,
		LocalDateTime completedTime) {
		this.toDoListId = toDoListId;
		this.description = description;
		this.isCompleted = isCompleted;
		this.completedTime = completedTime;
	}
}
