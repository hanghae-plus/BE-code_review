package code_review.project.todolist.domain.dto.in;

import code_review.project.todolist.domain.entity.CompletionStatus;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class ChangeToDoListRequest {
	private CompletionStatus status;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime completedTime;
}
