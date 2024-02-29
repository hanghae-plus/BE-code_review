package code_review.project.todolist.application;

import static code_review.project.todolist.domain.entity.CompletionStatus.UNCOMPLETED;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import code_review.project.todolist.domain.dto.in.ChangeToDoListRequest;
import code_review.project.todolist.domain.entity.CompletionStatus;
import code_review.project.todolist.domain.entity.ToDoList;
import code_review.project.todolist.domain.dto.in.RegisterToDoListRequest;
import code_review.project.todolist.domain.dto.out.ToDoListResponse;
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
		return toDoListRepository.findAllToDoList();
	}

	public String registerToDoList(RegisterToDoListRequest request) {
		ToDoList entity = ToDoList.builder()
			.description(request.getDescription())
			.isCompleted(UNCOMPLETED)
			.build();
		toDoListRepository.save(entity);
		return entity.getDescription();
	}

	public CompletionStatus changeToDoList(String todoId, ChangeToDoListRequest request) {
		ToDoList entity = toDoListRepository.findById(Long.valueOf(todoId))
			.orElseThrow(() -> new IllegalArgumentException("할일 목록이 존재하지 않습니다."));
		entity.changeCompletion(request);
		return entity.getIsCompleted();
	}

	public Boolean deleteToDoList(String todoId) {
		ToDoList entity = toDoListRepository.findById(Long.valueOf(todoId))
			.orElseThrow(() -> new IllegalArgumentException("할일 목록이 존재하지 않습니다."));
		toDoListRepository.delete(entity);
		return true;
	}
}
