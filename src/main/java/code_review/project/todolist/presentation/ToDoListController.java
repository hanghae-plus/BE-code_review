package code_review.project.todolist.presentation;

import code_review.project.todolist.application.ToDoListService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
@Slf4j
public class ToDoListController {

	private final ToDoListService toDoListService;

	@GetMapping
	public ResponseEntity<List<ToDoListResponse>> findToDoList() {
		return ResponseEntity.ok(toDoListService.findToDoList());
	}

	@PostMapping
	public ResponseEntity<String> registerToDoList(String description) {
		return ResponseEntity.ok(toDoListService.registerToDoList(description));
	}

	@PatchMapping("/{todoId}/change")
	public ResponseEntity<Boolean> changeToDoList(@PathVariable("todoId") String todoId, Boolean isCompleted) {
		return ResponseEntity.ok(toDoListService.changeToDoList(todoId, isCompleted));
	}

	@DeleteMapping("/{todoId}/change")
	public ResponseEntity<Boolean> deleteToDoList(@PathVariable("todoId") String todoId) {
		return ResponseEntity.ok(toDoListService.deleteToDoList(todoId));
	}
}
