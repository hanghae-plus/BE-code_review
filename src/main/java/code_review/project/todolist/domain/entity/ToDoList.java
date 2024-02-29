package code_review.project.todolist.domain.entity;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import code_review.project.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Getter
public class ToDoList extends BaseTimeEntity<ToDoList, Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "to_do_list_id")
	private Long id;

	private String description;

	private Boolean isCompleted;

	private LocalDateTime completedTime;

	public void changeCompleted(Boolean completed) {
		this.isCompleted = completed;
	}
}
