package code_review.project.todolist.domain.entity;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import code_review.project.common.BaseTimeEntity;
import code_review.project.todolist.domain.dto.in.ChangeToDoListRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Getter
@ToString
public class ToDoList extends BaseTimeEntity<ToDoList, Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "to_do_list_id")
	private Long id;

	private String description;

	@Enumerated(STRING)
	private CompletionStatus isCompleted;

	private LocalDateTime completedTime;

	public void changeDescription(String description) {
		this.description = description;
	}

	public void changeCompletion(ChangeToDoListRequest request) {
		this.isCompleted = request.getStatus();
		this.completedTime = request.getCompletedTime();
	}
}
