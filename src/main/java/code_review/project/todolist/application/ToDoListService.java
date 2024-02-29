package code_review.project.todolist.application;

import static java.util.stream.Collectors.toList;

import code_review.project.todolist.domain.entity.ToDoList;
import code_review.project.todolist.presentation.ToDoListResponse;
import code_review.project.todolist.repository.ToDoListRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ToDoListService {

	private final ToDoListRepository toDoListRepository;


	public List<ToDoListResponse> findToDoList() {
		return toDoListRepository.findAll().stream().map(ToDoListResponse::of).collect(toList());
	}

	public String registerToDoList(String description) {
		ToDoList entity = ToDoList.builder()
			.description(description)
			.isCompleted(false)
			.build();
		toDoListRepository.save(entity);
		return entity.getDescription();
	}

	public Boolean changeToDoList(String todoId, Boolean isCompleted) {
		ToDoList entity = toDoListRepository.findById(Long.valueOf(todoId))
			.orElseThrow(() -> new IllegalArgumentException("할일 목록이 존재하지 않습니다."));
		entity.changeCompleted(isCompleted);
		return entity.getIsCompleted();
	}

	public Boolean deleteToDoList(String todoId) {
		ToDoList entity = toDoListRepository.findById(Long.valueOf(todoId))
			.orElseThrow(() -> new IllegalArgumentException("할일 목록이 존재하지 않습니다."));
		toDoListRepository.delete(entity);
		return true;
	}
}
