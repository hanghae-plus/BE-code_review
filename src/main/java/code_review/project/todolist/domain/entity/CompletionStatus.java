package code_review.project.todolist.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CompletionStatus {
	COMPLETED("완료"),
	UNCOMPLETED("미완료");

	private String description;

	public String getCode() {
		return name();
	}
}
